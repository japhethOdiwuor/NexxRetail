package Merchandising;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ProductMaster_Pagination extends TestBase {

	int TotalRows;
	String prodDescriptionPage1;
	String prodDescriptionPage3;
	String prodDescriptionReturnPage1;

	@Test
	public void a_NavigateTo_productMaster() throws InterruptedException {
		System.out.println("--------------------------------");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Thread.sleep(5000);
		driver.findElement(By.xpath("//*/em[@class='icon-grid']")).click();

		driver.findElement(By.partialLinkText("Merchandising")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//*/a[@title='Product']/span")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*/ul/li/a[@href='#/merchandising/product-master']//span")).click();
	}

	@Test
	public void b_countAvailableRowsOnTable() throws InterruptedException {
		Thread.sleep(5000);
		List<WebElement> rows = driver.findElements(By.xpath("//*/div[@class='table-responsive']/table/tbody/tr"));

		TotalRows = rows.size();

		System.out.println("Available Rows on First Page = " + TotalRows);
	}

	// @
	public void c_ExecutePagination() throws InterruptedException {
		if (TotalRows >= 50) {

			// Get product description frm Page 1->click to get to Page 3
			prodDescriptionPage1 = driver
					.findElement(By.xpath("//*/div[@class='table-responsive']/table/tbody/tr[1]/td[3]")).getText();

			driver.findElement(By.xpath("//*/ul/li/a[text()='3']")).click();
			
			Thread.sleep(3000);

			// get product description frm Page 3, compare to Page 1 description
			prodDescriptionPage3 = driver.findElement(By.xpath("//*/div[@class='table-responsive']/table/tbody/tr[1]/td[3]")).getText();
			//prodDescriptionPage1.
			
			// Click->get back to Page 1 & get product description again from Page 1 and
			// compare to
		}

	}

}
