package com.test;

import junit.framework.TestCase;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.FileOutputStream;
import java.util.regex.Pattern;

public class FirstTestTest extends TestCase {


    public static final String PATH = "C:\\Users\\DQ\\Desktop\\data\\export\\";
@Test
    public void testMain() throws Exception{
    // 1、创建一个工作簿
    Workbook workbook = new HSSFWorkbook();

   // 2、创建一个工作表
     Sheet sheet = workbook.createSheet("狂神观众统计表");
    // 3、创建一个行 （1,1）
     Row row1 = sheet.createRow(0);
    // 4、创建一个单元格
     Cell cell11 = row1.createCell(0);
     cell11.setCellValue("今日新增观众");
    // (1,2)
     Cell cell12 = row1.createCell(1);
     cell12.setCellValue(666);

    FileOutputStream o = new FileOutputStream(PATH+"狂胜.xls");

    workbook.write(o);
    o.close();
    }
}