package com.xqq.imagloader.utils;

/**
 * Created by xqq on 2017/2/19.
 */

public class AddressUtils {
    private AddressUtils(){}

    public static String getFileNameByAddress(String address){
        String fileName = null;
        if(null != address){
            fileName = address.substring(address.lastIndexOf("/"));
        }
        return fileName;
    }
}
