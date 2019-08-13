package com.zhang.mybatis.ftp;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import java.io.*;

/**
 * @ClassName FtpUtil
 * @Author zhangjiwei
 * @Date 2019/8/2 14:52
 * @Description
 */
public class FtpUtil {
    private FTPClient ftpClient;

    public static void main(String[] args) {
        FtpUtil util = new FtpUtil();
        util.initFtp();
    }

    private void initFtp() {
        ftpClient = new FTPClient();
        ftpClient.setControlEncoding("utf-8");
        try {
            ftpClient.connect("10.115.5.119", 21);
            ftpClient.login("bpc", "bpc@123");
            int code = ftpClient.getReplyCode();
            System.out.println(code);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean uploadFile(String pathName, String fileName, String originFileName) {
        boolean flag = false;
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(new File(originFileName));
            initFtp();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
