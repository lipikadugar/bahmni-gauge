package org.bahmni.test.page.registration;

import org.bahmni.test.Common;
import org.bahmni.test.page.BahmniPage;
import org.bahmni.test.page.registration.domain.Patient;
import org.bahmni.test.page.PageFactory;
import org.bahmni.test.page.program.ProgramManagamentPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

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
	
	@FindBy(how= How.CSS, using = ".confirm")
	public WebElement programEnrollment;
	
	@FindBy(how= How.CSS, using = ".buttonClass")
	public List<WebElement> btnVisit;
	
	public RegistrationFirstPage(){
	}

	public void enterAddress(String vill) throws InterruptedException {
		addressLine.sendKeys("TestDemo");
	}
	
	public RegistrationFirstPage clickSave() {
		save.click();
		return PageFactory.getRegistrationFirstPage();
	}
	
	public ProgramManagamentPage clickTreatmentRegistration(){
		programEnrollment.click();
		return PageFactory.getProgramManagementPage();
	}
	
	public void startVisit() throws InterruptedException {
		Common.waitForSpinner();
		for(int i = 0; i< btnVisit.size()-1; i++)
		{
			if(btnVisit.get(i).getText().toString().contains("Start OPD visit"))
				btnVisit.get(i).click();
		}
	}

	public RegistrationFirstPage registerPatient(Patient patient) {
		Random randomGenerator = new Random();
		txtRegistrationNumber.sendKeys(patient.getIdNumber());
		txtPatientName.sendKeys(patient.getFirstName());
		familyName.sendKeys(patient.getLastName());
		new Select(gender).selectByVisibleText(patient.getGender());
		ageYears.sendKeys(patient.getAge());
		return clickSave();
	}

}
