package practciceDDF1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class DDFgooglepage {

	WebDriver driver;

	@Test(dataProvider = "Authentication")
	public void googlepage(String uname, String pwd) {
		try {
			System.setProperty("webdriver.chrome.driver", "G:\\Automation Stuff\\Chrome driver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.get(
					"https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
			driver.findElement(By.xpath(".//*[@id='identifierId']")).sendKeys(uname);
			driver.findElement(By.xpath(".//*[@id='identifierNext']/content/span")).click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath(".//*[@id='password']/div[1]/div/div[1]/input")).sendKeys(pwd);
			driver.findElement(By.xpath(".//*[@id='passwordNext']/content/span")).click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(10000);
			Assert.assertTrue(driver.getCurrentUrl().contains("/mail/u/0/#inbox"), "Login Failed");
			System.out.println("Login Successfull");
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@AfterMethod
	public void browserclose() {

		driver.quit();

	}

	@DataProvider(name = "Authentication")
	public Object[][] Credentials() {
		return new Object[][] { { "sriram4254", "096k1a0237" }, { "sriram4254", "49r7304" } };

	}

}
