package ecxelOperation;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreateExcel {
    public static void main(String[] args) throws FileNotFoundException {
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        HSSFSheet sheet = hssfWorkbook.createSheet("EmpInfo");

        List<List<Object>> empDate = new ArrayList<>();
        empDate.add(List.of("EmppId", "Name", "Job"));
        empDate.add(List.of(101, "Name1", "Job1"));
        empDate.add(List.of(102, "Name2", "Job2"));
        empDate.add(List.of(103, "Name3", "Job3"));

        int rows = empDate.size();
        int cols = empDate.get(0).size();

        for (int i = 0; i < rows; i++) {
            HSSFRow row = sheet.createRow(i);
            for (int j = 0; j < cols; j++) {
                HSSFCell cell = row.createCell(j);
            }
        }

        String filePath = "src/test/resources/empDate.xlsx";

        FileOutputStream fileOutputStream = new FileOutputStream(filePath);

        }

        public <T> T createExcels(T type) throws IOException {
            HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
            String filePath = "src/test/resources/empDate.xlsx";
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            hssfWorkbook.write(fileOutputStream);

            return null;
        }
     }

