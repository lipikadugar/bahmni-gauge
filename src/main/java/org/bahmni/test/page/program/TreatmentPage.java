package org.bahmni.test.page.program;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TreatmentPage {
	
	@FindBy(how= How.CSS, using = "#drug-name")
    public WebElement drug_name;
	
	@FindBy(how= How.CSS, using = ".accept-btn")
    public WebElement accept_btn;
	
	@FindBy(how= How.CSS, using = "#uniform-dose")
    public WebElement dose;
	
	@FindBy(how= How.CSS, using = ".ui-menu-item")
    public WebElement drug_autocomplete;
	
	@FindBy(how= How.CSS, using = "#uniform-dose-unit")
    public WebElement dose_unit;
	
	@FindBy(how= How.CSS, using = "#frequency")
    public WebElement frequency;
	
	@FindBy(how= How.CSS, using = "#route")
    public WebElement route;
	
	@FindBy(how= How.CSS, using = "#start-date")
    public WebElement start_date;
	
	@FindBy(how= How.CSS, using = "#duration")
    public WebElement duration;
	
	@FindBy(how= How.CSS, using = "#duration-unit")
    public WebElement duration_unit;
	
	@FindBy(how= How.CSS, using = "#quantity")
    public WebElement quantity;
	
	@FindBy(how= How.CSS, using = "#total-quantity-unit")
    public WebElement total_quantity_unit;
	
	@FindBy(how= How.CSS, using = ".add-drug-btn")
    public WebElement add_btn;
	
	@FindBy(how= How.CSS, using = ".reset-drug-form")
    public WebElement clear_btn;
	
	@FindBy(how= How.CSS, using = ".save-consultation")
    public WebElement save_btn;
	
	@FindBy(how= How.CSS, using = ".treatment-section-right")
    public WebElement treatment_section;
	
	@FindBy(how= How.CSS, using = ".stop-drug-btn")
    public WebElement stop_drug_btn;
	
	@FindBy(how= How.CSS, using = ".refill-btn")
    public WebElement refill_drug_btn;
	

}
