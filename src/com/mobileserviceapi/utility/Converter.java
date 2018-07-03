package com.mobileserviceapi.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.codec.binary.Base64;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobileserviceapi.model.Mobile;
import com.mobileserviceapi.model.MobileImpl;
import com.mobileserviceapi.model.Person;
import com.mobileserviceapi.model.PersonImpl;

@Service
public class Converter {
	
	public Converter() {
	}

	public Mobile jsonToMobile(String jsonS) throws JsonParseException, JsonMappingException, IOException, JSONException {
		JSONObject jsonObject = new JSONObject(jsonS);
		Mobile mobile = new MobileImpl();
		System.out.println(jsonObject.toString());
		if(!jsonObject.isNull("mobileFreedescription")) {
			mobile.setMobileFreedescription(jsonObject.getString("mobileFreedescription").toString());
		} 
		if(!jsonObject.isNull("mobileManufacturer")) {
			mobile.setMobileManufacturer(jsonObject.getString("mobileManufacturer"));
		}
		if(!jsonObject.isNull("mobileModel")) {
			mobile.setMobileModel(jsonObject.getString("mobileModel"));
		}
		if(!jsonObject.isNull("mobileSpecs")) {
			mobile.setMobileSpecs(jsonObject.getString("mobileSpecs"));
		}
		if(!jsonObject.isNull("price")) {
			mobile.setPrice(jsonObject.getDouble("price"));
		}
		mobile.setPersonId(jsonObject.getInt("personId"));
		mobile.setRowId(jsonObject.getInt("rowId"));
		return mobile;
	}
	
	
	public ArrayList<Mobile> jsonToMobiles(String jsonS) throws JsonParseException, JsonMappingException, IOException, JSONException {
		ArrayList<Mobile> mobiles = new ArrayList<Mobile> ();
		JSONArray jsonArray = new JSONArray(jsonS);
		JSONObject jsonObject = new JSONObject();
		for (int i=0; i<jsonArray.length(); i++) {
			jsonObject = jsonArray.getJSONObject(i);
			Mobile mobile = new MobileImpl();
			if(!jsonObject.isNull("mobileFreedescription")) {
				mobile.setMobileFreedescription(jsonObject.getString("mobileFreedescription").toString());
			} 
			if(!jsonObject.isNull("mobileManufacturer")) {
				mobile.setMobileManufacturer(jsonObject.getString("mobileManufacturer"));
			}
			if(!jsonObject.isNull("mobileModel")) {
				mobile.setMobileModel(jsonObject.getString("mobileModel"));
			}
			if(!jsonObject.isNull("mobileSpecs")) {
				mobile.setMobileSpecs(jsonObject.getString("mobileSpecs"));
			}
			if(!jsonObject.isNull("price")) {
				mobile.setPrice(jsonObject.getDouble("price"));
			}
			mobile.setPersonId(jsonObject.getInt("personId"));
			mobile.setRowId(jsonObject.getInt("rowId"));

			mobiles.add(mobile);
		}
		return mobiles;
	}
	
	public String mobileToJSONString(Mobile mobile) {
		ObjectMapper mapper = new ObjectMapper();
		String json = null;
		try {
			json = mapper.writeValueAsString(mobile);
			System.out.println(json);
		} catch (JsonMappingException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		}
		return json;
	}

	public ArrayList<Person> jsonToPersons(String jsonS) throws JsonParseException, JsonMappingException, IOException, JSONException {
		ArrayList<Person> persons = new ArrayList<Person>();
		JSONArray jsonArray = new JSONArray(jsonS);
		JSONObject jsonObject = new JSONObject();
		for (int i=0; i<jsonArray.length(); i++) {
			jsonObject = jsonArray.getJSONObject(i);
			Person person = new PersonImpl();
			if(!jsonObject.isNull("id")) {
				person.setId(jsonObject.getInt("id"));
			} 
			if(!jsonObject.isNull("username")) {
				person.setUsername(jsonObject.getString("username"));
			}
			if(!jsonObject.isNull("password_encrypted")) {
				person.setPassword(jsonObject.getString("password_encrypted"));
			}
			if(!jsonObject.isNull("enabled")) {
				person.setEnabled(jsonObject.getInt("enabled"));
			}
			if(!jsonObject.isNull("email")) {
				person.setAge(jsonObject.getInt("age"));
			}
			if(!jsonObject.isNull("firstname")) {
				person.setFirstname(jsonObject.getString("firstname"));
			}
			if(!jsonObject.isNull("lastname")) {
				person.setLastname(jsonObject.getString("lastname"));
			}

			persons.add(person);
		}
		return persons;
	}
	
	public Person jsonToPerson(String jsonS) throws JsonParseException, JsonMappingException, IOException, JSONException {
		Person person = new PersonImpl();
		JSONObject jsonObject = new JSONObject(jsonS);
			if(!jsonObject.isNull("id")) {
				person.setId(jsonObject.getInt("id"));
			} 
			if(!jsonObject.isNull("username")) {
				person.setUsername(jsonObject.getString("username"));
			}
			if(!jsonObject.isNull("password_encrypted")) {
				person.setPassword(jsonObject.getString("password_encrypted"));
			}
			if(!jsonObject.isNull("enabled")) {
				person.setEnabled(jsonObject.getInt("enabled"));
			}
			if(!jsonObject.isNull("email")) {
				person.setAge(jsonObject.getInt("age"));
			}
			if(!jsonObject.isNull("firstname")) {
				person.setFirstname(jsonObject.getString("firstname"));
			}
			if(!jsonObject.isNull("lastname")) {
				person.setLastname(jsonObject.getString("lastname"));
			}
		return person;
	}
	
	public String personToJSONString(Person person) {
		ObjectMapper mapper = new ObjectMapper();
		String json = null;
		try {
			json = mapper.writeValueAsString(person);
			System.out.println(json);
		} catch (JsonMappingException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		}
		return json;
	}
	
	public static File fileConvert(MultipartFile file) throws IOException
	{    
	    File convFile = new File(file.getOriginalFilename());
	    convFile.createNewFile(); 
	    FileOutputStream fos = new FileOutputStream(convFile); 
	    fos.write(file.getBytes());
	    fos.close(); 
	    return convFile;
	}
    
    public static String multipartFileToString(MultipartFile file) throws FileNotFoundException, IOException {
    	FileInputStream imageInFile = new FileInputStream(Converter.fileConvert(file));
        byte imageData[] = new byte[(int) Converter.fileConvert(file).length()];
        imageInFile.read(imageData);
		return Base64.encodeBase64URLSafeString(imageData);
    }

}
