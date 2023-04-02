package com.test;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.regex.Pattern;

public class FirstTestTest  {


    public static final String PATH = "C:\\Users\\DQ\\Desktop\\data\\export\\";
    @Test
    @DisplayName("03版")
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

    @Test
    @DisplayName("07版")
    public void testMain01() throws Exception{
        // 1、创建一个工作簿
        Workbook workbook = new XSSFWorkbook();

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

        FileOutputStream o = new FileOutputStream(PATH+ LocalDate.now()+"狂胜"+".xlsx" );
        CellRangeAddress region  = new CellRangeAddress(0, 1, 0, 1);
        sheet.addMergedRegion(region);
        cell11.setCellValue("合并单元格");
//        sheet.removeMergedRegion(0);

        CellRangeAddress region1  = new CellRangeAddress(2, 3, 0, 1);
        sheet.addMergedRegion(region1);
        List<CellRangeAddress> mergedRegions = sheet.getMergedRegions();
        mergedRegions.get(0);
        Row row44 = cell12.getSheet().getRow(44);
        workbook.write(o);
        o.close();
    }
}