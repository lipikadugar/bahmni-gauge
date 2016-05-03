package test.bahmni;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationSearchPage {
	
	public RegistrationSearchPage(ChromeDriver driver){
		PageFactory.initElements(driver,this);
	}

	@FindBy(how= How.CSS, using = ".fa-home")
    public WebElement home;
	
	@FindBy(how= How.CSS, using = ".fa-search")
    public WebElement search;
	
	@FindBy(how= How.CSS, using = ".fa-plus")
    public WebElement create_new;
	
	@FindBy(how= How.CSS, using = "#registrationNumber")
    public WebElement registration_txt;
	
	@FindBy(how= How.CSS, using = "#name")
    public WebElement name_txt;
	
	@FindBy(how= How.CSS, using = "#identifierPrefix")
    public WebElement identifier_txt;
	
	@FindBy(how= How.CSS, using = ".reg-srch-btn > button")
    public WebElement identifer_search_btn;
	
	@FindBy(how= How.CSS, using = ".registraition-search-results-container > table")
    public WebElement search_results;
	

    public void clickSearch() throws InterruptedException {
    	Common.waitUntilAppReady(Common.Webdriver);
    	search.click();
    }
    
    public void clickHome() throws InterruptedException {
    	Common.waitUntilAppReady(Common.Webdriver);
    	home.click();
    }
    
    public void clickCreateNew() throws InterruptedException {
    	Common.waitUntilAppReady(Common.Webdriver);
    	create_new.click();
    }
    
    public void enterRegistrationNo(String registration) throws InterruptedException {
    	registration_txt.sendKeys(registration);
    }
    
    public void enterName(String name) throws InterruptedException {
    	name_txt.sendKeys(name);
    }
    
    public void selectIdentifier(String identifier_prefix) throws InterruptedException {
    	Select identifier = new Select(identifier_txt);
    	identifier.selectByVisibleText(identifier_prefix);
    }
    
    public void clickIdentiferSearch() throws InterruptedException {
    	Common.waitUntilAppReady(Common.Webdriver);
    	identifer_search_btn.click();
    }
    
    public void searchPatientWithID(String Prefix, String ID) throws InterruptedException {
    	Common.waitUntilAppReady(Common.Webdriver);
    	selectIdentifier(Prefix);
    	enterRegistrationNo(ID);
    	clickIdentiferSearch();
    }
}
