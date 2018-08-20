package Nexx;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

	public static void main(String[] args) throws InterruptedException {

		// System.setProperty("webdriver.chrome.driver",
		// "C:\\Users\\USER\\Desktop\\Nexx Automation\\Nexx
		// Retail\\WebDrivers\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// driver.get("http://vmmain-pc:9330/NexxRetail/#/page/login");
		driver.get("http://197.220.114.46:9633/#/merchandising/dashboard");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		/*
		 * Set username & password->Login
		 */
		// driver.findElement(By.xpath("//*[@id='1item']")).sendKeys("sammy");
		driver.findElement(By.xpath("//*[@id='1item']")).sendKeys("sysadmin");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*/button[text()='Next']")).click();
		// driver.findElement(By.xpath("//*[@id='password']")).sendKeys("123@Asd");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("admin12347");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*/button[text()='Login']")).click();

		Thread.sleep(2000);

		driver.navigate().refresh();
		
		Thread.sleep(2000);

		String expectedText = "Merchandising Navigation".trim();

		var actualText = driver.findElement(By.xpath("//*/li[contains(normalize-space(),'Merchandising Navigation')]"))
				.getText().toString().trim();

		System.out.println("Expected Text = " + expectedText + " | Actual Text = " + actualText);

		if (actualText.equals(expectedText)) {
			System.out.println("Login Test Successful");

		} else {
			System.out.println("Login Test Failed");
		}
		
		
		
		driver.close();

	}

}
