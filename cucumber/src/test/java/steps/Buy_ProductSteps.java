package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import Hooks.Base;
import Pages.CartPage;
import Pages.InformationPage;
import Pages.LoginPage;
import Pages.OverviewPage;
import Pages.ProductPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Buy_ProductSteps extends Base {

	private static WebDriver driver;
	private LoginPage loginpage;
	private ProductPage productpage;
	private CartPage cartpage;
	private InformationPage informationPage;
	private OverviewPage overviewPage;

	@Before
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		loginpage = new LoginPage(driver);
		productpage=new ProductPage(driver);
		cartpage=new CartPage(driver);
		informationPage=new InformationPage(driver);
		overviewPage=new OverviewPage(driver);
	}

	// public static WebDriver driver;
	@Given("user on product page.")
	public void user_on_product_page() {
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
	}

	@When("user Add the most expensive two products to your cart")
	public void user_add_the_most_expensive_two_products_to_your_cart() {
		productpage.Click_addToCartButton();
	}

	@When("Click on cart logo")
	public void click_on_cart_logo() {
		productpage.Click_ShoppingCartLink();
	}

	@Then("User will be navigated to Cart Page.")
	public void user_will_be_navigated_to_cart_page() {
		cartpage.Verify_cartPagetitle();
	}

	@Then("click on checkout button.")
	public void click_on_checkout_button() {
		cartpage.Click_checkoutBtn();
	}

	@Then("user will be navigated to checkout page.")
	public void user_will_be_navigated_to_checkout_page() {
		
	}

	@Then("Fill information form and click on continue button")
	public void fill_information_form_and_click_on_continue_button() {
		informationPage.Enter_firstname("mohamed");
		informationPage.Enter_lastname("mohamed");
		informationPage.Enter_postalCode("123");
		informationPage.Clcik_continueBtn();
		
	}

	@Then("user will be navigated to overview page.")
	public void user_will_be_navigated_to_overview_page() {
		overviewPage.Verify_overviewTitle();
	}

	@Then("click on finish button.")
	public void click_on_finish_button() {
		overviewPage.Clcik_finishBtn();
	}

	@Then("successfull message will appears.")
	public void successfull_message_will_appears() {
		Assert.assertTrue(
				driver.findElement(By.xpath("//h2[contains(text(),'Thank you for your order!')]")).isDisplayed());
	}

}
