package practciceDDF1;


import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


public class testAmazon {
	WebDriver driver;

	@Test(dataProvider = "Authentication")
	public void amazonpage(String uname,String pwd) {
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
		driver.findElement(By.xpath(".//*[@id='twotabsearchtextbox']")).sendKeys("amazon echo dot");
		driver.findElement(By.xpath(".//*[@id='nav-search']/form/div[2]/div/input")).click();
		driver.findElement(By.xpath(".//*[@id='result_0']/div/div/div/div[2]/div[1]/div[1]/a/h2")).click();

//		 for(String winhandle:driver.getWindowHandles()) {
//		 driver.switchTo().window(winhandle);
//		 }

		ArrayList<String> newtab = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newtab.get(1));
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"buy-now-button\"]")).click();
		// driver.switchTo().window(newtab.get(0));
		// driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[2]")).click();

	}


	@DataProvider(name = "Authentication")
	public Object[][] logindata() {
		
		Object data[][] = utilityExcel.getData.gettestdata("Sheet1");
		return data;
		
	}
}
