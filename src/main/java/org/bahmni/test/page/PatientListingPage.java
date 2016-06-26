package org.bahmni.test.page;

import org.bahmni.test.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public class PatientListingPage extends Common {

	@FindBy(how= How.CSS, using = ".tabs .tab-item")
    public List<WebElement> tab;

    @FindBy(how= How.CSS, using = "#patientIdentifier")
    public WebElement searchbox_txt;
    
    @FindBy(how= How.CSS, using = ".active-patient.patient-id")
    public WebElement patient;
    
    @FindBy(how= How.CSS, using = ".patient-list-table")
    public WebElement patient_table;
    
    Common app = new Common();
    
    public PatientListingPage(){
    	PageFactory.initElements(Common.Webdriver,this);
    }
    
    public WebElement findTab(String Tab){
    	for(int i=0;i<=tab.size();i++)
    	{
    		if(tab.get(i).getText().contains(Tab))
    			return tab.get(i);
    	}
    	return tab.get(tab.size()-1);
    }
    
    public void clickTab(String Tab){
    	WebElement tab = findTab(Tab);
    	tab.click();
    }
    
    public void enterPatientIDOrName(String Patient){
    	searchbox_txt.sendKeys(Patient);
    }
    
    public void selectPatient(String Patient){
    	
    	List<WebElement> results = patient_table.findElements(By.cssSelector(".ng-binding"));
    	for(int i=0;i<=results.size();i++){
    		if(results.get(i).getText().contentEquals(Patient))
    		{
    			results.get(i).click();
    			break;
    		}
    	}
    }
  
    public void searchSelectPatientFromTable(String PatientID) throws IOException, InterruptedException{
    	Common.waitForSpinner();
    	enterPatientIDOrName(PatientID);	//app.getJsonKeyValue("patient", "ID")
    	selectPatient(PatientID);	
    }
}
