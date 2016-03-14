package test.bahmni;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Common {
	
	public static ChromeDriver driver;
	
	public ChromeDriver getChromeDriver() throws InterruptedException{
		driver = new ChromeDriver();
		return driver;
	}
	
	public void waitForObject(ChromeDriver driver) throws InterruptedException{
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		Boolean elem_obj = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#overlay")));	
	}
	
	public void launchApp() throws InterruptedException{
		driver.get("https://172.18.2.27/home");
		Thread.sleep(3000);
	}

}
