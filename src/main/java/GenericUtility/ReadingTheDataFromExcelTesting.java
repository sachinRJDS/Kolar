package GenericUtility;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadingTheDataFromExcelTesting {

    public String readExcelDataBasedOnSheetRowAndCell(String path,String sheet,int row, int cell) throws IOException {
        FileInputStream fis=new FileInputStream(path);
        Workbook wb=WorkbookFactory.create(fis);
        return wb.getSheet(sheet).getRow(row).getCell(cell).toString();
    }
}
