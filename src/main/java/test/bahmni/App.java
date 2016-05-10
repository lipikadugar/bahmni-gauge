package test.bahmni;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) throws IOException, InterruptedException
    {	
    	
    	InputStream fis = new FileInputStream("..//bahmni//PatientProfile.json");
		JsonReader jsonReader = Json.createReader(fis);
		// get JsonObject from JsonReader
		JsonObject jsonObject = jsonReader.readObject();
		JsonArray jsonArray = jsonObject.getJsonArray("patients");

		jsonReader.close();
		fis.close();
		
		JsonValue val = jsonArray;	
		jsonObject = (JsonObject) jsonArray;
		//Sys
		
    }
}
