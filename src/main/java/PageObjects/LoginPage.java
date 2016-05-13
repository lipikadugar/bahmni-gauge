package PageObjects;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Library.Common;

public class LoginPage extends Common {
	
	@FindBy(how= How.CSS, using = "#username")
    public WebElement username_txt;

    @FindBy(how= How.CSS, using = "#password")
    public WebElement pass_txt;
    
    @FindBy(how= How.CSS, using = "#location")
    public WebElement location;
    
    @FindBy(how= How.CSS, using = "#locale")
    public WebElement locale;
    
    @FindBy(how= How.CSS, using = ".confirm")
    public WebElement signin_btn;
    
    public LoginPage(){
    	PageFactory.initElements(Common.Webdriver, this);
    }

    public void enterUsername(String user) throws InterruptedException {
        username_txt.sendKeys(user);
    }
    
    public void enterPassword(String pass) throws InterruptedException {
    	pass_txt.sendKeys(pass);
    }
    
    public void selectLocation(String login_loc) throws InterruptedException {
    	Select location_drpdown = new Select(location);
    	location_drpdown.selectByVisibleText(login_loc);
    }
    
    public void selectLocale(String loc) throws InterruptedException {
    	Select locale_drpdown = new Select(locale);
    	locale_drpdown.selectByVisibleText(loc);
    }

    public void clickLogin() throws InterruptedException  {
    	signin_btn.click();
    }
    
    public void login(String user, String pass, String loc, String locale) throws InterruptedException, IOException  {
    	Common.waitUntilAppReady(Common.Webdriver);
    	enterUsername(Common.getEnvDetails("QA","username"));
    	enterPassword(Common.getEnvDetails("QA","password"));
    	selectLocation(Common.getEnvDetails("QA","location"));
    	selectLocale(Common.getEnvDetails("QA","locale"));
    	signin_btn.click();
    }
    
    public void login() throws InterruptedException, IOException  {
    	Common.waitUntilAppReady(Common.Webdriver);
    	enterUsername(Common.getEnvDetails("QA","username"));
    	enterPassword(Common.getEnvDetails("QA","password"));
    	selectLocation(Common.getEnvDetails("QA","location"));
    	signin_btn.click();
    }
	

}
