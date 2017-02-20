package com.xqq.imagloader.utils;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by xqq on 2017/2/19.
 */

public class CloseUtils {
    private CloseUtils(){}

    /**
     * 关闭Closeable对象
     */
    public static void closeQuietly(Closeable closeable){
        if(null != closeable){
            try{
                closeable.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
