package readFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadWriteExcelFile {

	public static Object[][] readExceFile(String excelPath, String sheetName) throws IOException {
		File filepath = new File(excelPath);
		FileInputStream file = new FileInputStream(filepath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		int rows = sheet.getLastRowNum() + 1;
		int columns = sheet.getRow(0).getLastCellNum();

		Object[][] data = new Object[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				data[i][j] = sheet.getRow(i).getCell(j).toString();

			}

		}

		workbook.close();
		file.close();
		return data;

	}

	public static void writeFile(String city, String CheckIn, String checkOut, String hotelName, String review)
			throws IOException {

		File file = new File(".//Input-Output-Data//input-output-BookingTest.xlsx");
		FileInputStream input = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(input);

		XSSFSheet sheet = workbook.getSheetAt(1);
		String x = workbook.getSheetName(1);
		int lastRow = sheet.getLastRowNum();

		System.out.println(x);
		System.out.println(lastRow);

		input.close();

		ArrayList<Object[]> data = new ArrayList<Object[]>();
		for (int i = 0; i < 1; i++) {

			data.add(new Object[] { city, CheckIn, checkOut, hotelName, review });

		}

		for (Object[] info : data) {
			XSSFRow row = sheet.createRow(++lastRow);
			int columnCount = 0;

			for (Object value : info) {
				XSSFCell cell = row.createCell(columnCount++);
				cell.setCellValue((String) value);
			}

		}
		FileOutputStream output = new FileOutputStream(file);
		workbook.write(output);
		workbook.close();
		output.close();
	
	}
}
