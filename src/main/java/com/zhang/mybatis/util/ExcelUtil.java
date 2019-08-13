package com.zhang.mybatis.util;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.fastjson.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

/**
 * @ClassName ExcelUtil
 * @Author zhangjiwei
 * @Date 2019/8/13 10:15
 * @Description
 */
public class ExcelUtil {
    public static void main(String[] args) throws FileNotFoundException {
        readExcel();
    }

    private static void readExcel() throws FileNotFoundException {
        String fileName = "E:\\供应链文档\\三期\\费用进度表模板.xlsx";
        InputStream is = new FileInputStream(new File(fileName));
        Sheet sheet = new Sheet(1);
        sheet.setSheetName("极信转售ZSGS");
        String sheetName = sheet.getSheetName();
        System.out.println(sheetName);
        List<Object> data = EasyExcelFactory.read(is, sheet);
        for (Object datum : data) {
            System.out.println(JSONObject.toJSONString(datum));
        }
    }

}
