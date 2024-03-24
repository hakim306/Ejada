package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class LoginPage {

	private WebDriver driver;
	private String URL = "https://www.saucedemo.com";
	private By usernameField = By.id("user-name");
	private By passwordField = By.id("password");
	private By loginButton = By.id("login-button");
	private By pageName = By.xpath("//span[contains(text(),'Products')]");
	private By loginErrorMessage = By.cssSelector("h3");
	private By ProductPageTitle=By.xpath("//span[contains(text(),'Products')]");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void Enter_username(String username) {
		driver.findElement(usernameField).sendKeys(username);
	}

	public void Enter_password(String Password) {
		driver.findElement(passwordField).sendKeys(Password);
	}

	public void Click_loginBtn() {
		driver.findElement(loginButton).click();
	}

	public void Verify_errorMsg() {
		Assert.assertTrue(driver.findElement(loginErrorMessage).isDisplayed());
	}

	public void Verify_HomePagetitle() {
		Assert.assertTrue(driver.findElement(ProductPageTitle).isDisplayed());
	}

}
