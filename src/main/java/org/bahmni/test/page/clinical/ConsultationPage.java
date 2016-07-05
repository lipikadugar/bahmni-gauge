package org.bahmni.test.page.clinical;

import org.bahmni.test.Common;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ConsultationPage {
	
	@FindBy(how= How.CSS, using = ".btn--success")
    public WebElement clinical;
	
	@FindBy(how= How.CSS, using = ".consultation-tabs .tab-item")
    public List<WebElement> tabs;
	
	@FindBy(how= How.CSS, using = ".back-btn-link")
    public WebElement patient_profile;
	
	@FindBy(how= How.CSS, using = ".save-consultation")
    public WebElement save;
	
	public ConsultationPage(){
    	PageFactory.initElements(Common.Webdriver,this);
    }
	
    public void clickClinical() throws InterruptedException {
    	Common.waitForSpinner();
    	clinical.click();
    }
    
    public void clickSave() throws InterruptedException {
    	Common.waitForSpinner();
    	save.click();
    }
    
    public void clickPatientProfile() throws InterruptedException {
    	Common.waitForSpinner();
    	patient_profile.click();
    	Common.waitForSpinner();
    }
    
    public void clickTab(String Tabname) throws InterruptedException {
    	Common.waitForSpinner();
    	for(int i=0;i<=tabs.size()-1;i++){
    		if(tabs.get(i).getText().toString().contains(Tabname)){
    			tabs.get(i).click();
    		}
    	}
    }
    
    public void createBacteriologySample(String Date, String Sample, String ID ) throws InterruptedException{
    	Common.waitForSpinner();
    	clickTab("Bacteriology");
    	BacteriologyPage bacteriologyPage = new BacteriologyPage();
    	bacteriologyPage.createSample(Date, Sample, ID);
    	clickSave();
    	Common.waitForSpinner();
    }

}
