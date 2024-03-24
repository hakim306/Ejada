/*package Hooks;

import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class hooks extends Base {
	
	
	@Before
	public static void setup() {
		 WebDriverManager.chromedriver().setup();
		    driver=new ChromeDriver();
		    driver.get("https://www.saucedemo.com/");
		    driver.manage().window().maximize();
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}

}*/
