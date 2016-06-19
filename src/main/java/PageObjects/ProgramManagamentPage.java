package PageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Library.Common;

public class ProgramManagamentPage {
    
    @FindBy(how= How.CSS, using = "select.ng-pristine")
    public WebElement program;
    
    @FindBy(how= How.CSS, using = ".fa-plus-square")
    public WebElement expand;
    
    @FindBy(how= How.CSS, using = "input.ng-valid-max")
    public WebElement start_date;
    
    @FindBy(how= How.CSS, using = "[id='Registration Number']")
    public WebElement registration_number;
    
    @FindBy(how= How.CSS, using = "[id='Registration Facility']")
    public WebElement registration_facility;
    
    @FindBy(how= How.CSS, using = ".fr")
    public WebElement enroll_btn;
    
    @FindBy(how= How.CSS, using = ".active-program-tiles")
    public List<WebElement> active_progs;
    
    @FindBy(how= How.CSS, using = ".inactive-program-tiles")
    public List<WebElement> inactive_progs;
    
    @FindBy(how= How.CSS, using = "[ng-model='patientProgram.outcomeData']")
    public WebElement treatment_status;
    
    @FindBy(how= How.CSS, using = "#dashboard-link")
    public List<WebElement> treatment_dashboard;
    
    Common app = new Common();
    
    public ProgramManagamentPage(){
    	PageFactory.initElements(Common.Webdriver, this);
    }
    
    /*public void expandProgramEnrollment() throws InterruptedException {
    	Common.waitUntilAppReady(Common.Webdriver);
    	expand.click();
	}*/
    
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
	
	public void enterRegistrationNumber(String Facility) throws InterruptedException {
		Common.waitUntilAppReady(Common.Webdriver);
		registration_number.sendKeys(Facility);
	}
	
	public void enterRegistrationFacility(String FacilityName) throws InterruptedException {
		Common.waitUntilAppReady(Common.Webdriver);
    	Select facility_name = new Select(registration_facility);
    	facility_name.selectByVisibleText(FacilityName);
	}
	
	public void clickEnroll() throws InterruptedException {
		Common.waitUntilAppReady(Common.Webdriver);
		enroll_btn.click();
	}
	
	public void editProgram(String ProgramName) throws InterruptedException {
		Common.waitUntilAppReady(Common.Webdriver);
		for(int i=0;i<=active_progs.size()-1;i++){
			if(active_progs.get(i).getText().contains(ProgramName)){
				active_progs.get(i).findElement(By.cssSelector("[value='Edit']")).click();
			}
		}
	}
	
	public void saveProgram(String ProgramName) throws InterruptedException {
		Common.waitUntilAppReady(Common.Webdriver);	
		for(int i=0;i<=active_progs.size()-1;i++){
			if(active_progs.get(i).getText().contains(ProgramName)){
				active_progs.get(i).findElement(By.cssSelector("[value='Save']")).click();
			}
		}
	}
	
	public void editRegistrationNumber(String ProgramName, String RegistrationNo) throws InterruptedException{
		Common.waitUntilAppReady(Common.Webdriver);
		for(int i=0;i<=active_progs.size()-1;i++){
			if(active_progs.get(i).getText().contains(ProgramName)){
				WebElement reg_no = active_progs.get(i).findElement(By.cssSelector("[id='Registration Number']"));
				reg_no.clear();
				reg_no.sendKeys(RegistrationNo);
			}
		}
	}
	
	public void selectTreatmentStatus(String ProgramName, String Outcome) throws InterruptedException {
		Common.waitUntilAppReady(Common.Webdriver);
		WebElement outcome = null;
		for(int i=0;i<=active_progs.size()-1;i++){
			if(active_progs.get(i).getText().contains(ProgramName)){
				outcome = active_progs.get(i).findElement(By.cssSelector("[ng-model='patientProgram.outcomeData']"));
			}
		}
		Select out_come = new Select(outcome);
		out_come.selectByVisibleText(Outcome);
	}
	
	public void clickTreatmentStatus(String ProgramName) throws InterruptedException {
		Thread.sleep(2000);
		Common.waitUntilAppReady(Common.Webdriver);
		for(int i=0;i<=treatment_dashboard.size()-1;i++){
			if(treatment_dashboard.get(i).getText().contains(ProgramName)){
				treatment_dashboard.get(i).click();
			}
		}
	}
	
	
	public void enrollToProgram() throws InterruptedException, IOException {
		Common.waitUntilAppReady(Common.Webdriver);
		expand.click();
		Common.waitUntilAppReady(Common.Webdriver);
		selectProgram(app.getJsonKeyValue("patient/Programs/Program", "Name"));
		enterStartDate(app.getJsonKeyValue("patient/Programs/Program", "StartDate"));
		enterRegistrationNumber(app.getJsonKeyValue("patient/Programs/Program", "RegistrationNumber"));
		enterRegistrationFacility(app.getJsonKeyValue("patient/Programs/Program", "RegistrationFacility"));
		enroll_btn.click();
		Common.waitUntilAppReady(Common.Webdriver);
	}
	
	public void selectTreatmentDashboard() throws InterruptedException, IOException {
		Common.waitUntilAppReady(Common.Webdriver);
		clickTreatmentStatus(app.getJsonKeyValue("patient/Programs/Program", "Name"));
		Common.waitUntilAppReady(Common.Webdriver);
	}
	
	public void editProgramEnrolled() throws InterruptedException, IOException {
		Common.waitUntilAppReady(Common.Webdriver);
		Thread.sleep(1000);
		editProgram(app.getJsonKeyValue("patient/Programs/Program", "Name"));
		editRegistrationNumber(app.getJsonKeyValue("patient/Programs/Program", "Name"),"E1111");
		saveProgram(app.getJsonKeyValue("patient/Programs/Program", "Name"));
		Common.waitUntilAppReady(Common.Webdriver);
	}
	
	public void endProgramEnrolled() throws InterruptedException, IOException{
		Common.waitUntilAppReady(Common.Webdriver);
		editProgram(app.getJsonKeyValue("patient/Programs/Program", "Name"));
		selectTreatmentStatus(app.getJsonKeyValue("patient/Programs/Program", "Name"), "Non Active");
		saveProgram(app.getJsonKeyValue("patient/Programs/Program", "Name"));
		Common.waitUntilAppReady(Common.Webdriver);
	}
	
	public boolean hasEnrolledProgram() throws InterruptedException, IOException{
		if(Common.Webdriver.findElement(By.cssSelector(".active-program-container")).getText()
				.toString().contains(app.getJsonKeyValue("patient/Programs/Program", "Name")))
			return true;
		else
			return false;
	}
	
	public boolean hasAttribute() throws InterruptedException, IOException{
		if(Common.Webdriver.findElement(By.cssSelector(".active-program-container")).getText()
				.toString().contains("E1111"))
			return true;
		else
			return false;
	}
	
	public boolean hasEndedProgram() throws InterruptedException, IOException{
		if(Common.Webdriver.findElement(By.cssSelector(".inactive-program-container")).getText()
				.toString().contains(app.getJsonKeyValue("patient/Programs/Program", "Name")))
			return true;
		else
			return false;
	}
	
}
