package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class loginTest 
{
	WebDriver driver;
	
     public void setProperty() 
     {
    	 System.setProperty("webdriver.chrome.driver",
 				System.getProperty("user.dir") + "\\WebDrivers\\chromedriver.exe");
 		driver = new ChromeDriver();
 		// driver.get("http://vmmain-pc:9330/NexxRetail/#/page/login");
 		driver.get("http://197.220.114.46:9633/#/merchandising/dashboard");
 		driver.manage().window().maximize();
 		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     }
     
     
     public void setCredentials() throws Exception 
     {
    	 driver.findElement(By.xpath("//*[@id='1item']")).sendKeys("sysadmin");
 		Thread.sleep(2000);
 		driver.findElement(By.xpath("//*/button[text()='Next']")).click();
 		// driver.findElement(By.xpath("//*[@id='password']")).sendKeys("123@Asd");
 		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("admin12347");
 		Thread.sleep(2000);
 		driver.findElement(By.xpath("//*/button[text()='Login']")).click();

 		Thread.sleep(2000);

 		driver.navigate().refresh();
     }
     
     public void verifyLogin() 
     {
    	 String expectedText = "Merchandising Navigation".trim();

 		var actualText = driver.findElement(By.xpath("//*/li[contains(normalize-space(),'Merchandising Navigation')]"))
 				.getText().toString().trim();

 		System.out.println("Expected Text = " + expectedText + " | Actual Text = " + actualText);

 		if (actualText.equals(expectedText)) {
 			System.out.println("Login Successful");

 		} else {
 			System.out.println("Login Failed");
 		}
     }
     
    public loginTest(WebDriver driver) 
     {
    	 this.driver = driver;
    	 PageFactory.initElements(driver, this);
     }
}