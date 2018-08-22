package Merchandising;

import static org.testng.Assert.assertEquals;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ProductMaster_EditProduct extends loginTest {

	String RowNumber;
	String productCode;
	String productDescription;
	String EditProductCode;
	String EditProductDescription;
	Random rnd = new Random();
	String productDescriptionAfterSave;

	@Test(priority = 4)
	public void navigate_ProductMaster() throws InterruptedException {
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		System.out.println("---Navigating To Product Master---");

		Thread.sleep(7000);
		driver.findElement(By.xpath("//*/em[@class='icon-grid']")).click();

		driver.findElement(By.partialLinkText("Merchandising")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//*/a[@title='Product']/span")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*/ul/li/a[@href='#/merchandising/product-master']//span")).click();

	}

	@Test(priority = 5)
	public void select_ProductToEdit() throws InterruptedException {
		// Row Number of product to be selected for edit
		RowNumber = "2";
		Thread.sleep(3000);
		// get product code & product descripton from Set Row
		productCode = driver.findElement(By.xpath("//*/table/tbody/tr[" + RowNumber + "]/td[2]")).getText().trim();
		productDescription = driver.findElement(By.xpath("//*/table/tbody/tr[" + RowNumber + "]/td[3]")).getText()
				.trim();
		System.out.println("Selected product code = " + productCode + " | product description = " + productDescription);

		driver.findElement(By.xpath("//*/table/tbody/tr[" + RowNumber + "]/td[5]//button[text()='Edit']")).click();

	}

	@Test(priority = 6)
	public void verify_EditProduct() throws InterruptedException {
		Thread.sleep(3000);
		// verify edit button takes user to selected product page
		EditProductCode = driver.findElement(By.xpath("//*/input[@placeholder='Product Code']")).getText().trim();
		EditProductDescription = driver.findElement(By.xpath("//*/input[@placeholder='Description']")).getText().trim();
		System.out.println("On Edit page-> product code = " + EditProductCode + " | product description = "
				+ EditProductDescription);

		assertEquals(productCode, EditProductCode);
		assertEquals(productDescription, EditProductDescription);
	}

	@Test(priority = 7)
	public void setEditDetails_Save() throws InterruptedException {

		// Random rnd = new Random();
		int n = rnd.nextInt(50) + 1;
		driver.findElement(By.xpath("//*/input[@placeholder='Description']")).clear();

		driver.findElement(By.xpath("//*/input[@placeholder='Description']")).sendKeys("Tomatoes" + "-" + n);

		System.out.println("Product description after EDIT = "
				+ (driver.findElement(By.xpath("//*/input[@placeholder='Description']")).getText().trim()));

		Thread.sleep(2000);

		driver.findElement(By.xpath("//*/div/button/span[text()='Save']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='toast-container']/div/div[2]/div")).isDisplayed();
		driver.findElement(By.xpath("//*/div/button/span[text()='List']")).click();
	}

	@Test(priority = 8)
	public void verify_EditDetailsSaved() throws InterruptedException {
		Thread.sleep(3000);
		productDescriptionAfterSave = driver.findElement(By.xpath("//*/table/tbody/tr[" + RowNumber + "]/td[3]"))
				.getText().trim();
		System.out.println("Product description after SAVING = " + productDescriptionAfterSave);
		if (productDescriptionAfterSave != productDescription) {
			System.out.println("Description After Edit & Save = " + productDescriptionAfterSave + " | Product ");
			System.out.println("--Edit Product Successfull--");
		}

		else {
			System.out.println("--Edit Product FAILED--");
		}
	}
	
		
	
}
