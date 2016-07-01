package org.bahmni.test;

import org.bahmni.test.page.PageFactory;
import org.bahmni.test.page.home.HomePage;
import org.bahmni.test.page.program.ProgramManagementPage;
import org.bahmni.test.page.registration.RegistrationFirstPage;
import org.bahmni.test.page.registration.domain.Patient;
import org.bahmni.test.page.program.domain.Program;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Random;

/**
 * Created by dharmens on 6/30/16.
 */

public class PatientProgramManagementTest {

    RegistrationFirstPage registrationFirstPage = null;
    HomePage homePage = null;


    @Ignore
    @Test
    public void registerNewPatient(){
        RegistrationFirstPage registrationFirstPage = BahmniTestCase.start()
                .login()
                .clickRegistrationApp()
                .clickCreateNew()
                .registerPatient(new Patient("1234"+ new Random().nextInt(),"bharat","akkin","Male",null,50))
                .isPatientCreated();
    }

    @Test
    public void enrollPatientToProgram(){
        Program program = new Program("Second-line TB treatment register", "01/01/2015");

        ProgramManagementPage programManagementPage = (ProgramManagementPage)((HomePage)homePage)
                .clickProgramsApp()
                .enrollPatientToProgram(program);

        assertTrue(programManagementPage.isPatientEnrolledToProgram(program));


    }

    @Test
    public void editProgramAttributes(){
        RegistrationFirstPage registrationFirstPage = BahmniTestCase.start()
                .login()
                .clickRegistrationApp()
                .searchByIdentifier("IND","20020")
                .getFirstResult();
    }

    @Test
    public void endPatientProgram(){
        RegistrationFirstPage registrationFirstPage = BahmniTestCase.start()
                .login()
                .clickRegistrationApp()
                .searchByIdentifier("IND","20020")
                .getFirstResult();
    }
}
