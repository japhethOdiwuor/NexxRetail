package Merchandising;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

	public static WebDriver driver;

	@BeforeSuite
	public void openBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\WebDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		//driver.get("http://197.220.114.46:9633/#/merchandising/dashboard");
		driver.get("http://vmmain-pc:9330/NexxRetail/#/page/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// set login credentials<username & password>

		driver.findElement(By.xpath("//*[@id='1item']")).sendKeys("sammy");
		//driver.findElement(By.xpath("//*[@id='1item']")).sendKeys("sysadmin");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*/button[text()='Next']")).click();
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("123@Asd");
		//driver.findElement(By.xpath("//*[@id='password']")).sendKeys("admin12347");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*/button[text()='Login']")).click();
		
		
		Thread.sleep(2000);
		
		driver.navigate().refresh();
		
		Thread.sleep(3000);

	}

	@AfterSuite
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a/em[@class='icon-logout']")).click();
		Thread.sleep(1000);
		driver.close();
	}

}
