package org.bahmni.test.page;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import org.bahmni.test.Common;

public class ObservationTemplatesPage {
	
	@FindBy(how= How.ID, using ="template-control-panel-button")
    public WebElement create_template_button;

	@FindBy(how= How.XPATH, using ="//div[starts-with(@id,'concept-set-')]")
    public List<WebElement> concept_text;
    
	@FindBy(how= How.XPATH, using ="//button[@ng-click='toggleTemplate(template)']")
    public List<WebElement> template_name;
    
	
	@FindBy(how= How.CSS, using =".control-label>span[ng-bind='::observation.label']")
    public List<WebElement> alllabel;
	
	public ObservationTemplatesPage(){
    	PageFactory.initElements(Common.Webdriver,this);
    }
    
    public void addTemplate(String id) throws InterruptedException {
    	Common.waitForSpinner();
    	create_template_button.click();
    	for(int j=0;j<template_name.size();j++){
    		if(template_name.get(j).getText().equals(id)) {
    			template_name.get(j).click();
    			break;
    		}
    	}
    	
        Thread.sleep(2000); 
     }
    
    public void fillTemplateData(String labelname,String labeltype,String labelvalue) {
    	
    	for(int j=0;j<alllabel.size();j++) {
    		if(alllabel.get(j).getText().equals(labelname)) {
    			if(labeltype.equals("textbox")) {
    				alllabel.get(j).findElement(By.xpath("../../div/div/div/input")).sendKeys(labelvalue);    	
            	}
    			
            	else if(labeltype.equals("button")) {
            		List<WebElement> allbutton=alllabel.get(j).findElements(By.xpath("../../div/div/div/div/div/button-select/div/button"));
            		for(int i=0;i<allbutton.size();i++) {
            			if(allbutton.get(i).getText().equals(labelvalue)) {
            				allbutton.get(i).click();	
            				break;
            			}
            		}
            	}
            	else if(labeltype.equals("textarea")) {
            		alllabel.get(j).findElement(By.xpath("../../div/div/div/textarea")).sendKeys(labelvalue);    	
            	}    	
            }  	
        }
    }
    
}
