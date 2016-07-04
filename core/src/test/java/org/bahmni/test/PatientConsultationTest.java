package org.bahmni.test;

import org.bahmni.test.page.BahmniPage;
import org.bahmni.test.page.clinical.BacteriologyPage;
import org.bahmni.test.page.clinical.ConsultationPage;
import org.bahmni.test.page.clinical.DashboardPage;
import org.bahmni.test.page.clinical.domain.BacteriologySample;
import org.bahmni.test.page.home.HomePage;
import org.bahmni.test.page.program.ProgramManagementPage;
import org.bahmni.test.page.program.domain.Program;
import org.junit.Test;

/**
 * Created by dharmens on 7/3/16.
 */
public class PatientConsultationTest extends Startup  {

    @Test
    public void shouldBeAbleToAddEditAndDeleteBacteriologyTests() throws java.io.IOException, java.lang.InterruptedException {
        BacteriologySample sample = new BacteriologySample("Urine", "23/02/16", "EN1234");

        Boolean bacteriology = (Boolean) BahmniTestCase.start()
                .login()
                .clickClinicalApp()
                .searchSelectPatientFromTab("All","GAN201234")
                .clickClinical()
                .clickTab("Bacteriology")
                .addSample(sample)
                .clickBacteriologySave()
                .isSampleExists(sample);

        Boolean bacteriology_edit = new BacteriologyPage()
                .editSample(new BacteriologySample("Urine", "23/02/16", "EN1111"))
                .clickBacteriologySave()
                .isSampleExists(sample);

        Boolean bacteriology_delete = new BacteriologyPage()
                .deleteSample(sample)
                .clickBacteriologySave()
                .isSampleExists(sample);
    }

    @Test
    public void shouldBeAbleToRecordObservations() throws java.io.IOException, java.lang.InterruptedException {
        BacteriologySample sample = new BacteriologySample("Urine", "23/02/16", "EN1234");

        Boolean bacteriology = (Boolean) BahmniTestCase.start()
                .login()
                .clickClinicalApp()
                .searchSelectPatientFromTab("All","GAN201234")
                .clickClinical()
                .clickTab("Bacteriology")
                .addSample(sample)
                .clickBacteriologySave()
                .isSampleExists(sample);

        Boolean bacteriology_edit = new BacteriologyPage()
                .editSample(new BacteriologySample("Urine", "23/02/16", "EN1111"))
                .clickBacteriologySave()
                .isSampleExists(sample);

        Boolean bacteriology_delete = new BacteriologyPage()
                .deleteSample(sample)
                .clickBacteriologySave()
                .isSampleExists(sample);
    }

}
