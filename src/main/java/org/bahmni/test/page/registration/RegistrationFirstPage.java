package org.bahmni.test.page.registration;

import com.thoughtworks.gauge.TableRow;
import org.bahmni.test.page.BahmniPage;
import org.bahmni.test.page.registration.domain.Patient;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class RegistrationFirstPage extends BahmniPage {

	public static final String URL = BASE_URL.concat("/registration/#/patient/new");

	@FindBy(how = How.CSS, using = "#givenName")
	public WebElement txtPatientName;

	@FindBy(how = How.CSS, using = "#registrationNumber")
	public WebElement txtRegistrationNumber;

	@FindBy(how = How.CSS, using = "#familyName")
	public WebElement familyName;

	@FindBy(how = How.CSS, using = "#gender")
	public WebElement gender;

	@FindBy(how = How.CSS, using = "#address4")
	public WebElement purusava;

	@FindBy(how = How.CSS, using = "#ageYears")
	public WebElement ageYears;

	@FindBy(how = How.CSS, using = "#cityVillage")
	public WebElement village;

	@FindBy(how = How.CSS, using = ".submit-btn")
	public WebElement save;

	@FindBy(how = How.CSS, using = "#address1")
	public WebElement addressLine;

	@FindBy(how = How.CSS, using = "strong > span")
	public WebElement new_patient;

	@FindBy(how = How.CSS, using = ".buttonClass")
	public List<WebElement> btnVisit;

	@FindBy(how = How.CSS, using = ".fa-search")
	public WebElement searchLink;

	@FindBy(how = How.CSS, using = "#hasOldIdentifier")
	public WebElement enterID_checkbox;

	@FindBy(how = How.CSS, using = "#registrationNumber")
	public WebElement enterID;

	public void clickSave() {
		save.click();
	}

	public void registerPatient(Patient patient) {
		txtPatientName.sendKeys(patient.getFirstName());
		familyName.sendKeys(patient.getLastName());
		new Select(gender).selectByVisibleText(patient.getGender());
		ageYears.sendKeys(patient.getAge());
		village.sendKeys(patient.getVillage());
		clickSave();
	}

	protected void doActions(Patient patient) {
		if (txtRegistrationNumber.isDisplayed()) {
			txtRegistrationNumber.sendKeys(patient.getIdNumber());
		}
		txtPatientName.sendKeys(patient.getFirstName());
		familyName.sendKeys(patient.getLastName());
		new Select(gender).selectByVisibleText(patient.getGender());
		ageYears.sendKeys(patient.getAge());
		village.sendKeys(patient.getVillage());
	}

	public void navigateToSearchPage() {
		searchLink.click();
	}

	public void verifyPatientWithIdentifierAndName() {
		Patient patient = getPatientFromSpecStore();
		//TODO: Find a way to identify the identifier in edit mode with correct selector
		//TODO: write a correct assertion
//		Assert.assertTrue(familyName.getText().equals(lastName) && txtPatientName.getText().equals(firstName));
	}

	public void selectEnterPatientID(){
		enterID_checkbox.click();
	}

	public Patient transformTableRowToPatient(TableRow row, List<String> columnNames) {
		//String randomPatientId = "EMR"+new Random().nextInt();
		Patient patient = new Patient("", row.getCell(columnNames.get(1)),
				row.getCell(columnNames.get(2)), row.getCell(columnNames.get(3)), new Date(), 50,row.getCell(columnNames.get(6)));

		return patient;
	}

	public void startVisit(String visit) {
		//TODO: add startVisit
	}
}
