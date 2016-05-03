package test.bahmni;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PatientListingPage extends Common {
	
	public PatientListingPage(ChromeDriver driver){
		PageFactory.initElements(driver,this);
	}

	@FindBy(how= How.CSS, using = ".tabs .tab-item")
    public List<WebElement> tab;

    @FindBy(how= How.CSS, using = "#patientIdentifier")
    public WebElement searchbox_txt;
    
    @FindBy(how= How.CSS, using = ".reg-srch-btn")
    public WebElement search;
    
    @FindBy(how= How.CSS, using = ".active-patient.patient-id")
    public WebElement patient;
    
    Common app = new Common();
    
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
    
    public void clickSearch(){
    	search.click();
    }
    
    /*public WebElement searchPatient(String Patient){
    	for(int i=0;i<=patient.size()-1;i++){
    		if(patient.get(i).getText().contains(Patient))
    			return patient.get(i);
    	}
    	return patient.get(patient.size()-1);
    }*/
    
    public void clickPatient(String Patient){
    	patient.click();
    }
    
    public void searchSelectPatientFromTabs(String Tab, String PatientID) throws IOException, InterruptedException{
    	Common.waitUntilAppReady(Common.Webdriver);
    	clickTab(Tab);
    	enterPatientIDOrName(app.getJsonKeyValue("patient", "ID"));
    	clickSearch();
    	//clickPatient(PatientID);	
    }
}
