package test.bahmni;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ObservationPage {
	
	String templateName = null;
	WebElement templateElement =null;
	
	public ObservationPage(ChromeDriver driver){
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(how= How.CSS, using = "#template-control-panel-button")
    public WebElement add_template;
	
	@FindBy(how= How.CSS, using = "concept-set-group>div")
	public List<WebElement> allTemplates;
	
	
	public void fillObsTemplate(String name) throws InterruptedException{
		this.templateName = name.replace(" ", "_");
		if (templatePresent(this.templateName)){expandSection(this.templateName);}else{addTemplate(this.templateName);}
	
	
		String temp = String.format("div[auto-scroll='%s']", this.templateName);
		System.out.println(temp);
		this.templateElement = Common.Webdriver.findElement(By.cssSelector(temp));
		
		fillTemplate();
		
	}
	
	private boolean templatePresent(String name) {
		List<WebElement> elements = Common.Webdriver.findElements(By.cssSelector("concept-set-group>div"));
		for (WebElement each: elements){
			if (each.getAttribute("auto-scroll").contains(name)){return true;}
		}
		return false;
	}

	private void fillTemplate() throws InterruptedException {
		//dataarray = ["Systolic"];
		
		List<WebElement> allFields = this.templateElement.findElements(By.cssSelector(".leaf-observation-node"));
		System.out.println(allFields);
		
		//for  (String each  : dataarray){
			for  (WebElement element : allFields){
				String field = element.findElements(By.cssSelector("label span")).get(0).getText();
				System.out.println(field);
//				if (field.contains(each)){
					element.findElement(By.cssSelector("input")).sendKeys("1");
//					break;
//				}
			}
		//}
		
	}

	private void addTemplate(String name) throws InterruptedException {
		Common.waitUntilAppReady(Common.Webdriver);
		add_template.click();		
		Common.Webdriver.findElement(By.id(name)).click();
	}

	public void expandSection(String templateName) throws InterruptedException {
		this.templateName = templateName.replace(" ", "_");
		Common.waitUntilAppReady(Common.Webdriver);
		String xpath = "//*[contains(@id, '"+this.templateName+"')]";
		String id = Common.Webdriver.findElement(By.xpath(xpath)).getAttribute("id");
		String divTemplateName = "div#"+id+" h2.section-title i.fa-caret-right";
		WebElement temp = Common.Webdriver.findElement(By.cssSelector(divTemplateName));
		temp.click();
		//if (temp.isDisplayed()){Common.Webdriver.findElement(By.cssSelector(templateName)).click();}
	}

	public void fillBaselineTemplate() {
		
		
		
	}
}
