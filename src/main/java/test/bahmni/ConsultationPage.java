package test.bahmni;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ConsultationPage {
	
	public ConsultationPage(ChromeDriver driver){
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(how= How.CSS, using = ".btn--success")
    public WebElement clinical;
	
	@FindBy(how= How.CSS, using = ".consultation-tabs .tab-item")
    public List<WebElement> tabs;
	
	@FindBy(how= How.CSS, using = ".save-consultation")
    public WebElement save;
	
    public void clickClinical() throws InterruptedException {
    	Common.waitUntilAppReady(Common.Webdriver);
    	clinical.click();
    }
    
    public void clickSave() throws InterruptedException {
    	Common.waitUntilAppReady(Common.Webdriver);
    	save.click();
    }
    
    public void clickTab(String Tabname) throws InterruptedException {
    	Common.waitUntilAppReady(Common.Webdriver);
    	WebElement tab = null;
    	for(int i=0;i<=tabs.size()-1;i++){
    		if(tabs.get(i).getText().toString().contains(Tabname)){
    			tabs.get(i).click();
    		}
    	}
    }

}
