package org.bahmni.test.page.registration;

import org.bahmni.test.page.BahmniPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class RegistrationSearch extends BahmniPage{

	@FindBy(how= How.CSS, using = ".fa-home")
    public WebElement iconHome;
	
	@FindBy(how= How.CSS, using = ".fa-search")
    public WebElement iconSearch;
	
	@FindBy(how= How.CSS, using = "i.fa-plus")
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
    
    public void clickCreateNew() {
    	iconCreateNew.click();
    }

    public void enterName(String name) {
    	txtName.sendKeys(name,Keys.ENTER);
    }
    
    public void searchByExactIdentifier(String prefix, String id){
	    selectPrefix(prefix);

	    txtRegistration.sendKeys(id);
	    btnIdentifierSearch.click();
    }

	private void selectPrefix(String prefix) {
		if(txtIdentifier.size()>0){
			new Select(txtIdentifier.get(0)).selectByVisibleText(prefix);
		}
	}

	public void searchByIdentifier(String prefix, String id){
		selectPrefix(prefix);

		txtRegistration.sendKeys(id);
		btnIdentifierSearch.click();
    }

	public void getFirstResult() {
		gridSearchResults.findElements(By.tagName("a")).get(0).click();

	}

	private Boolean isPatientInResult(String patientFirstName) {
		List<WebElement> patientListRows = gridSearchResults.findElements(By.xpath(".//tr"));
		for (WebElement element : patientListRows){
			String name = element.getText();
			if (name.contains(patientFirstName)) {return true;}
		}
		return false;
	}

	public void verifySearchResults() {
		//TODO: add verifying search results
	}
}
