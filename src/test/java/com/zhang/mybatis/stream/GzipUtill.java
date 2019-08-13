package com.zhang.mybatis.stream;

import java.io.*;
import java.util.zip.GZIPOutputStream;

/**
 * @ClassName GzipUtill
 * @Author zhangjiwei
 * @Date 2019/7/23 11:41
 * @Description
 */
public class GzipUtill {
    public static void main(String[] args) {
        gzip(new File("E:/pdf/数据结构与算法JAVA语言版.pdf"));
    }

    private static void gzip(File file) {
        if (!file.getName().endsWith(".gz")) {
            File output = new File(file.getParent(), file.getName() + ".gz");
            if (!output.exists()) {
                try (
                        InputStream in = new BufferedInputStream(new FileInputStream(file));
                        OutputStream out = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream(output)))
                ) {
                    int b;
                    while ((b = in.read()) != -1) {
                        out.write(b);
                    }
                    out.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
