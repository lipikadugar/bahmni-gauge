package org.bahmni.endtb.page;

import com.thoughtworks.gauge.Step;
import org.bahmni.test.PageFactory;
import org.bahmni.endtb.page.clinical.BaselinePage;
import org.bahmni.test.page.clinical.ObservationsPage;

/**
 * Created by dharmens on 7/13/16.
 */
public class ObservationSpec extends BaselinePage {

    @Step("Select the template <template> from on the observation page")
    public void clickOnTreatmentEnrollment(String template) {
        ObservationsPage observationsPage = PageFactory.getObservationsPage();
        observationsPage.selectTemplate(template);
    }

}
