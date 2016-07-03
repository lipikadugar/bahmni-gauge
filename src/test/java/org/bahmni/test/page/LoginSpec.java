package org.bahmni.test.page;

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

	@Step("On the login page")
	public void navigateToLoginPage() {
		driver.get(LoginPage.LOGIN_URL);
	}

	@Step("Login with username <username> and password <password>")
	public void login(String username,String password){
		LoginPage loginPage = PageFactory.getLoginPage();
		loginPage.login(username,password);
	}
}
