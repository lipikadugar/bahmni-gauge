package test.bahmni;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TreatmentPage {
	
	@FindBy(how= How.CSS, using = "#drug-name")
    public WebElement drug_name;
	
	@FindBy(how= How.CSS, using = ".accept-btn")
    public WebElement accept_btn;
	
	@FindBy(how= How.CSS, using = "#uniform-dose")
    public WebElement dose;
	
	@FindBy(how= How.CSS, using = ".ui-menu-item")
    public WebElement drug_autocomplete;
	
	@FindBy(how= How.CSS, using = "#uniform-dose-unit")
    public WebElement dose_unit;
	
	@FindBy(how= How.CSS, using = "#frequency")
    public WebElement frequency;
	
	@FindBy(how= How.CSS, using = "#route")
    public WebElement route;
	
	@FindBy(how= How.CSS, using = "#start-date")
    public WebElement start_date;
	
	@FindBy(how= How.CSS, using = "#duration")
    public WebElement duration;
	
	@FindBy(how= How.CSS, using = "#duration-unit")
    public WebElement duration_unit;
	
	@FindBy(how= How.CSS, using = "#quantity")
    public WebElement quantity;
	
	@FindBy(how= How.CSS, using = "#total-quantity-unit")
    public WebElement total_quantity_unit;
	
	@FindBy(how= How.CSS, using = ".add-drug-btn")
    public WebElement add_btn;
	
	@FindBy(how= How.CSS, using = ".reset-drug-form")
    public WebElement clear_btn;
	
	@FindBy(how= How.CSS, using = ".save-consultation")
    public WebElement save_btn;
	
	@FindBy(how= How.CSS, using = ".treatment-section-right")
    public WebElement treatment_section;
	
	@FindBy(how= How.CSS, using = ".stop-drug-btn")
    public WebElement stop_drug_btn;
	
	@FindBy(how= How.CSS, using = ".refill-btn")
    public WebElement refill_drug_btn;
	
	Common app = new Common();
	
	public TreatmentPage(){
    	PageFactory.initElements(Common.Webdriver,this);
    }
	
	public void addDrug(String DrugName) throws InterruptedException {
		Common.waitUntilAppReady(Common.Webdriver);
		  drug_name.sendKeys(DrugName);
		  Thread.sleep(2000);
		  drug_autocomplete.click();
	 }
	
	 public void selectUnits(String Unit) throws InterruptedException {
		 Common.waitUntilAppReady(Common.Webdriver);
		 Select units = new Select(dose_unit);
		 units.selectByVisibleText(Unit);
	 }
	 
	 public void selectFrequency(String Frequency) throws InterruptedException {
		 Common.waitUntilAppReady(Common.Webdriver);
		 Select units = new Select(frequency);
		 units.selectByVisibleText(Frequency);
	 }
	 
	 public void selectRoute(String Route) throws InterruptedException {
		 Common.waitUntilAppReady(Common.Webdriver);
		 Select units = new Select(route);
		 units.selectByVisibleText(Route);
		 
	 }
	 
	 public void savePrecription() throws InterruptedException {
		 Common.waitUntilAppReady(Common.Webdriver);
		  save_btn.click();
	 }
	    
	 public void prescribeDrugToPatient(String DrugName) throws InterruptedException, IOException {
		 Common.waitUntilAppReady(Common.Webdriver);
		 addDrug(app.getJsonKeyValue("patient/Treatment/"+DrugName+"","Name"));
		 dose.sendKeys(app.getJsonKeyValue("patient/Treatment/"+DrugName+"","Dose"));
		 selectUnits(app.getJsonKeyValue("patient/Treatment/"+DrugName+"","Unit"));
		 selectFrequency(app.getJsonKeyValue("patient/Treatment/"+DrugName+"","Frequency"));
		 selectRoute(app.getJsonKeyValue("patient/Treatment/"+DrugName+"","Route"));
		 duration.sendKeys(app.getJsonKeyValue("patient/Treatment/"+DrugName+"","Duration"));
		 start_date.sendKeys(app.getJsonKeyValue("patient/Treatment/"+DrugName+"","StartDate"));
		 add_btn.click(); 
	 } 
	    
	 public void prescribeFreeTextDrugToPatient(String DrugName) throws InterruptedException, IOException {
		 Common.waitUntilAppReady(Common.Webdriver);
		 drug_name.sendKeys(app.getJsonKeyValue("patient/Treatment/"+DrugName+"","Name"));
		 accept_btn.click();
		 dose.sendKeys(app.getJsonKeyValue("patient/Treatment/"+DrugName+"","Dose"));
		 selectUnits(app.getJsonKeyValue("patient/Treatment/"+DrugName+"","Unit"));
		 selectFrequency(app.getJsonKeyValue("patient/Treatment/"+DrugName+"","Frequency"));
		 selectRoute(app.getJsonKeyValue("patient/Treatment/"+DrugName+"","Route"));
		 duration.sendKeys(app.getJsonKeyValue("patient/Treatment/"+DrugName+"","Duration"));
		 start_date.sendKeys(app.getJsonKeyValue("patient/Treatment/"+DrugName+"","StartDate"));
		 add_btn.click();
	 } 
	 
	public boolean hasText(String Drug){
		if(treatment_section.getText().contains(Drug))
			return true;
		else
			return false;
	 }

}
