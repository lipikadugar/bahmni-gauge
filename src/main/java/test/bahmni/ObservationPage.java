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
		addTemplate(this.templateName);
		expandSection(this.templateName);	
		fillTemplate();
		
	}
	
	private void fillTemplate() throws InterruptedException {
		//dataarray = ["Systolic"];
		Common.waitUntilAppReady(Common.Webdriver);
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
		add_template.click();		
		Common.Webdriver.findElement(By.id(templateName)).click();
	}

	private void expandSection(String templateName) throws InterruptedException {
		String divTemplateName = "div#"+templateName+" h2.section-title i.fa-caret-right";
		WebElement temp = Common.Webdriver.findElement(By.cssSelector(divTemplateName));
		if (temp.isDisplayed()){Common.Webdriver.findElement(By.cssSelector(templateName)).click();}
		Common.waitUntilAppReady(Common.Webdriver);	
	}
}
