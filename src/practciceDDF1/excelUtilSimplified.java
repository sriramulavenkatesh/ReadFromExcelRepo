package practciceDDF1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.*;

public class excelUtilSimplified {

	public static Workbook book;
	public static Sheet sheet;

	public Object[][] getdata(String sheetname) throws EncryptedDocumentException, InvalidFormatException, IOException {

		FileInputStream fis = new FileInputStream("G:\\Excel data lib\\users_test_data.xlsx");
		book = WorkbookFactory.create(fis);
		sheet = book.getSheet(sheetname);
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

	@DataProvider(name = "Auth")
	public Object[][] testdata() throws EncryptedDocumentException, InvalidFormatException, IOException {

		Object[][] data = getdata("Sheet1");
		return data;
	}

	@Test(dataProvider = "Auth")
	public void testdata(String uname, String pwd) {

		System.out.println(uname);
		System.out.println(pwd);

	}

}
