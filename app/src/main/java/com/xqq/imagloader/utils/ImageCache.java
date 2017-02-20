package com.xqq.imagloader.utils;

import android.graphics.Bitmap;

/**
 * Created by xqq on 2017/2/18.
 */

public interface ImageCache {

    public void put(String url, Bitmap bitmap);
    public Bitmap get(String url);
}
