package com.example.senclub;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class TestWeather {
    String location="上海";
    private static String weatherUrl = "http://www.baidu.com/baidu?tn=monline_3_dg&ie=utf-8&wd=上海天气";

    public static void getWeather() {
        String userAgent = UserAgentUtil.getUserAgents();
        try {
            Document doc = Jsoup.connect(weatherUrl).userAgent(userAgent).timeout(5000).get();
            Elements a = doc.getElementsByClass("op_weather4_twoicon").get(0).getElementsByTag("a");

            for (Element element : a) {
                String quality = "";
                String current = "";
                String today = "";

                //只有当天才有实时温度
                if (!element.getElementsByClass("op_weather4_twoicon_shishi_title").isEmpty()) {
                    current = element.getElementsByClass("op_weather4_twoicon_shishi_title").text();
                }
                //空气质量
                if (!element.getElementsByClass("op_weather4_twoicon_aqi_text_today").isEmpty()) {
                    quality = element.getElementsByClass("op_weather4_twoicon_aqi_text_today").text();
                }else {
                    quality = element.getElementsByClass("op_weather4_twoicon_aqi_text").text();
                }
                //日期
                if (!element.getElementsByClass("op_weather4_twoicon_date").isEmpty()) {
                    today = element.getElementsByClass("op_weather4_twoicon_date").text();
                }else {
                    today = element.getElementsByClass("op_weather4_twoicon_date_day").text();
                }
                //风
                String wind = element.getElementsByClass("op_weather4_twoicon_wind").text();
                //天气
                String weath = element.getElementsByClass("op_weather4_twoicon_weath").text();
                //气温
                String temp = element.getElementsByClass("op_weather4_twoicon_temp").text();

                System.out.println(quality);
                System.out.println(current);
                System.out.println(today);
                System.out.println(wind);
                System.out.println(weath);
                System.out.println(temp);
                System.out.println("=============================");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        getWeather();
    }

}
