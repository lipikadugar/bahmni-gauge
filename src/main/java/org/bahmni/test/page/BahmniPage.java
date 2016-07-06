package org.bahmni.test.page;

import com.thoughtworks.gauge.datastore.DataStore;
import com.thoughtworks.gauge.datastore.DataStoreFactory;
import org.bahmni.test.page.program.domain.Program;
import org.bahmni.test.page.registration.domain.Patient;

public class BahmniPage {

	protected static String BASE_URL = "https://endtb.twhosted.com/bahmni";

	public static final String PATIENT_KEY = "patient";
	public static final String PROGRAM_KEY = "program";

	public void storePatientInSpecStore(Patient value) {
		DataStore specStore = DataStoreFactory.getSpecDataStore();
		specStore.put(PATIENT_KEY, value);
	}

	public Patient getPatientFromSpecStore(){
		DataStore specStore = DataStoreFactory.getSpecDataStore();
		return (Patient) specStore.get(PATIENT_KEY);
	}

	public void storeProgramInSpecStore(Program program){
		DataStore specStore = DataStoreFactory.getSpecDataStore();
		specStore.put(PROGRAM_KEY, program);
	}

	public Program getProgramFromSpecStore(){
		return (Program) DataStoreFactory.getSpecDataStore().get(PROGRAM_KEY);
	}
}
