package com.example.utils;



import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class CommonUtils {

    public final static String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public final static String SHORT_DATE_FORMAT = "yyyy-MM-dd";

    public final static String NULL_STR = "";

    public final static String BLANK_STR = " ";

    public final static String STAR_STR = "*";

    public final static String UNDERSCORE_STR = "_";

    public final static String SLASH_STR = "/";

    public static final String ENCODING_ISO8859 = "ISO-8859-1";

    public static final String ENCODING_ASCII = "ascii";

    public static final String ENCODING_UTF8 = "utf-8";

    public static final int SECONDS_A_DAY = 24 * 60 * 60;

    public static final int MILLISECONDS_A_DAY = SECONDS_A_DAY * 1000;

    public static final String ENVIRONMENT = "Environment";

    /**
     * 功能描述：获取当前日期时间格式化字符串，默认yyyy-MM-dd HH:mm:ss格式
     */
    public static String getCurrentDateTime() {
        return getCurrentDateTime(DEFAULT_DATE_FORMAT);
    }

    /**
     * 功能描述：获取当前日期时间格式化字符串
     *
     * @param dateFormat 日期时间格式
     */
    public static String getCurrentDateTime(String dateFormat) {
        return DateTimeFormatter.ofPattern(dateFormat).format(LocalDateTime.now());
    }

    /**
     * 功能描述：获取指定日期时间格式化字符串
     *
     * @param dateFormat 日期时间格式
     */
    public static String getDateTime(String dateFormat, Long timestamp) {
        Instant instant = Instant.ofEpochMilli(timestamp);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        return DateTimeFormatter.ofPattern(dateFormat).format(localDateTime);
    }

    /*
     * 功能描述：生成对象的主键
     *
     * @return String
     */
    public static String generateId() {
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();
        id = id.replaceAll("-", "");
        return id;
    }

    /**
     * 生成Openstack的资源名称
     *
     * @param prefix
     * @return
     */
    public static synchronized String generateName(String prefix) {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return prefix + "-" + Long.toHexString((new Date()).getTime());
    }



    public static String generateDateId() {
        Random random = new Random();
        int i = random.nextInt(9999) + 10000;
        String num = String.valueOf(i).substring(1);
        return getCurrentDateTime("yyyyMMddHHmmss") + num;
    }



    /**
     * 用*覆盖内容
     * @param content 内容
     * @return 覆盖后的内容
     */
    private static String coverContent(String content){
        int length = content.length();
        int coverLength = Double.valueOf(Math.floor(length/2)).intValue();
        StringBuilder stringBuilder = new StringBuilder();
        if(coverLength == 0){
            return content;
        }else{
            int halfLength = Double.valueOf(Math.floor((length - coverLength)/2)).intValue();
            for (int i = 0;i < length;i++){
                if(i >= halfLength && (i < (halfLength + coverLength))){
                    stringBuilder.append("*");
                }else{
                    stringBuilder.append(content.charAt(i));
                }
            }
        }
        return stringBuilder.toString();
    }



    /**
     * 判断该字符串是否为中文
     * @param string
     * @return 包含中文返回true，不包含返回false
     */
    public static boolean isChinese(String string){
        int n = 0;
        for(int i = 0; i < string.length(); i++) {
            n = (int)string.charAt(i);
            if(19968 <= n && n <40869) {
                return true;
            }
        }
        return false;
    }
}
