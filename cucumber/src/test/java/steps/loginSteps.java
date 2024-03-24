package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import Hooks.Base;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class loginSteps{
	
	private static WebDriver driver;
	private Pages.LoginPage loginPage;
	
	 @Before
	    public void setUp() {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        loginPage = new Pages.LoginPage(driver);
	    }
	
	@Given("user naviagte to Swaglabs website")
	public void user_naviagte_to_swaglabs_website() {
	    WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
	    driver.get("https://www.saucedemo.com/");
	    driver.manage().window().maximize();
	}
	
	@When("enter invalid username {string}")
	public void enter_invalid_username(String username) {
	  loginPage.Enter_username(username);
	}

	@When("enter invalid password {string}")
	public void enter_invalid_password(String password) {
		loginPage.Enter_password(password);
	}

	@When("user click on login button")
	public void user_click_on_login_button() {
		loginPage.Click_loginBtn();
	}

	@Then("an error message must appears.")
	public void an_error_message_must_appears(){
		
	 loginPage.Verify_errorMsg();
	}

	@When("user enter valid username {string}")
	public void user_enter_valid_username(String username) {
		
		driver.findElement(By.id("user-name")).clear();
		 loginPage.Enter_username(username);
	}

	@When("user enter valid password {string}")
	public void user_enter_valid_password(String password) {
		driver.findElement(By.id("password")).clear();
		loginPage.Enter_password(password);
	}

	@Then("user automatically navigated to homepage")
	public void user_automatically_navigated_to_homepage() {
		loginPage.Verify_HomePagetitle();
	}
}
