package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InformationPage {
	
	private WebDriver driver;
	private By firstname=By.id("first-name");
	private By lastname=By.id("last-name");
	private By postalcode=By.id("postal-code");
	private By continueBtn=By.id("continue");
	
	public InformationPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void Enter_firstname(String firstName) {
		driver.findElement(firstname).sendKeys(firstName);
	}
	
	public void Enter_lastname(String lastName) {
		driver.findElement(lastname).sendKeys(lastName);
	}
	
	public void Enter_postalCode(String postalCode) {
		driver.findElement(postalcode).sendKeys(postalCode);
	}
	
	public void Clcik_continueBtn() {
		driver.findElement(continueBtn).click();
	}

}
