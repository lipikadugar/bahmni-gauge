import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import org.bahmni.test.Common;
import org.bahmni.test.page.home.HomePage;
import org.bahmni.test.page.registration.RegistrationFirstPage;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;

public class CommonStepImplementation {

    private HashSet<Character> vowels;

    @Step("Vowels in English language are <vowelString>.")
    public void setLanguageVowels(String vowelString) {
        vowels = new HashSet<>();
        for (char ch : vowelString.toCharArray()) {
            vowels.add(ch);
        }
    }

    @Step({"Navigate to dashboard","Navigate to the dashboard page"})
    public void navigateToDashboard() throws InterruptedException {
        Common.navigateToDashboard();
    }

    @Step("Navigate to Registration search page")
    public void navigateToRegistrationSearchPage() throws InterruptedException {
        Common.navigateToSearchPage();
    }

}
