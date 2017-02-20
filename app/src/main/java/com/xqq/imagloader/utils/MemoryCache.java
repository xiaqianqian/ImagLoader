package com.xqq.imagloader.utils;

import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * Created by xqq on 2017/2/18.
 */

/**
 * 内存缓存
 */
public class MemoryCache implements ImageCache {
    private LruCache<String, Bitmap> mImageCache;

    public MemoryCache(){
        // 初始化LRU缓存
        initImageCache();
    }

    private void initImageCache(){
        // 计算可用的最大内存
        final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        // 取四分之一的可用内存作为缓存
        final int cacheSize = maxMemory / 4;
        mImageCache = new LruCache<String, Bitmap>(cacheSize){
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes() * value.getHeight() / 1024;
            }
        };
    }
    @Override
    public void put(String url, Bitmap bitmap) {
        mImageCache.put(url, bitmap);
    }

    @Override
    public Bitmap get(String url) {
        return mImageCache.get(url);
    }
}
