package org.bahmni.test.page;

import com.thoughtworks.gauge.BeforeClassSteps;
import com.thoughtworks.gauge.BeforeStep;
import com.thoughtworks.gauge.Step;
import org.bahmni.test.DriverFactory;
import org.bahmni.test.PageFactory;
import org.bahmni.test.page.login.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginSpec {

	private final WebDriver driver;

	public LoginSpec(){
		this.driver = DriverFactory.getDriver();
	}

	@BeforeClassSteps
	public void waitForAppReady(){
		new BahmniPage().waitForSpinner(driver);
	}

	@Step("On the login page")
	public void navigateToLoginPage() {
		//System.out.println(PageFactory.getLoginPage().LOGIN_URL);
		driver.get(PageFactory.getLoginPage().LOGIN_URL);
	}

	@Step("Login with username <username> and password <password>")
	public void login(String username,String password){
		LoginPage loginPage = PageFactory.getLoginPage();
		loginPage.login(username,password);
	}
}
