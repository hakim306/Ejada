package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CompletePage {
	
	private WebDriver driver;
	private By completeTitle=By.xpath("//span[contains(text(),'Checkout: Complete!')]");
	private By sucessMsg=By.xpath("//h2[contains(text(),'Thank you for your order!')]");
	
	private CompletePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void Verify_completeTitle() {
		Assert.assertTrue(driver.findElement(completeTitle).isDisplayed());
	}
	
	public void Verify_sucessMsg() {
		Assert.assertTrue(driver.findElement(sucessMsg).isDisplayed());
	}

}
