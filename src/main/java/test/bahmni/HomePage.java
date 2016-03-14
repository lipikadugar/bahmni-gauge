package test.bahmni;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {

	@FindBy(how= How.CSS, using = ".fa-user")
    public WebElement app_module;

    public void clickModule(String module) throws InterruptedException {
        app_module.click();
    }
	
	
}
