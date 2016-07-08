package org.bahmni.test;

import com.apple.eawt.AppEvent;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;

public class Tasks {

    @Step({"Navigate to dashboard"})
    public void navigateToDashboard() {
        DriverFactory.getDriver().get(System.getenv("url")+"/home/index.html#/dashboard");
    }

    @Step("Navigate to Registration search page")
    public static void navigateToSearchPage() {
        DriverFactory.getDriver().get(System.getenv("url")+"/registration/index.html#/search");
    }

    public void waitForSpinner(){
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 60);
            Boolean spinner = wait.until(ExpectedConditions
                    .invisibilityOfElementLocated(By.cssSelector("#overlay")));
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
