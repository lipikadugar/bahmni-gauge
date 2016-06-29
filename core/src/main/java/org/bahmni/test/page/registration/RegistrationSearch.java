package org.bahmni.test.page.registration;

import org.bahmni.test.page.BahmniPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class RegistrationSearch extends BahmniPage{

	@FindBy(how= How.CSS, using = ".fa-home")
    public WebElement iconHome;
	
	@FindBy(how= How.CSS, using = ".fa-search")
    public WebElement iconSearch;
	
	@FindBy(how= How.CSS, using = ".fa-plus")
    public WebElement iconCreateNew;
	
	@FindBy(how= How.CSS, using = "#registrationNumber")
    public WebElement txtRegistration;
	
	@FindBy(how= How.CSS, using = "#name")
    public WebElement txtName;
	
	@FindBy(how= How.CSS, using = "#identifierPrefix")
    public List<WebElement> txtIdentifier;
	
	@FindBy(how= How.CSS, using = ".reg-srch-btn > button")
    public WebElement btnIdentifierSearch;
	
	@FindBy(how= How.CSS, using = ".registraition-search-results-container > table")
    public WebElement gridSearchResults;
	
	public RegistrationSearch(){
	}

    public void clickSearch() {
    	iconSearch.click();
    }
    
    public void clickHome() {
    	iconHome.click();
    }
    
    public RegistrationFirstPage clickCreateNew() {
    	iconCreateNew.click();
	    return org.bahmni.test.page.PageFactory.getRegistrationFirstPage();
    }

    private void enterName(String name) {
    	txtName.sendKeys(name);
    }
    
    public RegistrationFirstPage searchByExactIdentifier(String prefix, String id){
	    selectPrefix(prefix);

	    txtRegistration.sendKeys(id);
	    btnIdentifierSearch.click();

	    return org.bahmni.test.page.PageFactory.getRegistrationFirstPage();
    }

	private void selectPrefix(String prefix) {
		if(txtIdentifier.size()>0){
			new Select(txtIdentifier.get(0)).selectByVisibleText(prefix);
		}
	}

	public RegistrationSearch searchByIdentifier(String prefix, String id){
		selectPrefix(prefix);

		txtRegistration.sendKeys(id);
		btnIdentifierSearch.click();
	    return org.bahmni.test.page.PageFactory.getRegistrationSearchPage();
    }

	public RegistrationFirstPage getFirstResult() {
		gridSearchResults.findElements(By.tagName("a")).get(0).click();
		
		return org.bahmni.test.page.PageFactory.getRegistrationFirstPage();
	}
	
}
