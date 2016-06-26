package org.bahmni.test.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegistrationSearch {

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
    public WebElement txtIdentifier;
	
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
    
    public void clickCreateNew() {
    	iconCreateNew.click();
    }

    private void enterName(String name) {
    	txtName.sendKeys(name);
    }
    
    public void searchByIdentifier(String prefix, String id){
	    txtRegistration.sendKeys(id);
	    btnIdentifierSearch.click();
    }
}
