package org.bahmni.test.page;

import com.thoughtworks.gauge.Step;
import org.bahmni.test.DriverFactory;
import org.bahmni.test.PageFactory;
import org.bahmni.test.page.home.HomePage;
import org.openqa.selenium.WebDriver;

public class HomeSpec {
	private final WebDriver driver;

	public HomeSpec(){
		this.driver = DriverFactory.getDriver();
	}

	@Step("Go to Home page")
	public void navigateToHomePage() {
		driver.get(HomePage.URL);
	}


	@Step("Click on registration app")
	public void goToRegistrationPage(){
		HomePage homePage = PageFactory.getHomePage();
		homePage.clickRegistrationApp();
	}
}
