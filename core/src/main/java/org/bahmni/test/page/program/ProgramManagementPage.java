package org.bahmni.test.page.program;

import org.bahmni.test.Common;
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

public class ProgramManagementPage extends BahmniPage{
    
    @FindBy(how= How.CSS, using = "select.ng-pristine")
    public WebElement program;
    
    @FindBy(how= How.CSS, using = ".fa-plus-square")
    public WebElement btnPlus;
    
    @FindBy(how= How.CSS, using = "input.ng-valid-max")
    public WebElement start_date;

    @FindBy(how= How.XPATH, using = "//input[@value='Enroll' and @type='submit']")
    public WebElement btnEnroll;

	@FindBy(how= How.CSS, using = "[id='Facility Name']")
	public WebElement facility_name;

	@FindBy(how= How.CSS, using = "[id='Sample attribute3']")
	public WebElement facility_id;

	@FindBy(how= How.CSS, using = "#Doctor")
	public WebElement doctor;

	@FindBy(how= How.CSS, using = "#Enrollment")
	public WebElement enrollment_id;

	@FindBy(how= How.CSS, using = ".active-program-tiles #Enrollment")
	public WebElement activ_enrollmentID;

    @FindBy(how= How.CSS, using = ".active-program-tiles")
    public List<WebElement> allActivePrograms;
    
    @FindBy(how= How.CSS, using = ".inactive-program-tiles")
    public List<WebElement> inactive_progs;
    
    @FindBy(how= How.CSS, using = "[ng-model='patientProgram.outcomeData']")
    public WebElement treatment_status;
    
    @FindBy(how= How.CSS, using = "#dashboard-link")
    public List<WebElement> treatment_dashboard;

	@FindBy(how=How.CSS, using=".active-program-container")
	public WebElement activeProgramContainer;

    public ProgramManagementPage(){
    }

	public ProgramManagementPage enrollPatientToProgram(Program treatment){
		doActions(treatment);
		btnEnroll.click();
		return this;
	}

	protected void doActions(Program treatment) {
		btnPlus.click();
		new Select(program).selectByVisibleText(treatment.getName());
		start_date.sendKeys(treatment.getDateOfRegistration());
		facility_id.sendKeys(treatment.getFacilityID());
		facility_name.sendKeys(treatment.getFacilityName());
		doctor.sendKeys(treatment.getDoctor());
		enrollment_id.sendKeys(treatment.getEnrollmentID());
	}

	public ProgramManagementPage editProgramEnrollment(Program treatment){

		WebElement programToModify = findProgram(treatment);
		programToModify.findElement(By.cssSelector("[value='Edit']")).click();
		doModifyEnrollmentDetails(programToModify,treatment);
		programToModify.findElement(By.cssSelector("[value='Save']")).click();

		return PageFactory.getProgramManagementPage();
	}

	public ProgramManagementPage endProgramEnrollment(Program treatment){

		WebElement programToModify = findProgram(treatment);
		programToModify.findElement(By.cssSelector("[value='Edit']")).click();
		selectOutome(programToModify,treatment);
		programToModify.findElement(By.cssSelector("[value='Save']")).click();

		return PageFactory.getProgramManagementPage();
	}

	protected void doModifyEnrollmentDetails(WebElement programToModify, Program treatment) {
		activ_enrollmentID.clear();
		activ_enrollmentID.sendKeys(treatment.getEnrollmentID()+"123");
	}

	protected void selectOutome(WebElement programToModify, Program treatment) {
		if(treatment.getTreatmentStatus()!=null){
			WebElement outcome = programToModify.findElement(By.cssSelector("[ng-model='patientProgram.outcomeData']"));
			new Select(outcome).selectByVisibleText(treatment.getTreatmentStatus());
		}
	}

	private WebElement findProgram(Program treatment){
		for(int i = 0; i< allActivePrograms.size(); i++){
			if(allActivePrograms.get(i).getText().contains(treatment.getName())){
				return allActivePrograms.get(i);
			}
		}
		throw new RuntimeException("The program with name ["+treatment.getName()+"] doesn't exist");
	}

	public ProgramManagementPage clickTreatmentDashboard(Program treatment){
		WebElement programWidget = findProgram(treatment);
		programWidget.findElement(By.id("dashboard-link")).click();
		return PageFactory.getProgramManagementPage();

	}

//	public void endProgramEnrolled(String ProgramName) throws InterruptedException, IOException{
//		Common.waitForSpinner();
//		editProgram(ProgramName);
//		selectTreatmentStatus(ProgramName, "Non Active");
//		saveProgram(ProgramName);
//		Common.waitForSpinner();
//	}
	
	public Boolean isPatientEnrolledToProgram(Program treatment) {
		return (activeProgramContainer.findElement(By.cssSelector(".programName")).getText()
				.toString().contains(treatment.getName()));
	}

	protected boolean isProgramAvailable(Program treatment) {
		if(Common.Webdriver.findElement(By.cssSelector(".active-program-container")).getText()
				.toString()
				.contains(treatment.getName()))
			return true;
		else
			return false;
	}

	public boolean hasAttribute(String Attribute) throws InterruptedException, IOException{
		if(Common.Webdriver.findElement(By.cssSelector(".active-program-container")).getText()
				.toString().contains(Attribute))
			return true;
		else
			return false;
	}
	
	public boolean isProgramEnded(String ProgramName) throws InterruptedException, IOException{
		if(Common.Webdriver.findElement(By.cssSelector(".inactive-program-container")).getText()
				.toString().contains(ProgramName))
			return true;
		else
			return false;
	}
	
}
