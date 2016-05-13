package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Library.Common;

public class BacteriologyPage {
	
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
	
	@FindBy(how= How.CSS, using = ".savedSpecimens-container .fa-pencil")
    public WebElement edit;
	
	@FindBy(how= How.CSS, using = ".savedSpecimens-container .fa-remove")
    public WebElement delete;
	
	public BacteriologyPage(){
    	PageFactory.initElements(Common.Webdriver,this);
    }
	
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
    	edit.click();
    	sample_date.clear();
    	sample_date.sendKeys(date);
    	Thread.sleep(1000);
    	clickButton(type);
    	sample_id.clear();
    	sample_id.sendKeys(sample);
 
    	ConsultationPage consultationPage = PageFactory.initElements(Common.Webdriver,ConsultationPage.class);
    	consultationPage.clickSave();
    	Common.waitUntilAppReady(Common.Webdriver);
    }
    
    public void deleteSample(String date, String type, String sample) throws InterruptedException {
    	Common.waitUntilAppReady(Common.Webdriver);
    	WebElement delete_item = lookForBacteriologyResult(date,type,sample).findElement(By.cssSelector(".fa-remove"));
    	delete_item.click();
    	Thread.sleep(1000);
    	Common.Webdriver.switchTo().alert().accept();
    	Common.waitUntilAppReady(Common.Webdriver);
    	
    	ConsultationPage consultationPage = PageFactory.initElements(Common.Webdriver,ConsultationPage.class);
    	consultationPage.clickSave();
    	Common.waitUntilAppReady(Common.Webdriver);
    }
    
    public boolean isSampleExists(String Sample, String SampleID){
    	for(int i=0;i<=saved_specimen.size()-1;i++){
    		if(saved_specimen.get(i).getText().contains(Sample) && saved_specimen.get(i).getText().contains(SampleID)){
    			return true;
    		}
    	}
    	return false;
    }
    
    public WebElement lookForBacteriologyResult(String date, String type, String sample) {
    	for(int i=0;i<=saved_specimen.size();i++){
    		if(saved_specimen.get(i).getText().contains(date) && saved_specimen.get(i).getText().contains(sample))
    			return saved_specimen.get(i);
    	}
    	return null;
    }

}
