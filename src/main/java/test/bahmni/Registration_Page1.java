package test.bahmni;

import static org.junit.Assert.assertNotNull;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class Registration_Page1 {
	
	@FindBy(how= How.CSS, using = "#givenName")
	public WebElement patientName;
	
	@FindBy(how= How.CSS, using = "#familyName")
	public WebElement familyName;
	
	@FindBy(how= How.CSS, using = "#gender")
	public WebElement gender;
	
	@FindBy(how= How.CSS, using = "#ageYears")
	public WebElement ageYears;
	
	@FindBy(how= How.CSS, using = "#cityVillage")
	public WebElement village;
	
	@FindBy(how= How.CSS, using = ".submit-btn")
	public WebElement save;
	
	@FindBy(how= How.CSS, using = "strong > span")
	public WebElement new_patient;
	
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
	
	public void clickSave() throws InterruptedException {
		save.click();
	}
	
	public void createNewPatient(String Firstname,String Lastname, String gen, String year, String vill) throws InterruptedException{
		enterFirstName(Firstname);
		enterLastName(Lastname);
		enterGender(gen);
		enterAgeYears(year); 
		enterVillage(vill);
		clickSave();
	}

}
