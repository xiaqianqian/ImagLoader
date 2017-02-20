package com.xqq.imagloader.utils;

import android.graphics.Bitmap;

/**
 * Created by xqq on 2017/2/18.
 */

/**
 * 双缓存。获取图片时先从内存缓存中获取一份，如果内存中没有缓存该图片，再从SD卡中获取。
 */
public class DoubleCache implements ImageCache {
    private ImageCache mMemoryCache = new MemoryCache();
    private ImageCache mDiskCache = new DiskCache();

    //将图片缓存到内存和SD中
    @Override
    public void put(String url, Bitmap bitmap) {
        mMemoryCache.put(url, bitmap);
        mDiskCache.put(url, bitmap);
    }

    // 先从内存缓存中获取图片，如果没有，再从SD中获取
    @Override
    public Bitmap get(String url) {
        Bitmap bitmap = mMemoryCache.get(url);
        if(bitmap == null ){
            bitmap = mDiskCache.get(url);
        }
        return bitmap;
    }
}
