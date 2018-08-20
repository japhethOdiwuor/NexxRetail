package Nexx;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Merchandising_Product {

	static WebDriver driver;

	@SuppressWarnings({})
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// driver.get("http://vmmain-pc:9330/NexxRetail/#/page/login");
		driver.get("http://197.220.114.46:9633/#/merchandising/dashboard");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Set username & password->Login

		// driver.findElement(By.xpath("//*[@id='1item']")).sendKeys("sammy");
		driver.findElement(By.xpath("//*[@id='1item']")).sendKeys("sysadmin");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*/button[text()='Next']")).click();
		// driver.findElement(By.xpath("//*[@id='password']")).sendKeys("123@Asd");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("admin12347");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*/button[text()='Login']")).click();

		Thread.sleep(2000);

		var buttonLogout = driver.findElement(By.xpath("//*/ul/li/a/em[@class='icon-logout']"));

		if (buttonLogout.isDisplayed()) {
			System.out.println("Login Successful");

		} else {
			System.out.println("Login Failed");
		}

		System.out.println("-----------------------------------");

		//driver.navigate().refresh();
		//Thread.sleep(3000);
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*/em[@class='icon-grid']")).click();
		Thread.sleep(2000);
		
		List<WebElement> dashOptions = driver
				.findElements(By.xpath("//*/li[@ng-repeat='app in applications.available']/a"));

		for (int i = 0; i < dashOptions.size(); i++) {
			// var dashtext = driver.findElement(By.xpath("//*/li[@ng-repeat='app in
			// applications.available']/a")).getText();
			var dashtext = dashOptions.get(i).getText().toString();

			System.out.println("dashboard option " + (i) + " = " + dashtext);

			}
		driver.findElement(By.partialLinkText("Merchandising")).click();
		
		Thread.sleep(2000);
		
		System.out.println("-----------------------------------");

		driver.findElement(By.xpath("//*/a[@title='Product']/span")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*/ul/li/a[@href='#/merchandising/product-master']//span")).click();
		Thread.sleep(2000);

		String ExpectedPageTitle = "Product Master";
		String ActualPageTitle = driver.findElement(By.xpath("//*/h3[contains(normalize-space(),'Product Master')]"))
				.getText().trim();

		String ExpectedText = "This screen is used to manage products in the system";
		String ActualText = driver.findElement(By.xpath("//*/h3[contains(normalize-space(),'Product Master')]/small"))
				.getText().trim();

		if (ActualPageTitle.contains(ExpectedPageTitle) && ActualText.contains(ExpectedText)) {
			System.out.print(
					"Expected Page Title = " + ExpectedPageTitle + " | Actual Page Title = " + ActualPageTitle);
			System.out.println("Expected Page Text = " + ExpectedText + " | Actual Page Text = " + ActualText);
			System.out.println("Navigation to Product Master PASSSED");
		}

		else {
			System.out.println(
					"Expected Page Title = " + ExpectedPageTitle + " | Actual Page Title = " + ActualPageTitle);
			System.out.println("Expected Page Text = " + ExpectedText + " | Actual Page Text = " + ActualText);

			System.out.println("Navigation to Product Master FAILED");
		}

	}

}
