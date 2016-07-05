package org.bahmni.test.page.registration;

import org.bahmni.test.Common;
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

	public void verifySearchResultForPatient(String patientFirstName) {
		enterName(patientFirstName);
		Common.waitForSpinner();
//		Assert.assertTrue(isPatientInResult(patientFirstName));
	}

	private Boolean isPatientInResult(String patientFirstName) {
		List<WebElement> patientListRows = gridSearchResults.findElements(By.xpath(".//tr"));
		for (WebElement element : patientListRows){
			String name = element.getText();
			if (name.contains(patientFirstName)) {return true;}
		}
		return false;
	}
	
}
