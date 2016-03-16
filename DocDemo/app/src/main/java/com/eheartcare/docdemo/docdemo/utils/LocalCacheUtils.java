package com.eheartcare.docdemo.docdemo.utils;

import java.io.File;
import java.io.FileOutputStream;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.os.Environment;

public class LocalCacheUtils {
	private String CACHE_DIR;
	private MemoryCacheUtils memoryCacheUtils;

	public LocalCacheUtils(MemoryCacheUtils memoryCacheUtils) {
		CACHE_DIR = Environment.getExternalStorageDirectory().getAbsolutePath();

		this.memoryCacheUtils = memoryCacheUtils;
	}

	public Bitmap getBitmap(String url) {
		Bitmap bitmap = null;
		try {
			String fileName = MD5Encoder.encode(url);
			File file = new File(CACHE_DIR, fileName);// /mnt/sdcard/zhbj77/fdasgsfa
			if (file.exists()) {
				bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
				memoryCacheUtils.putBitmap(url, bitmap);
			}

		} catch (Exception e) {
		}
		return bitmap;
	}

	public void saveBitmap(String url, Bitmap bitmap) {
		try {
			String fileName = MD5Encoder.encode(url);
			File file = new File(CACHE_DIR, fileName);
			File parentFile = file.getParentFile();
			if(!parentFile.exists()){
				parentFile.mkdirs();
			}
			// 把Bitmap保存到文件中
			FileOutputStream fos = new FileOutputStream(file);
			bitmap.compress(CompressFormat.JPEG, 100, fos);

		} catch (Exception e) {
		}
	}

}
