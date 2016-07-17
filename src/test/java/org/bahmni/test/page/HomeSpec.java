package org.bahmni.test.page;


import com.thoughtworks.gauge.BeforeClassSteps;
import com.thoughtworks.gauge.Step;
import org.bahmni.test.DriverFactory;
import org.bahmni.test.PageFactory;
import org.bahmni.test.page.home.HomePage;
import org.bahmni.test.page.registration.RegistrationFirstPage;
import org.openqa.selenium.WebDriver;

public class HomeSpec extends BahmniPage {
	private final WebDriver driver;
	private HomePage homePage;

	public HomeSpec(){
		this.driver = DriverFactory.getDriver();
	}

	@BeforeClassSteps
	public void waitForAppReady(){
		new BahmniPage().waitForSpinner(driver);
	}

	@Step("Navigate to dashboard")
	public void navigateToHomePage() {
		driver.get(HomePage.URL);
	}


	@Step("Click on registration app")
	public void goToRegistrationPage(){
		homePage = PageFactory.getHomePage();
		homePage.clickRegistrationApp();
		new BahmniPage().waitForSpinner(driver);
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
		RegistrationFirstPage registrationPage = PageFactory.getRegistrationFirstPage();
		registrationPage.logout();
	}

}
