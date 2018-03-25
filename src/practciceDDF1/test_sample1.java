package practciceDDF1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.*;

public class test_sample1 {
	@DataProvider(name="Auth")
	public Object[][] credentials() throws IOException {
		File src = new File("G:\\Excel data lib\\users_test_data.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb.getSheetAt(0);
		int rowcount = sheet1.getLastRowNum();
		int columncount = sheet1.getRow(0).getLastCellNum();
		Object[][] data = new Object[rowcount][columncount];
		for (int i = 0; i < rowcount; i++) {

			for (int k = 0; i < columncount; k++) {

				data[i][k] = sheet1.getRow(i + 1).getCell(k).toString();
				System.out.println("The data = " + data);
			}

		}
		return data;

	}
	
	@Test(dataProvider="Auth")
	public void test(String uname,String pwd) {
		
		System.out.println(uname);
		System.out.println(pwd);
		
	}
}
