package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class OverviewPage {
	
	private WebDriver driver;
	
	private By overviewTitle=By.xpath("//span[contains(text(),'Checkout: Overview')]");
	private By finishBtn=By.id("finish");
	
	public OverviewPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void Clcik_finishBtn() {
		driver.findElement(finishBtn).click();
	}
	
	public void Verify_overviewTitle() {
		Assert.assertTrue(driver.findElement(overviewTitle).isDisplayed());
	}

}
