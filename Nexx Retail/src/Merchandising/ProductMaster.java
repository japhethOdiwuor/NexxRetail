package Merchandising;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ProductMaster extends loginTest {

	@Test(priority = 4)
	public void navigateMerchandising() throws InterruptedException {
		driver.navigate().refresh();

		Thread.sleep(10000);
		driver.findElement(By.xpath("//*/em[@class='icon-grid']")).click();

		List<WebElement> dashOptions = driver
				.findElements(By.xpath("//*/li[@ng-repeat='app in applications.available']/a"));

		for (int i = 0; i < dashOptions.size(); i++) {
			// var dashtext = driver.findElement(By.xpath("//*/li[@ng-repeat='app in
			// applications.available']/a")).getText();
			var dashtext = dashOptions.get(i).getText().toString();

			System.out.println("dashboard option " + (i) + " = " + dashtext);

		}
		driver.findElement(By.partialLinkText("Merchandising")).click();

	}

	@Test(priority = 5)
	public void navigateProductMaster() throws InterruptedException {

		Thread.sleep(2000);
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
			System.out.println(
					"Expected Page Title = " + ExpectedPageTitle + " | Actual Page Title = " + ActualPageTitle);
			System.out.println("Expected Page Text = " + ExpectedText);
			System.out.println("Actual Page Text = " + ActualText);
			System.out.println("Navigation to Product Master PASSSED");
		}

		else {
			System.out.println(
					"Expected Page Title = " + ExpectedPageTitle + " | Actual Page Title = " + ActualPageTitle);
			System.out.println("Expected Page Text = " + ExpectedText);
			System.out.println("Actual Page Text = " + ActualText);
			System.out.println("Navigation to Product Master FAILED");
		}
	}

}
