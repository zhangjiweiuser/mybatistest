package com.zhang.mybatis.inet;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @ClassName InetAddressUtil
 * @Author zhangjiwei
 * @Date 2019/7/23 11:53
 * @Description
 */
public class InetAddressUtil {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName("www.baidu.com");
            System.out.println(address);
            InetAddress address2 = InetAddress.getLocalHost();
            System.out.println(address2.getHostName());
            System.out.println(address2.getHostAddress());
            System.out.println(address.getAddress().length);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
