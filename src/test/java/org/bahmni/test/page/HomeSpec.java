package org.bahmni.test.page;


import com.thoughtworks.gauge.Step;
import org.bahmni.test.DriverFactory;
import org.bahmni.test.PageFactory;
import org.bahmni.test.page.home.HomePage;
import org.openqa.selenium.WebDriver;

public class HomeSpec extends BahmniPage {
	private final WebDriver driver;
	HomePage homePage;

	public HomeSpec(){
		this.driver = DriverFactory.getDriver();
	}

	@Step("Navigate to dashboard")
	public void navigateToHomePage() {
		driver.get(HomePage.URL);
	}


	@Step("Click on registration app")
	public void goToRegistrationPage(){
		homePage = PageFactory.getHomePage();
		homePage.clickRegistrationApp();
		PageFactory.waitForSpinner();
	}

	@Step("Click on programs app")
	public void goToProgramsPage(){
		homePage = PageFactory.getHomePage();
		homePage.clickProgramsApp();
	}

	@Step("Click on clinical app")
	public void goToClinicalPage(){
		homePage = PageFactory.getHomePage();
		homePage.clickClinicalApp();
	}

	@Step("Logout the user")
	public void logout(){
		navigateToHomePage();
		PageFactory.waitForSpinner();
		homePage = PageFactory.getHomePage();
		homePage.logout();
	}

}
