package org.bahmni.endtb.page.clinical;


import org.bahmni.test.page.BahmniPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class BaselinePage extends BahmniPage {
	
	@FindBy(how= How.ID, using ="template-control-panel-button")
    public WebElement create_template_button;

	@FindBy(how= How.XPATH, using ="//div[starts-with(@id,'concept-set-')]")
    public List<WebElement> concept_text;

    
}
