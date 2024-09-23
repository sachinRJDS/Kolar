package com.TYSS.Selenium.Practice;


import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class data_Provider {

    @org.testng.annotations.DataProvider
    public Object[][] data() {
        Object[][] obj = new Object[2][2];
        obj[0][0] = "Gowtham";
        obj[0][1] = 123;
        obj[1][0] = "Sachin";
        obj[1][1] = 456;
        return obj;
    }

    @DataProvider
    public Object[][] data_excel() throws IOException {
        FileInputStream fis = new FileInputStream("./src/test/resources/practice.xlsx");
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sheet = wb.getSheet("Sheet1");
       int rowCount =  sheet.getLastRowNum()+1;
       int cellCount = sheet.getRow(0).getLastCellNum();

        Object[][] obj = new Object[rowCount][cellCount];
        for(int i=0;i<rowCount;i++){
            for(int j=0;j<cellCount;j++){
                obj[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
            }
        }
        return obj;
    }

    @Test(dataProvider = "data")
    public void data_provide(String name, int age) {
        System.out.println(name+":"+age);
    }

    @Test(dataProvider = "data_excel")
    public void data_providerExcel(String browser, String site, String name, String email){

        System.out.println(browser+":"+site+":"+name+":"+email);
    }
}
