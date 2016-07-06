import com.thoughtworks.gauge.Step;

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

    @Step({"Navigate to dashboard"})
    public void navigateToDashboard() throws InterruptedException {
    }

    @Step("Navigate to Registration search page")
    public void navigateToRegistrationSearchPage() throws InterruptedException {
    }

}
