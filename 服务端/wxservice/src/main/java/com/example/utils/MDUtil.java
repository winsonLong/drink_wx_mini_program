package com.example.utils;

import org.springframework.util.DigestUtils;

import java.util.UUID;

public class MDUtil {
    /**
     * 获取加密后的密码
     * @param src 原始密码
     * @return 加密后的密码
     * @see #md5(String)
     */
    public static String getEncrpytedPassword(String src) {
        // 将原密码加密
        String result = md5(src);
        // 将以上结果再加密5次
        for (int i = 0; i < 5; i++) {
            result = md5(result);
        }
        // 返回
        return result;
    }

    /**
     * 获取随机的盐值
     * @return 随机的盐值
     */
    private static String getRandomSalt() {
        return UUID.randomUUID().toString().toUpperCase();
    }

    /**
     * 使用MD5算法对数据进行加密
     * @param src 原文
     * @return 密文
     */
    private static String md5(String src) {
        return DigestUtils.md5DigestAsHex(src.getBytes()).toUpperCase();
    }
}
