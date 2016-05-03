package test.bahmni;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BacteriologyPage {
	
	public BacteriologyPage(ChromeDriver driver){
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(how= How.CSS, using = "#sample-date")
    public WebElement sample_date;
	
	@FindBy(how= How.CSS, using = ".grid-row-element")
    public List<WebElement> sample_buttons;
	
	@FindBy(how= How.CSS, using = "#sample-id")
    public WebElement sample_id;
	
	@FindBy(how= How.CSS, using = ".fa-caret-right.ng-scope")
    public WebElement results;
	
	@FindBy(how= How.CSS, using = "#observation_4")
    public WebElement date_AFB;
	
	@FindBy(how= How.CSS, using = "#observation_5")
    public WebElement smear_ID;
	
	@FindBy(how= How.CSS, using = ".savedSpecimens-container")
    public List<WebElement> saved_specimen; 
	
    public void expandResults() throws InterruptedException {
    	results.click();
    }
    
    public void clickButton(String name) throws InterruptedException { 	
    	for(int i=0; i<= sample_buttons.size()-1; i++){
    		if(sample_buttons.get(i).getText().toString().contains(name))
    			sample_buttons.get(i).click();
    	}
    }
    
    public void enterSampleDate(String date) throws InterruptedException {
    	sample_date.sendKeys(date);
    }
    
    public void enterSampleID(String sample) throws InterruptedException {
    	sample_id.sendKeys(sample);
    }
    
    public void createSample(String date, String type, String sample) throws InterruptedException {
    	Common.waitUntilAppReady(Common.Webdriver);
    	sample_date.sendKeys(date);
    	Thread.sleep(1000);
    	clickButton(type);
    	sample_id.sendKeys(sample);
    	ConsultationPage consultationPage = PageFactory.initElements(Common.Webdriver,ConsultationPage.class);
    	consultationPage.clickSave();
    	Common.waitUntilAppReady(Common.Webdriver);
    }
    
    public void editSample(String date, String type, String sample) throws InterruptedException {
    	Common.waitUntilAppReady(Common.Webdriver);
    	sample_date.sendKeys(date);
    	Thread.sleep(1000);
    	clickButton(type);
    	sample_id.sendKeys(sample);
 
    	ConsultationPage consultationPage = PageFactory.initElements(Common.Webdriver,ConsultationPage.class);
    	consultationPage.clickSave();
    }
    
    public void deleteSample(String date, String type, String sample) throws InterruptedException {
    	Common.waitUntilAppReady(Common.Webdriver);
    	sample_date.sendKeys(date);
    	Thread.sleep(1000);
    	clickButton(type);
    	sample_id.sendKeys(sample);
 
    	ConsultationPage consultationPage = PageFactory.initElements(Common.Webdriver,ConsultationPage.class);
    	consultationPage.clickSave();
    }
    
    public boolean isSampleExists(String Sample, String SampleID){
    	for(int i=0;i<=saved_specimen.size()-1;i++){
    		if(saved_specimen.get(i).getText().contains(Sample) && saved_specimen.get(i).getText().contains(SampleID)){
    			return true;
    		}
    	}
    	return false;
    }

}
