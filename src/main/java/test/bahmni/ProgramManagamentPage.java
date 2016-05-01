package test.bahmni;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class ProgramManagamentPage {
    
    @FindBy(how= How.CSS, using = "select.ng-pristine")
    public WebElement program;
    
    @FindBy(how= How.CSS, using = ".fa-plus-square")
    public WebElement expand;
    
    @FindBy(how= How.CSS, using = "input.ng-valid-max")
    public WebElement start_date;
    
    @FindBy(how= How.CSS, using = "[id='Facility Name']")
    public WebElement facility_name;
    
    @FindBy(how= How.CSS, using = "[id='Sample attribute3']")
    public WebElement facility_id;
    
    @FindBy(how= How.CSS, using = "#Doctor")
    public WebElement doctor;
    
    @FindBy(how= How.CSS, using = "#Enrollment")
    public WebElement Enrollment_id;
    
    @FindBy(how= How.CSS, using = ".fr")
    public WebElement enroll_btn;
    
    @FindBy(how= How.CSS, using = ".active-program-tiles")
    public WebElement active_progs;
    
    @FindBy(how= How.CSS, using = ".inactive-program-tiles")
    public WebElement inactive_progs;
    
    @FindBy(how= How.CSS, using = "[value='Save']")
    public WebElement save_btn;
    
    @FindBy(how= How.CSS, using = "[value='Edit']")
    public WebElement edit_btn;
    
    @FindBy(how= How.CSS, using = ".active-program-tiles #Enrollment")
    public WebElement activ_enrollmentID;
    
    @FindBy(how= How.CSS, using = ".active-program-tiles select.ng-pristine")
    public List<WebElement> outcome;
    
    Common app = new Common();
    
    public void expandProgramEnrollment() throws InterruptedException {
    	Common.waitUntilAppReady(Common.Webdriver);
    	expand.click();
	}
    
    public void selectProgram(String prog) throws InterruptedException {
    	Common.waitUntilAppReady(Common.Webdriver);
    	Select program_name = new Select(program);
    	program_name.selectByVisibleText(prog);
	}
	
	public void enterStartDate(String Date) throws InterruptedException {
		Common.waitUntilAppReady(Common.Webdriver);
		Thread.sleep(1000);
		start_date.sendKeys(Date);
	}
	
	public void enterFacilityName(String Facility) throws InterruptedException {
		Common.waitUntilAppReady(Common.Webdriver);
		facility_name.sendKeys(Facility);
	}
	
	public void enterFacilityID(String FacilityID) throws InterruptedException {
		Common.waitUntilAppReady(Common.Webdriver);
		facility_id.sendKeys(FacilityID);
	}
	
	public void enterDoctorName(String Doctor) throws InterruptedException {
		Common.waitUntilAppReady(Common.Webdriver);
		doctor.sendKeys(Doctor);
	}
	
	public void enterEnrollmentID(String EnrollmentID) throws InterruptedException {
		Enrollment_id.sendKeys(EnrollmentID);
	}
	
	public void clickEnroll() throws InterruptedException {
		Common.waitUntilAppReady(Common.Webdriver);
		enroll_btn.click();
	}
	
	public void clickEdit() throws InterruptedException {
		Common.waitUntilAppReady(Common.Webdriver);
		Thread.sleep(1000);
		edit_btn.click();
	}
	
	public void clickSave() throws InterruptedException {
		Common.waitUntilAppReady(Common.Webdriver);
		save_btn.click();
	}
	
	public void editEnrollmentID(String EnrollmentID) throws InterruptedException{
		Common.waitUntilAppReady(Common.Webdriver);
		activ_enrollmentID.clear();
		activ_enrollmentID.sendKeys(EnrollmentID);
	}
	
	public void selectOutcome(String Outcome) throws InterruptedException {
		
		Common.waitUntilAppReady(Common.Webdriver);
		for(int i=0;i<=outcome.size()-1;i++){
			
			if(outcome.get(i).getAttribute("ng-model").toString().contains("outcome")){
				
				Select out_come = new Select(outcome.get(i));
				out_come.selectByVisibleText(Outcome);
			}
		}
	}
	
	
	public void enrollToProgram() throws InterruptedException, IOException {
		Common.waitUntilAppReady(Common.Webdriver);
		selectProgram(app.getJsonKeyValue("patient/Programs/Program", "Name"));
		enterStartDate(app.getJsonKeyValue("patient/Programs/Program", "StartDate"));
		enterFacilityName(app.getJsonKeyValue("patient/Programs/Program", "FacilityName"));
		enterFacilityID(app.getJsonKeyValue("patient/Programs/Program", "FacilityID"));
		enterDoctorName(app.getJsonKeyValue("patient/Programs/Program", "Doctor"));
		enterEnrollmentID(app.getJsonKeyValue("patient/Programs/Program", "EnrollmentID"));
		enroll_btn.click();
		Common.waitUntilAppReady(Common.Webdriver);
	}
	
	public void editProgramEnrolled() throws InterruptedException, IOException {
		Common.waitUntilAppReady(Common.Webdriver);
		clickEdit();
		editEnrollmentID("E1111");
		clickSave();
		Common.waitUntilAppReady(Common.Webdriver);
	}
	
	public void endProgramEnrollment(String Outcome) throws InterruptedException{
		Common.waitUntilAppReady(Common.Webdriver);
		clickEdit();
		selectOutcome(Outcome);
		clickSave();
		Common.waitUntilAppReady(Common.Webdriver);
	}
	
}
