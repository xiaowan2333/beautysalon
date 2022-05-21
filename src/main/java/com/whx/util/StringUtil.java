package com.whx.util;

/**
 * @Author: XiaoWan
 * @Date: 2022/5/15 10:56
 */
public class StringUtil {
    public static boolean isNull(String str) {
        if (str == null) {
            return true;
        }
        str = str.trim();//去除空格
        if ("".equals(str)) {
            return true;
        }
        return false;
    }
}
