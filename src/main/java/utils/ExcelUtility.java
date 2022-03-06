package utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class ExcelUtility {

    private static Workbook book;
    private static Sheet sheet;

    // Open Excel
    private static void openExcel(String filePath) {
        FileInputStream fileIS;
        try {
            fileIS = new FileInputStream(filePath);
            book = new XSSFWorkbook(fileIS);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // Load Sheet
    private static void loadSheet(String sheetName) {
        sheet = book.getSheet(sheetName);
    }


    // Row Count
    private static int rowCount() {
        return sheet.getPhysicalNumberOfRows();
    }


    // Columns Count
    private static int colsCount(int rowIndex) {
        return sheet.getRow(rowIndex).getLastCellNum();
    }


    // Cell Data
    private static String cellData(int rowIndex, int colIndex) {
        return sheet.getRow(rowIndex).getCell(colIndex).toString();
    }


    // Return a 2D object array
    private static Object[] excelIntoArray(String filePath, String sheetName) {
        openExcel(filePath);
        loadSheet(sheetName);

        int rows = rowCount();
        int cols = colsCount(0);

        Object[][] data = new Object[rows - 1][cols];

        // iterate over rows
        for (int row = 1; row < rows; row++) {
            // iterate over columns
            for (int col = 0; col < cols; col++) {
                // store cell value in Object[][] data
                data[row - 1][col] = cellData(row, col);
            }
        }
        return data;
    }


    // Read a file and return List of Maps
    private static List<Map<String, String>> excelIntoList(String filePath, String sheetName) {
        openExcel(filePath);
        loadSheet(sheetName);

        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> excelMap;

        for (int row = 1; row < rowCount(); row++) {
            excelMap = new LinkedHashMap<>();
            for (int c = 0; c < colsCount(row); c++) {
                excelMap.put(cellData(0, c), cellData(row, c));
            }
            list.add(excelMap);
        }
        return list;
    }
}