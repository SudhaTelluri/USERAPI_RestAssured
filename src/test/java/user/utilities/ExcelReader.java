package user.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {

	public List<Map<String, String>> readTestDataFromExcel(String filePath, String sheetName) throws IOException {
		List<Map<String, String>> testData = new ArrayList<Map<String, String>>();
		FileInputStream fis = new FileInputStream(new File(filePath));
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);

		// Assuming first row contains header names
		Row headerRow = sheet.getRow(0);
		int numColumns = headerRow.getLastCellNum();

		DataFormatter dataFormatter = new DataFormatter();

		for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
			Row dataRow = sheet.getRow(rowIndex);
			Map<String, String> rowData = new HashMap<String, String>();

			for (int columnIndex = 0; columnIndex < numColumns; columnIndex++) {
				Cell headerCell = headerRow.getCell(columnIndex);
				Cell dataCell = dataRow.getCell(columnIndex);

				String header = headerCell.getStringCellValue();
				String value = "";

				if (dataCell != null) {
					value = dataFormatter.formatCellValue(dataCell);
				}

				rowData.put(header, value);
			}
			testData.add(rowData);
		}

		workbook.close();
		fis.close();
		return testData;
	}
}
