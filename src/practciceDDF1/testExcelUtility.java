package practciceDDF1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import JavaSessions.*;

public class testExcelUtility {
	WebDriver driver;

	@Test(dataProvider = "Authentication")
	public void amazonpage(String uname, String pwd) {
		System.setProperty("webdriver.chrome.driver", "G:\\Automation Stuff\\Chrome driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath(".//*[@id='nav-link-yourAccount']/span[1]")).click();
		driver.findElement(By.xpath(".//*[@id='ap_email']")).sendKeys(uname);
		driver.findElement(By.xpath(".//*[@id='continue']")).click();
		driver.findElement(By.xpath(".//*[@id='ap_password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]")).click();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

	}

	@DataProvider(name = "Authentication")
	public String[][] credentials() {

		Xls_Reader reader = new Xls_Reader("G:\\Excel data lib\\users_test_data.xlsx");
		int totalrows = reader.getRowCount("Sheet1");
		int totalcolumns = reader.getColumnCount("Sheet1");
		String[][] newArray = new String[totalrows][totalcolumns];

		int rowcount = reader.getRowCount("Sheet1");
		for (int row = 2; row <= rowcount; row++) {

			newArray[0][0] = reader.getCellData("Sheet1", 0, row);
			newArray[0][1] = reader.getCellData("Sheet1", 1, row);

		}
		return newArray;

	}
}
