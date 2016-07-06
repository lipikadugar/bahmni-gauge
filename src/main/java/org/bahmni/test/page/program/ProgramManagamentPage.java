package org.bahmni.test.page.program;

import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import org.bahmni.test.Common;
import org.bahmni.test.TestSpecException;
import org.bahmni.test.page.BahmniPage;
import org.bahmni.test.page.PageFactory;
import org.bahmni.test.page.program.domain.Program;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.List;

public class ProgramManagamentPage extends BahmniPage {

	@FindBy(how = How.CSS, using = "select.ng-pristine")
	public WebElement program;

	@FindBy(how = How.CSS, using = ".fa-plus-square")
	public WebElement btnPlus;

	@FindBy(how = How.CSS, using = "input.ng-valid-max")
	public WebElement start_date;

	@FindBy(how = How.XPATH, using = "//input[@value='Enroll' and @type='submit']")
	public WebElement btnEnroll;

	@FindBy(how = How.CSS, using = ".active-program-tiles")
	public List<WebElement> allActivePrograms;

	@FindBy(how = How.CSS, using = ".inactive-program-tiles")
	public List<WebElement> inactive_progs;

	@FindBy(how = How.CSS, using = "[ng-model='patientProgram.outcomeData']")
	public WebElement treatment_status;

	@FindBy(how = How.CSS, using = "#dashboard-link")
	public List<WebElement> treatment_dashboard;

	@FindBy(how = How.CSS, using = ".active-program-container")
	public WebElement activeProgramContainer;

	@FindBy(how= How.CSS, using = "[id='Facility Name']")
	public WebElement facility_name;

	@FindBy(how= How.CSS, using = "[id='Sample attribute3']")
	public WebElement facility_id;

	@FindBy(how= How.CSS, using = "#Doctor")
	public WebElement doctor;

	@FindBy(how= How.CSS, using = "#Id_Number")
	public WebElement registration_id;

	public ProgramManagamentPage() {
	}

	public ProgramManagamentPage enrollPatientToProgram(Program treatment) {
		doActions(treatment);
		btnEnroll.click();
		return this;
	}

	protected void doActions(Program treatment) {
		btnPlus.click();
		new Select(program).selectByVisibleText(treatment.getName());
		start_date.sendKeys(treatment.getDateOfRegistration());
	}

	public ProgramManagamentPage modifyProgramEnrollment(Program treatment) {

		WebElement programToModify = findProgram(treatment);
		programToModify.findElement(By.cssSelector("[value='Edit']")).click();
		doModifyEnrollmentDetails(programToModify, treatment);
		programToModify.findElement(By.cssSelector("[value='Save']")).click();

		return PageFactory.getProgramManagementPage();
	}

	protected void doModifyEnrollmentDetails(WebElement programToModify, Program treatment) {

		if (treatment.getTreatmentStatus() != null) {
			WebElement outcome = programToModify.findElement(By.cssSelector("[ng-model='patientProgram.outcomeData']"));
			new Select(outcome).selectByVisibleText(treatment.getTreatmentStatus());
		}

		//TODO: Write modification for DateOfRegistration
	}

	private WebElement findProgram(Program treatment) {
		for (int i = 0; i < allActivePrograms.size(); i++) {
			if (allActivePrograms.get(i).getText().contains(treatment.getName())) {
				return allActivePrograms.get(i);
			}
		}
		throw new RuntimeException("The program with name [" + treatment.getName() + "] doesn't exist");
	}

	public void clickTreatmentDashboard(Program treatment) {
		WebElement programWidget = findProgram(treatment);
		programWidget.findElement(By.id("dashboard-link")).click();

	}

	public void endProgram(Program treatment) {
		//TODO: write logic for endingPrograms
	}

	//	public void endProgramEnrolled(String ProgramName) throws InterruptedException, IOException{
	//		Common.waitForSpinner();
	//		editProgram(ProgramName);
	//		selectTreatmentStatus(ProgramName, "Non Active");
	//		saveProgram(ProgramName);
	//		Common.waitForSpinner();
	//	}

	public boolean isPatientEnrolledToProgram(Program treatment) {
		WebElement programName = activeProgramContainer.findElement(By.cssSelector(".programName"));
		return isProgramAvailable(treatment, programName);
	}

	protected boolean isProgramAvailable(Program treatment, WebElement programName) {
		if (programName != null && programName.getText().contains(treatment.getName()))
			return true;
		else
			return false;
	}

	public boolean hasAttribute(String Attribute) throws InterruptedException, IOException {
		if (Common.Webdriver.findElement(By.cssSelector(".active-program-container")).getText().toString().contains(Attribute))
			return true;
		else
			return false;
	}

	public boolean hasEndedProgram(String ProgramName) throws InterruptedException, IOException {
		if (Common.Webdriver.findElement(By.cssSelector(".inactive-program-container")).getText().toString().contains(ProgramName))
			return true;
		else
			return false;
	}

	public Program transformTableToProgram(Table table) {
		List<TableRow> rows = table.getTableRows();
		List<String> columnNames = table.getColumnNames();

		if (rows.size() != 1) {
			throw new TestSpecException("Only one patient should be provided in the table");
		}

		String programName = rows.get(0).getCell(columnNames.get(0));
		String dateOfRegistration = rows.get(0).getCell(columnNames.get(1));

		return new Program(programName,dateOfRegistration);
	}

	public void editProgramAttributes(Program treatment, String registration, String facility) {
		WebElement programToModify = findProgram(treatment);
		programToModify.findElement(By.cssSelector("[value='Edit']")).click();
		editProgram(registration, facility);
		programToModify.findElement(By.cssSelector("[value='Save']")).click();
	}

	public ProgramManagamentPage editProgram(String registration, String facility) {
		facility_name.sendKeys(facility);
		registration_id.sendKeys(registration);
		return this;
	}
}
