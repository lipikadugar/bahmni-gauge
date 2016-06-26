package org.bahmni.test.page;

import org.bahmni.test.Common;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class Registration_Page1 {
	
	@FindBy(how= How.CSS, using = "#givenName")
	public WebElement patientName;
	
	@FindBy(how= How.CSS, using = "#registrationNumber")
	public WebElement registration_num;
	
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
	public WebElement addr_line;
	
	@FindBy(how= How.CSS, using = "strong > span")
	public WebElement new_patient;
	
	@FindBy(how= How.CSS, using = ".confirm")
	public WebElement treatment_reg;
	
	@FindBy(how= How.CSS, using = ".buttonClass")
	public List<WebElement> visit_btn;
	
	public Registration_Page1(){
		PageFactory.initElements(Common.Webdriver, this);
	}
	
	Common app = new Common();
	
	public void enterID() throws InterruptedException {
		Random randomGenerator = new Random();
		Common.patientID = "EMD"+ randomGenerator.nextInt(10000);
		registration_num.sendKeys(Common.patientID);
	}
	
	public void enterFirstName(String Firstname) throws InterruptedException {
		patientName.sendKeys(Firstname);
	}
	
	public void enterLastName(String Lastname) throws InterruptedException {
		familyName.sendKeys(Lastname);
	}
	
	public void enterGender(String gen) throws InterruptedException {
		Select patient_gen = new Select(gender);
		patient_gen.selectByVisibleText(gen);
	}
	
	public void enterAgeYears(String year) throws InterruptedException {
		ageYears.sendKeys(year);
	}
	
	public void enterVillage(String vill) throws InterruptedException {
		village.sendKeys(vill+Keys.ARROW_DOWN);
	}
	
	public void enterAddress(String vill) throws InterruptedException {
		//purusava.sendKeys(vill+Keys.ARROW_DOWN);
		//purusava.clear();
		addr_line.sendKeys("TestDemo");
	}
	
	public void clickSave() throws InterruptedException {
		Common.waitForSpinner();
		save.click();
	}
	
	public void clickTreatmentRegistration() throws InterruptedException{
		Common.waitForSpinner();
		treatment_reg.click();
	}
	
	public void startVisit() throws InterruptedException {
		Common.waitForSpinner();
		for(int i=0;i<visit_btn.size()-1;i++)
		{
			if(visit_btn.get(i).getText().toString().contains("Start OPD visit"))
				visit_btn.get(i).click();
		}
	}

	public void createNewPatient() throws InterruptedException, IOException{
		createNewPatient("B","A","Male","22");
	}
	
	public void createNewPatient(String FirstName, String LastName, String Gender, String Age) throws InterruptedException, IOException{
		Common.waitForSpinner();
		enterID();
		enterFirstName(FirstName);
		enterLastName(LastName);
		enterGender(Gender);
		enterAgeYears(Age); 
		//clickSave();
		clickTreatmentRegistration();
		Common.waitForSpinner();
	}

}
