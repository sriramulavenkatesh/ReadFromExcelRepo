package javaPractice;

import java.util.ArrayList;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import JavaSessions.Xls_Reader;

public class testarray2 {
	@DataProvider(name="sample")
	public ArrayList<String> credentials() {

		Xls_Reader reader = new Xls_Reader("G:\\Excel data lib\\users_test_data.xlsx");
		ArrayList<String> list = new ArrayList<String>();
		int rowcount = reader.getRowCount("Sheet1");
		for (int row = 2; row <= rowcount; row++) {

			list.add(reader.getCellData("Sheet1", 0, row));
			list.add(reader.getCellData("Sheet1", 1, row));

		}
		return list;

	}

	@Test(dataProvider="sample")
	public void sampletest(String uname, String pwd) {

		System.out.println("The username = " + uname);
		System.out.println("The password =" + pwd);

	}

}
