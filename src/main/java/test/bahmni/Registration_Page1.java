package test.bahmni;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Registration_Page1 {
	
	public Registration_Page1(ChromeDriver driver){
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(how= How.CSS, using = "#givenName")
	public WebElement patientName;
	
	@FindBy(how= How.CSS, using = "#familyName")
	public WebElement familyName;
	
	@FindBy(how= How.CSS, using = "#gender")
	public WebElement gender;
	
	@FindBy(how= How.CSS, using = "#address4")
	public WebElement purusava;
	
	@FindBy(how= How.CSS, using = "#ageYears")
	public WebElement ageYears;
	
	@FindBy(how= How.CSS, using = "#cityVillage")
	public WebElement village;
	
	@FindBy(how= How.CSS, using = ".submit-btn")
	public WebElement save;
	
	@FindBy(how= How.CSS, using = "#address1")
	public WebElement addr_line;
	
	@FindBy(how= How.CSS, using = "strong > span")
	public WebElement new_patient;
	
	@FindBy(how= How.CSS, using = ".buttonClass")
	public List<WebElement> visit_btn;
	
	Common app = new Common();
	
	public void enterFirstName(String Firstname) throws InterruptedException {
		patientName.sendKeys(Firstname);
	}
	
	public void enterLastName(String Lastname) throws InterruptedException {
		familyName.sendKeys(Lastname);
	}
	
	public void enterGender(String gen) throws InterruptedException {
		Select patient_gen = new Select(gender);
		patient_gen.selectByVisibleText(gen);
	}
	
	public void enterAgeYears(String year) throws InterruptedException {
		ageYears.sendKeys(year);
	}
	
	public void enterVillage(String vill) throws InterruptedException {
		village.sendKeys(vill+Keys.ARROW_DOWN);
	}
	
	public void enterAddress(String vill) throws InterruptedException {
		//purusava.sendKeys(vill+Keys.ARROW_DOWN);
		//purusava.clear();
		addr_line.sendKeys("TestDemo");
	}
	
	public void clickSave() throws InterruptedException {
		Common.waitUntilAppReady(Common.Webdriver);
		save.click();
	}
	
	public void startVisit() throws InterruptedException {
		Common.waitUntilAppReady(Common.Webdriver);
		for(int i=0;i<visit_btn.size()-1;i++)
		{
			if(visit_btn.get(i).getText().toString().contains("Start OPD visit"))
				visit_btn.get(i).click();
		}
	}
	
	public void createNewPatient(String filename) throws InterruptedException, IOException{
		Common.waitUntilAppReady(Common.Webdriver);
		enterFirstName(app.getJsonKeyValue("patient","FirstName"));
		enterLastName(app.getJsonKeyValue("patient","LastName"));
		enterGender(app.getJsonKeyValue("patient","Gender"));
		enterAgeYears(app.getJsonKeyValue("patient","Age")); 
		//enterVillage(app.getJsonKeyValue("patient","Village"));
		enterAddress(app.getJsonKeyValue("patient","Village"));
		clickSave();
	}

}
