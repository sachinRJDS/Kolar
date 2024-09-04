package com.TYSS.Selenium.Practice;

import GenericUtility.BaseTest;
import GenericUtility.ReadingTheDataFromExcelTesting;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class ReadingTheDataFromExcel extends BaseTest {
    String path="./src/test/resources/practice.xlsx";
    @Test(groups="smoke")
    public void readingTheDataFromExcel() throws IOException {

        FileInputStream fis=new FileInputStream(path);
        Workbook book=WorkbookFactory.create(fis);
        System.out.println( book.getSheet("Sheet1").getRow(1).getCell(0).toString());
        System.out.println( book.getSheet("Sheet1").getRow(1).getCell(1).toString());
        System.out.println( book.getSheet("Sheet1").getRow(1).getCell(2).toString());
        System.out.println( book.getSheet("Sheet1").getRow(1).getCell(3).toString());

        System.out.println(book.getSheet("Sheet1").getLastRowNum());
        System.out.println(book.getSheet("Sheet1").getRow(0).getLastCellNum());

        book.getSheet("Sheet1").getRow(1).getCell(0).setCellValue("firefox");
         book.getSheet("Sheet1").getRow(1).getCell(1).setCellValue("focabook.com");
         book.getSheet("Sheet1").getRow(1).getCell(2).setCellValue("darshan");
        book.getSheet("Sheet1").getRow(1).getCell(3).setCellValue("darshan@123");

        FileOutputStream fos=new FileOutputStream(path);
        book.write(fos);
        System.out.println("=======================================================");
        System.out.println( book.getSheet("Sheet1").getRow(1).getCell(0).toString());
        System.out.println( book.getSheet("Sheet1").getRow(1).getCell(1).toString());
        System.out.println( book.getSheet("Sheet1").getRow(1).getCell(2).toString());
        System.out.println( book.getSheet("Sheet1").getRow(1).getCell(3).toString());
        book.close();

    }

    @Test(groups="regression")
    public void testing() throws IOException {
        ReadingTheDataFromExcelTesting excel=new ReadingTheDataFromExcelTesting();
        System.out.println(excel.readExcelDataBasedOnSheetRowAndCell(path,"Sheet1",1,0));
    }
}
