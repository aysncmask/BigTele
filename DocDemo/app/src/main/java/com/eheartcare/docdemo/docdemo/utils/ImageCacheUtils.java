package com.eheartcare.docdemo.docdemo.utils;

import android.graphics.Bitmap;
import android.widget.ImageView;

public class ImageCacheUtils {
	private MemoryCacheUtils memoryCacheUtils;
	private LocalCacheUtils localCacheUtils;
	private NetCacheUtils netCacheUtils;

	public ImageCacheUtils() {
		memoryCacheUtils = new MemoryCacheUtils();
		localCacheUtils = new LocalCacheUtils(memoryCacheUtils);
		netCacheUtils = new NetCacheUtils(memoryCacheUtils,localCacheUtils);
	}

	public void display(ImageView imageView, String url) {
		Bitmap bitmap = null;
		bitmap = memoryCacheUtils.getBitmap(url);
		if (bitmap != null) {
			imageView.setImageBitmap(bitmap);
			return;
		}
		bitmap = localCacheUtils.getBitmap(url);
		if (bitmap != null) {
			imageView.setImageBitmap(bitmap);
			return;
		}
		// 直接访问网络，下载图片，然后展示
		netCacheUtils.display(imageView, url);
	}
}
