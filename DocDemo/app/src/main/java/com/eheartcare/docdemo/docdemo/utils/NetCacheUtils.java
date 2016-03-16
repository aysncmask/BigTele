package com.eheartcare.docdemo.docdemo.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

public class NetCacheUtils {
	private ExecutorService pool;
	private MyHandler handler;
	private final int SUCCESS = 1;
	private LocalCacheUtils localCacheUtils;
	private MemoryCacheUtils memoryCacheUtils;
	public NetCacheUtils(MemoryCacheUtils memoryCacheUtils, LocalCacheUtils localCacheUtils){
		// 初始化线程池
		pool = Executors.newFixedThreadPool(5);
		handler = new MyHandler();
		this.memoryCacheUtils = memoryCacheUtils;
		this.localCacheUtils = localCacheUtils;
	}
	public void display(ImageView imageView, String url) {
		pool.execute(new DownLoadRunnable(imageView,url));
	}
	
	class MyHandler extends Handler{
		@Override
		public void handleMessage(Message msg) {

			
			if(msg.what==SUCCESS){
				Result result = (Result) msg.obj;
				int endPos = (Integer) result.imageView.getTag();
				if(endPos==result.position){
					result.imageView.setImageBitmap(result.bitmap);
				}
			}
		}
	}
	
	class DownLoadRunnable implements Runnable{

		private String url;
		private ImageView imageView;
		private int position;

		public DownLoadRunnable(ImageView imageView, String url) {
			this.url = url;
			this.imageView = imageView;
			position = (Integer) imageView.getTag();
		}

		@Override
		public void run() {
			try {
				Thread.sleep(3000);
				HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
				conn.connect();
				int resCode = conn.getResponseCode();
				if(resCode==200){
					InputStream is = conn.getInputStream();
					Bitmap bitmap = BitmapFactory.decodeStream(is);
					Message.obtain(handler, SUCCESS, new Result(imageView, bitmap ,position)).sendToTarget();
					memoryCacheUtils.putBitmap(url, bitmap);
					localCacheUtils.saveBitmap(url, bitmap);
				}
				
			} catch (Exception e) {
			}
		}
		
	}
	
	class Result{
		public ImageView imageView;
		public Bitmap bitmap;
		public int position;
		public Result(ImageView imageView, Bitmap bitmap, int position) {
			this.imageView = imageView;
			this.bitmap = bitmap;
			this.position = position;
		}
		
	}
}
