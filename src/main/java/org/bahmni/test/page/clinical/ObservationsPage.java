package org.bahmni.test.page.clinical;

import org.bahmni.test.page.BahmniPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.util.List;

public class ObservationsPage extends BahmniPage {
	
	@FindBy(how= How.CSS, using = "#template-control-panel-button")
    public WebElement addFormbutton;
	
	@FindBy(how= How.CSS, using = ".template-control-panel")
    public WebElement templatePanel;

    public void selectTemplate(String templateName){
        addFormbutton.click();
        List<WebElement> allForms = templatePanel.findElements(By.cssSelector(".template-icons > button"));

        templateName = templateName.replace(" ","_");
        for(int i=0;i<=allForms.size();i++){
            if(allForms.get(i).getText().toString().contains(templateName))
                allForms.get(i).click();
        }
    }
	

}
