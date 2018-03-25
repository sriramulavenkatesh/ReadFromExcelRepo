package readfromexcel;

import org.testng.annotations.*;

public class testexcelusingutility {
	
	@DataProvider(name="Auth")
	public Object[][] credentials(){
		
		Object data[][] = utilityExcel.getData.gettestdata("Sheet1");
		return data;
		
	}
	
	@Test(dataProvider="Auth")
	public void sampletest(String uname, String pwd) {
		System.out.println(uname);
		System.out.println(pwd);
		
	}

}
