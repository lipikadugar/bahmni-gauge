package test.bahmni;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginPage extends Common {
	
	public LoginPage(ChromeDriver driver) {
    	PageFactory.initElements(driver,this);
	}
	
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
    
    public void login(String user, String pass, String loc, String locale) throws InterruptedException  {
    	
    	Common.waitUntilAppReady(Common.Webdriver);
    	
    	enterUsername(user);
    	enterPassword(pass);
    	selectLocation(loc);
    	selectLocale(locale);
    	signin_btn.click();
    }
    
    public void login(String user, String pass, String loc) throws InterruptedException  {
    	
    	Common.waitUntilAppReady(Common.Webdriver);
    	
    	enterUsername(user);
    	enterPassword(pass);
    	selectLocation(loc);

    	signin_btn.click();
    }
	

}
