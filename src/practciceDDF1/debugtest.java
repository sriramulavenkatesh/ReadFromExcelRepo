package practciceDDF1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import JavaSessions.Xls_Reader;

public class debugtest {
	@DataProvider(name = "Auth")
	public Object[][] logindata() {
		Xls_Reader reader = new Xls_Reader("G:\\Excel data lib\\users_test_data.xlsx");
		int rowcount = reader.getRowCount("Sheet2");
		int columncount = reader.getColumnCount("Sheet2");
		Object data[][] = new Object[rowcount][columncount];
		for (int i = 2; i < rowcount; i++) {

			for (int k = 0; k < columncount; k++) {

				data[i][k] = reader.getCellData("Sheet2", k, i);
			}

		}
		return data;

	}

	@Test(dataProvider = "Auth")
	public void testcode(String uname, String pwd) {

		System.out.println(uname + " " + pwd);

	}

}
