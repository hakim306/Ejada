package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartPage {

	private WebDriver driver;
	private By CartTitle = By.xpath("//span[contains(text(),'Your Cart')]");
	private By checkoutBtn = By.id("checkout");
	
	public CartPage(WebDriver driver) {
		this.driver=driver;
	}

	public void Verify_cartPagetitle() {
		Assert.assertTrue(driver.findElement(CartTitle).isDisplayed());
	}

	public void Click_checkoutBtn() {
		driver.findElement(checkoutBtn).click();
	}

}
