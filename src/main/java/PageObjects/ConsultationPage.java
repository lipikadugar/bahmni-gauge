package PageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Library.Common;

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
    	Common.waitUntilAppReady(Common.Webdriver);
    	clinical.click();
    }
    
    public void clickSave() throws InterruptedException {
    	Common.waitUntilAppReady(Common.Webdriver);
    	save.click();
    }
    
    public void clickPatientProfile() throws InterruptedException {
    	Common.waitUntilAppReady(Common.Webdriver);
    	patient_profile.click();
    	Common.waitUntilAppReady(Common.Webdriver);
    }
    
    public void clickTab(String Tabname) throws InterruptedException {
    	Common.waitUntilAppReady(Common.Webdriver);
    	for(int i=0;i<=tabs.size()-1;i++){
    		if(tabs.get(i).getText().toString().contains(Tabname)){
    			tabs.get(i).click();
    		}
    	}
    }
    
    public void createBacteriologySample(String Date, String Sample, String ID ) throws InterruptedException{
    	Common.waitUntilAppReady(Common.Webdriver);
    	clickTab("Bacteriology");
    	BacteriologyPage bacteriologyPage = new BacteriologyPage();
    	bacteriologyPage.createSample(Date, Sample, ID);
    	clickSave();
    	Common.waitUntilAppReady(Common.Webdriver);
    }

}
