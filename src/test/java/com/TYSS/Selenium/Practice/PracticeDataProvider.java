package com.TYSS.Selenium.Practice;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class PracticeDataProvider {

    @DataProvider
    public Object[][] data_provider() {
        Object[][]obj=new Object[2][2];
        obj[0][0]="Sachin";
        obj[0][1]=123;
        obj[1][0]="Gowtham";
        obj[1][1]=456;
        return obj;
    }

    @DataProvider
    public Object[][] data_providerExcel() throws IOException {
        FileInputStream fis=new FileInputStream("./src/test/resources/practice.xlsx");
        Workbook book= WorkbookFactory.create(fis);
        Sheet sheet=book.getSheet("Sheet1");
        int rowCount=sheet.getLastRowNum()+1;
        int cellCount=sheet.getRow(0).getLastCellNum();

        Object[][]obj=new Object[rowCount][cellCount];

        for(int i=0;i<rowCount;i++){
            for(int j=0;j<cellCount;j++){
                obj[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
            }
        }
        return obj;

    }


    @Test(dataProvider="data_provider")
    public void testingDataProvider(String name,int age) {
        System.out.println(name+" : "+age);
    }
    @Test(dataProvider="data_providerExcel")
    public void testingDataProviderExcel(String browser,String site,String name,String gmail) {
        System.out.println(browser+" : "+site+" : "+name+" : "+gmail);
    }
}
