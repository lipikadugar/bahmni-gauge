package org.bahmni.test.page.login;

import org.bahmni.test.Common;
import org.bahmni.test.page.BahmniPage;
import org.bahmni.test.page.PageFactory;
import org.bahmni.test.page.home.HomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class LoginPage extends BahmniPage{
	
	@FindBy(how= How.CSS, using = "#username")
    public WebElement txtUserName;

    @FindBy(how= How.CSS, using = "#password")
    public WebElement txtPassword;
    
    @FindBy(how= How.CSS, using = "#location")
    public WebElement cmbLocation;
    
    @FindBy(how= How.CSS, using = "#locale")
    public WebElement cmbLocale;
    
    @FindBy(how= How.CSS, using = ".confirm")
    public WebElement btnLogin;

    public LoginPage(){
    }

	public HomePage login(){
		return login("superman","Admin123","Registration Desk","en");
	}

	public HomePage login(String username, String password){
		return login(username,password,"Registration Desk","en");
	}

    public HomePage login(String username, String password, String location, String locale){
	    txtUserName.sendKeys(username);
	    txtPassword.sendKeys(password);
	    new Select(cmbLocation).selectByVisibleText(location);
	    new Select(cmbLocale).selectByVisibleText(locale);
    	btnLogin.click();
    	Common.waitForSpinner();
	    return PageFactory.getHomePage();
    }
}
