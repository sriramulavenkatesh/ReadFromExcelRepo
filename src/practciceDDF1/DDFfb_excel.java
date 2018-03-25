package practciceDDF1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import JavaSessions.Xls_Reader;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.testng.annotations.*;

public class DDFfb_excel {

	WebDriver driver;

	@Test(dataProvider = "Authentication")
	public void ffblogin(String uname, String pwd) {

		try {
			System.setProperty("webdriver.chrome.driver", "G:\\Automation Stuff\\Chrome driver\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.get("https://www.facebook.com/");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(uname);
			driver.findElement(By.xpath(".//*[@id='pass']")).sendKeys(pwd);
			driver.findElement(By.xpath("//*[@value=\"Log In\"]")).click();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[@title='Profile']")).click();
			driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
			Assert.assertTrue(driver.getCurrentUrl().contains("venkatesh4"), "This is not my Original FB Account");
			System.out.println("This is my original FB Acount");
			Thread.sleep(4000);
			driver.quit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@DataProvider(name = "Authentication")
	public Object[][] logindata() {
		Object[][] data = utilityExcel.getData.gettestdata("Sheet2");
		return data;

	}

}
