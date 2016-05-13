package PageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Library.Common;

public class ReportsPage {
	
	@FindBy(how= How.CSS, using = "tbody > tr")
    public List<WebElement> all_reports;
	
	@FindBy(how= How.CSS, using = ".reports-start-date .start-date")
    public WebElement start_date;
	
	@FindBy(how= How.CSS, using = ".reports-stop-date .start-date")
    public WebElement stop_date;
	
	@FindBy(how= How.CSS, using = ".reports-format .ng-pristine")
    public WebElement format;
	
	@FindBy(how= How.CSS, using = "td > span")
    public WebElement report_name;
	
	public ReportsPage(){
    	PageFactory.initElements(Common.Webdriver,this);
    }

    public void setStartDate(String start) throws InterruptedException {
    	start_date.sendKeys(start);
    }
    
    public void setStopDate(String stop) throws InterruptedException {
    	stop_date.sendKeys(stop);
    }
    
    public void setReportFormat(String report_type) throws InterruptedException {
    	Select format_type = new Select(format);
    	format_type.selectByVisibleText(report_type);
    }
    
    public void selectAndRun(String name) throws InterruptedException {
    	
    	for(int i=0;i<=all_reports.size();i++){
    		
    		if(all_reports.get(i).getText().contains(name)){
    			WebElement action_button = all_reports.get(i).findElement(By.cssSelector(".reports-action"));
    			action_button.click();
    			break;
    		}
    	}
    	
    }
    
    public void selectAndRunReport(String Report, String StartDate, String StopDate, String Format) throws InterruptedException {
    	Common.waitUntilAppReady(Common.Webdriver);
    	setStartDate(StartDate);
    	setStopDate(StopDate);
    	setReportFormat(Format);
    	selectAndRun(Report);
    	
    	Common.waitUntilAppReady(Common.Webdriver);
    	Common.getCurrentTab();
    	Common.Webdriver.navigate().refresh();//Common.getEnvDetails("QA", "URL")+"/bahmnireports/report?name=Chief%20Complaint%20Report&startDate=2016-01-01&endDate=2016-04-01&responseType=text/html&paperSize=A3");
    }

}
