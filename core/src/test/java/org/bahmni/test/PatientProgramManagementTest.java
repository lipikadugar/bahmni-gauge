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

import static org.junit.Assert.assertTrue;

/**
 * Created by dharmens on 6/30/16.
 */

public class PatientProgramManagementTest extends Startup {

    HomePage homePage = null;
    Program program;


    @Ignore
    @Test
    public void registerNewPatient() throws InterruptedException{
        RegistrationFirstPage registrationFirstPage = BahmniTestCase.start()
                .login()
                .clickRegistrationApp()
                .clickCreateNew()
                .registerPatient(new Patient("1234"+ new Random().nextInt(),"bharat","akkin","Male",null,50))
                .isPatientCreated();
    }

    @Test
    public void enrollPatientToProgram(){
        program = new Program("Second-line TB treatment register", "01/01/2015", "F1234", "TestLocation", "Mohan", "EN1234");

        Boolean programManagementPage = (Boolean)((HomePage)homePage)
                .clickProgramsApp()
                .enrollPatientToProgram(program)
                .isPatientEnrolledToProgram(program);
    }

    @Test
    public void editProgramAttributes(){
        Boolean programManagementPage = (Boolean)((HomePage)homePage)
                .clickProgramsApp()
                .editProgramEnrollment(program)
                .isPatientEnrolledToProgram(program);
    }

    @Test
    public void endPatientProgram(){
        ProgramManagementPage programManagementPage = (ProgramManagementPage)((HomePage)homePage)
                .clickProgramsApp()
                .endProgramEnrollment(program);
    }
}
