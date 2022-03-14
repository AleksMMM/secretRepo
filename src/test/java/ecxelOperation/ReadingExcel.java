package ecxelOperation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ReadingExcel {
    public static void main(String[] args) throws IOException {
        String excelPath = "src/test/resources/countries.xls";

        FileInputStream inputStream = new FileInputStream(excelPath);

        HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
        HSSFSheet sheet = workbook.getSheetAt(0);

        // получить последнюю строку
        int rows = sheet.getLastRowNum();

        // получить последний столбец
        int cols = sheet.getRow(1).getLastCellNum();

        // через вложенный цикл получаю все ячейки и столбцы

        for (int i = 0; i < rows; i++) {
            HSSFRow hssfRow = sheet.getRow(i);
            System.out.println();

            for (int j = 0; j < cols; j++) {
                HSSFCell hssfCell = sheet.getRow(i).getCell(j);

                //  print(hssfCell);
            }
        }

        // использование iteratora

        Iterator iterator = sheet.iterator();
        while (iterator.hasNext()) {
            HSSFRow row = (HSSFRow) iterator.next();
            Iterator cellIterator = row.cellIterator();
            System.out.println();

            while (cellIterator.hasNext()) {
                HSSFCell cell = (HSSFCell) cellIterator.next();

                print(cell);
            }


        }
    }

    public static <T> T print(T type) {

        System.out.print(type + "|" + " ");

        return null;
    }
}
