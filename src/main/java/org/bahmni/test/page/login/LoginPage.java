package org.bahmni.test.page.login;

import org.bahmni.test.page.BahmniPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class LoginPage extends BahmniPage{

	public static final String LOGIN_URL = BASE_URL.concat("/home");
	
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

	public void login(){
		login("superman","Admin123","Registration Desk","en");
	}

	public void login(String username, String password){
		login(username,password,"Registration Desk","en");
	}

    public void login(String username, String password, String location, String locale){
	    txtUserName.sendKeys(username);
	    txtPassword.sendKeys(password);
	    new Select(cmbLocation).selectByVisibleText(location);
	    new Select(cmbLocale).selectByVisibleText(locale);
    	btnLogin.click();
    }
}
