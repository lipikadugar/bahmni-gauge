package test.bahmni;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Common {
	
	public static ChromeDriver Webdriver;
	
	public void waitForObject(ChromeDriver driver) throws InterruptedException{
		Thread.sleep(4000);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		Boolean elem_obj = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#overlay")));	
	}
	
	public ChromeDriver launchApp() throws InterruptedException{
		Webdriver = new ChromeDriver();
		Webdriver.manage().window().setSize(new Dimension(1440,900));
		Webdriver.get("https://172.18.2.27/home");
		Thread.sleep(3000);
		
		return Webdriver;
	}
	
	public void navigateToDashboard() throws InterruptedException{
		Webdriver.get("https://172.18.2.27/bahmni/home/index.html#/dashboard");	
	}
	
	public String getJsonKeyValue(String jsonPath,String key) throws IOException{
		
		InputStream fis = new FileInputStream("..//bahmni//PatientProfile.json");
        JsonReader jsonReader = Json.createReader(fis);
        //get JsonObject from JsonReader
        JsonObject jsonObject = jsonReader.readObject();   
        JsonArray jsonArray = jsonObject.getJsonArray("patients");
        
        String[] path = jsonPath.split("/");
        jsonObject = (JsonObject) jsonArray.get(0);
        
        for(int i=0;i<path.length;i++)
        	jsonObject = (JsonObject) jsonObject.get(path[i]);
        		
        jsonReader.close();
        fis.close();
        
        if(jsonObject.get(key)!=null)
        	return jsonObject.get(key).toString().substring(1, jsonObject.get(key).toString().length()-1);
        
        return null;
	}
}
