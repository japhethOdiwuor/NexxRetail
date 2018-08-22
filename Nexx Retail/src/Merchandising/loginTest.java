package Merchandising;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class loginTest {

	public static WebDriver driver;

	@Test(priority = 1)
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\WebDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://197.220.114.46:9633/#/merchandising/dashboard");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(priority = 2)
	public void setloginCredentials() throws InterruptedException {
		// driver.findElement(By.xpath("//*[@id='1item']")).sendKeys("sammy");
		driver.findElement(By.xpath("//*[@id='1item']")).sendKeys("sysadmin");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*/button[text()='Next']")).click();
		// driver.findElement(By.xpath("//*[@id='password']")).sendKeys("123@Asd");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("admin12347");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*/button[text()='Login']")).click();
	}

	@Test(priority = 3)
	public void verifyLogin() {
		var buttonLogout = driver.findElement(By.xpath("//*/ul/li/a/em[@class='icon-logout']"));

		if (buttonLogout.isDisplayed()) {
			System.out.println("Login Successful");

		} else {
			System.out.println("Login Failed");
		}

	}
	
	@AfterSuite
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a/em[@class='icon-logout']")).click();
		Thread.sleep(1000);
		driver.close();
	}
	
	

}
