package org.bahmni.test.page;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import org.bahmni.test.Common;

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
    	Common.waitForSpinner();
    	expand.click();
	}*/
    
    public void selectProgram(String prog) throws InterruptedException {
    	Common.waitForSpinner();
    	Select program_name = new Select(program);
    	program_name.selectByVisibleText(prog);
	}
	
	public void enterStartDate(String Date) throws InterruptedException {
		Common.waitForSpinner();
		Thread.sleep(1000);
		start_date.sendKeys(Date);
	}
	
	public void enterRegistrationNumber(String Facility) throws InterruptedException {
		Common.waitForSpinner();
		registration_number.sendKeys(Facility);
	}
	
	public void enterRegistrationFacility(String FacilityName) throws InterruptedException {
		Common.waitForSpinner();
    	Select facility_name = new Select(registration_facility);
    	facility_name.selectByVisibleText(FacilityName);
	}
	
	public void clickEnroll() throws InterruptedException {
		Common.waitForSpinner();
		enroll_btn.click();
	}
	
	public void editProgram(String ProgramName) throws InterruptedException {
		Common.waitForSpinner();
		for(int i=0;i<=active_progs.size()-1;i++){
			if(active_progs.get(i).getText().contains(ProgramName)){
				active_progs.get(i).findElement(By.cssSelector("[value='Edit']")).click();
			}
		}
	}
	
	public void saveProgram(String ProgramName) throws InterruptedException {
		Common.waitForSpinner();
		for(int i=0;i<=active_progs.size()-1;i++){
			if(active_progs.get(i).getText().contains(ProgramName)){
				active_progs.get(i).findElement(By.cssSelector("[value='Save']")).click();
			}
		}
	}
	
	public void editRegistrationNumber(String ProgramName, String RegistrationNo) throws InterruptedException{
		Common.waitForSpinner();
		for(int i=0;i<=active_progs.size()-1;i++){
			if(active_progs.get(i).getText().contains(ProgramName)){
				WebElement reg_no = active_progs.get(i).findElement(By.cssSelector("[id='Registration Number']"));
				reg_no.clear();
				reg_no.sendKeys(RegistrationNo);
			}
		}
	}
	
	public void selectTreatmentStatus(String ProgramName, String Outcome) throws InterruptedException {
		Common.waitForSpinner();
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
		Common.waitForSpinner();
		for(int i=0;i<=treatment_dashboard.size()-1;i++){
			if(treatment_dashboard.get(i).getText().contains(ProgramName)){
				treatment_dashboard.get(i).click();
			}
		}
	}
	
	
	public void enrollToProgram(String ProgramName, String Date, String RegistrationNumber, String RegistrationFacility) throws InterruptedException, IOException {
		Common.waitForSpinner();
		expand.click();
		Common.waitForSpinner();
		selectProgram(ProgramName);
		enterStartDate(Date);
		enterRegistrationNumber(RegistrationNumber);
		enterRegistrationFacility(RegistrationFacility);
		enroll_btn.click();
		Common.waitForSpinner();
	}
	
	public void selectTreatmentDashboard(String ProgramName) throws InterruptedException, IOException {
		Common.waitForSpinner();
		clickTreatmentStatus(ProgramName);		//app.getJsonKeyValue("patient/Programs/Program", "Name")
		Common.waitForSpinner();
	}
	
	public void editProgramEnrolled(String ProgramName) throws InterruptedException, IOException {
		Common.waitForSpinner();
		Thread.sleep(1000);
		editProgram(ProgramName);
		editRegistrationNumber(ProgramName,"E1111");
		saveProgram(ProgramName);
		Common.waitForSpinner();
	}
	
	public void endProgramEnrolled(String ProgramName) throws InterruptedException, IOException{
		Common.waitForSpinner();
		editProgram(ProgramName);
		selectTreatmentStatus(ProgramName, "Non Active");
		saveProgram(ProgramName);
		Common.waitForSpinner();
	}
	
	public boolean hasEnrolledProgram(String ProgramName) throws InterruptedException, IOException{
		if(Common.Webdriver.findElement(By.cssSelector(".active-program-container")).getText()
				.toString().contains(ProgramName))
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
	
	public boolean hasEndedProgram(String ProgramName) throws InterruptedException, IOException{
		if(Common.Webdriver.findElement(By.cssSelector(".inactive-program-container")).getText()
				.toString().contains(ProgramName))
			return true;
		else
			return false;
	}
	
}
