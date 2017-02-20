package com.xqq.imagloader.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by xqq on 2017/2/18.
 */
//SD卡缓存
public class DiskCache implements ImageCache {
    private static String cacheDir = Environment.getExternalStorageDirectory().getAbsolutePath();

    @Override
    public void put(String url, Bitmap bitmap) {
        FileOutputStream fileOutputStream = null;
        try {
            String fileName = AddressUtils.getFileNameByAddress(url);
            File file = new File(cacheDir, fileName);
            if(!file.exists())
                file.createNewFile();
            fileOutputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            CloseUtils.closeQuietly(fileOutputStream);
        }
    }

    @Override
    public Bitmap get(String url) {
        File file = new File(cacheDir + AddressUtils.getFileNameByAddress(url));
        if (file.exists()) {
            return BitmapFactory.decodeFile(cacheDir + AddressUtils.getFileNameByAddress(url));
        } else {
            return null;
        }
    }
}
