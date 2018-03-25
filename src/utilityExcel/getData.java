package utilityExcel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class getData {

	static Workbook book;
	static Sheet sheet;

	public static Object[][] gettestdata(String Sheetname) {
		FileInputStream file = null;
		try {
			file = new FileInputStream("G:\\Excel data lib\\users_test_data.xlsx");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			book = WorkbookFactory.create(file);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(Sheetname);
		int rowcount = sheet.getLastRowNum();
		int columncount = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[rowcount][columncount];
		for (int i = 0; i < rowcount; i++) {

			for (int k = 0; k < columncount; k++) {

				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			}

		}
		return data;

	}

}
