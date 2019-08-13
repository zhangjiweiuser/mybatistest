package com.zhang.mybatis.url;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @ClassName UrlUtil
 * @Author zhangjiwei
 * @Date 2019/7/23 14:01
 * @Description
 */
public class UrlUtil {
    public static void main(String[] args) {
//        URL u = new URL("http://127.0.0.1:8081/budget/getHalfYearSuggest");
        try {
            URL u = new URL("http://www.baidu.com");
            try {
                URLConnection connection = u.openConnection();
                InputStream in = connection.getInputStream();
                int c;
                while ((c = in.read()) != -1) {
                    System.out.write(c);
                }
            } catch (Exception e) {
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
