package org.bahmni.test.page.registration;

import org.bahmni.test.page.BahmniPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegistrationVisitDetailsPage extends BahmniPage{
	
	@FindBy(how= How.CSS, using = "#observation_1")
	public WebElement height;
	
	@FindBy(how= How.CSS, using = "#observation_2")
	public WebElement weight;
	
	@FindBy(how= How.CSS, using = "#observation_4")
	public WebElement fees;
	
	@FindBy(how= How.CSS, using = "#observation_5")
	public WebElement comments;
	
	@FindBy(how= How.CSS, using = ".confirm")
	public WebElement saveButton;
	
	@FindBy(how= How.CSS, using = ".fa-home")
	public WebElement homeButton;
	
	@FindBy(how= How.CSS, using = "button[ng-click='back()']")
	public WebElement backButton;

	@FindBy(how= How.CSS, using = "button.cancel")
	public WebElement closeVisit;
	
	@FindBy(how= How.CSS, using = ".fa-search")
	public WebElement searchLink;


}
