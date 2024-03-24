package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductPage {
	
	   private WebDriver driver;
	   
	    private By addToCartButton = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");
	    private By ShoppingCartLink=By.xpath("//a[@class='shopping_cart_link']");
	    private By productTitle=By.xpath("//span[contains(text(),'Products')]");
	    
	    public ProductPage(WebDriver driver) {
	    	this.driver=driver;
	    }
	    
	    public void Click_addToCartButton() {
	    	driver.findElement(addToCartButton).click();
	    }
	    
	    public void Click_ShoppingCartLink() {
	    	driver.findElement(ShoppingCartLink).click();
	    }
	    
	    public void Verify_productTitle() {
			Assert.assertTrue(driver.findElement(productTitle).isDisplayed());
		}

	   

}
