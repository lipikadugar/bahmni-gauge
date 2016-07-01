package org.bahmni.test.page.registration;

import org.bahmni.test.Common;
import org.bahmni.test.page.BahmniPage;
import org.bahmni.test.page.PageFactory;
import org.bahmni.test.page.registration.domain.Patient;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class RegistrationFirstPage extends BahmniPage{
	
	@FindBy(how= How.CSS, using = "#givenName")
	public WebElement txtPatientName;
	
	@FindBy(how= How.CSS, using = "#registrationNumber")
	public WebElement txtRegistrationNumber;
	
	@FindBy(how= How.CSS, using = "#familyName")
	public WebElement familyName;
	
	@FindBy(how= How.CSS, using = "#gender")
	public WebElement gender;
	
	@FindBy(how= How.CSS, using = "#address4")
	public WebElement purusava;
	
	@FindBy(how= How.CSS, using = "#ageYears")
	public WebElement ageYears;
	
	@FindBy(how= How.CSS, using = "#cityVillage")
	public WebElement village;
	
	@FindBy(how= How.CSS, using = ".submit-btn")
	public WebElement save;
	
	@FindBy(how= How.CSS, using = "#address1")
	public WebElement addressLine;
	
	@FindBy(how= How.CSS, using = "strong > span")
	public WebElement new_patient;

	@FindBy(how= How.CSS, using = ".buttonClass")
	public List<WebElement> btnVisit;
	
	@FindBy(how= How.CSS, using = ".fa-search")
	public WebElement searchLink;
	
	public RegistrationFirstPage(){
	}

	public void enterAddress(String vill) throws InterruptedException {
		village.sendKeys(vill);
	}
	
	public RegistrationFirstPage clickSave() {
		save.click();
		return PageFactory.getRegistrationFirstPage();
	}
	
	public RegistrationVisitDetailsPage startVisit(String Visit) throws InterruptedException {
		Common.waitForSpinner();
		Common.Webdriver.findElement(By.cssSelector("div[option-click = 'visitControl.startVisit'] .toggle-button.fa.fa-caret-down")).click();
		
		for (WebElement visit: btnVisit){
			if (visit.getText().contains(Visit)){
				visit.click();
				Common.waitForSpinner();
				return PageFactory.getRegistrationVisitDetailsPage();
			}
			
		}
		return null;
	}

	public RegistrationFirstPage registerPatient(Patient patient) throws InterruptedException {
		doActions(patient);
		enterAddress("Achakmar");
		return clickSave();
	}

	protected void doActions(Patient patient){
		//txtRegistrationNumber.sendKeys(patient.getIdNumber());
		txtPatientName.sendKeys(patient.getFirstName());
		familyName.sendKeys(patient.getLastName());
		new Select(gender).selectByVisibleText(patient.getGender());
		ageYears.sendKeys(patient.getAge());
	}
	
	public RegistrationSearch navigateToPatientSearchPage(){
		searchLink.click();
		Common.waitForSpinner();
		return PageFactory.getRegistrationSearchPage();
		
	}

}
