package Nexx;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Pages.Login_Page;

public class Merchandising_Product {

	WebDriver driver;

	@SuppressWarnings({ "static-access", "null" })
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = null;
		Login_Page login = new Login_Page(driver);
		login.main(args);
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*/a[@title='Product']/span")).click();
		driver.findElement(By.xpath("//*/ul/li/a[@href='#/merchandising/product-master']//span")).click();

		String ExpectedPageTitle = "Product Master";
		String ActualPageTitle = driver.findElement(By.xpath("//*/h3[contains(normalize-space(),'Product Master')]"))
				.getText().trim();

		String ExpectedText = "This screen is used to manage products in the system";
		String ActualText = driver.findElement(By.xpath("//*/h3[contains(normalize-space(),'Product Master')]/small"))
				.getText().trim();

		if (ActualPageTitle.equals(ExpectedPageTitle) || ActualText.equals(ExpectedText)) {
			System.out.println("Navigation to Product Master PASSSED");
		}

		else {
			System.out.println("Navigation to Product Master FAILED");
		}

	}
	
	
}
