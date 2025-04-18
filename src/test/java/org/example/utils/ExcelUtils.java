package org.example.utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {

    public static Workbook book;
    public static Sheet sheet;

    public static String path = System.getProperty("user.dir") + "/src/test/resources/TestData.xlsx";

    public static Object[][] readDatafromExcel(String sheetname) {
        try {
            FileInputStream file = new FileInputStream(path);
            book = WorkbookFactory.create(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        sheet = book.getSheet(sheetname);
        int totalrow = sheet.getLastRowNum();
        int totalcol = sheet.getRow(0).getLastCellNum();

        Object data[][] = new Object[totalrow][totalcol];
        for (int i = 0; i < totalrow; i++) {
            for (int j = 0; j < totalcol; j++) {

                data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
            }
        }
        return data;
    }
}