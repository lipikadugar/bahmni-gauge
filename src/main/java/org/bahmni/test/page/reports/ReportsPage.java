package org.bahmni.test.page.reports;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

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

}
