package com.mobileserviceapi.connection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.json.JSONException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.mobileserviceapi.model.Mobile;
import com.mobileserviceapi.model.MobileImpl;
import com.mobileserviceapi.model.Person;
import com.mobileserviceapi.utility.Converter;

@Service
public class MobileServiceConnection {
	
	public final String serviceUrl = "http://localhost:9998/MobileService";
	private RestTemplate template = new RestTemplate();
	private Converter conv = new Converter();
	
	@Inject
	private PersonServiceConnection personService;
	
	public PersonServiceConnection getPersonServiceConnection() {
		return this.personService;
	}

	public void setPersonServiceConnection(PersonServiceConnection personService) {
		this.personService = personService;
	}	
	
	public MobileServiceConnection() {

	}
	
	public ArrayList<Mobile> serviceGETMobiles(String serviceUrl) throws JSONException {
		String mobileJson = template.getForObject(this.serviceUrl + serviceUrl, String.class );
		ArrayList<Mobile> mobiles = new ArrayList<Mobile>();
		try {
			mobiles.addAll(conv.jsonToMobiles(mobileJson));
			System.out.println(mobiles.toString());
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mobiles;
	}
	
	public Mobile serviceGETMobileRow(String serviceUrl, int id) throws JSONException {
		String mobileJson = template.getForObject(this.serviceUrl + serviceUrl + "/" + id, String.class );
		Mobile mobile = new MobileImpl();
		try {
			mobile = conv.jsonToMobile(mobileJson);
			System.out.println(mobile.toString());
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mobile;
	}
	
	public ArrayList<Mobile> serviceGETPersonMobiles(String serviceUrl, String name) throws JSONException {
		Person person = personService.serviceGETPerson("/personByFirstName", name);
		String mobileJson = template.getForObject(this.serviceUrl + serviceUrl + "/" + person.getId(), String.class );
		ArrayList<Mobile> mobiles = new ArrayList<Mobile>();
		try {
			mobiles.addAll(conv.jsonToMobiles(mobileJson));
			System.out.println(mobiles.toString());
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mobiles;
	}

	public void servicePOSTMobile(String serviceUrl, Mobile mobile) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> httpEntity = new HttpEntity<String>(conv.mobileToJSONString(mobile), headers);
		template.exchange(this.serviceUrl + serviceUrl, HttpMethod.POST, httpEntity, String.class);
	}
	
	public void servicePOSTMobileWithPicture(String serviceUrl, Mobile mobile, MultipartFile file, String name) throws FileNotFoundException, IOException, JSONException {
		Person person = personService.serviceGETPerson("/personByFirstName", name);
		mobile.setPersonId(person.getId());
		mobile.setPhoto(Converter.multipartFileToString(file));
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> httpEntity = new HttpEntity<String>(conv.mobileToJSONString(mobile), headers);
		template.exchange(this.serviceUrl + serviceUrl, HttpMethod.POST, httpEntity, String.class);
	}
	
	// From SecureController is /mobile, mobile
	public void servicePUTMobile(String serviceUrl, Mobile mobile) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> httpEntity = new HttpEntity<String>(conv.mobileToJSONString(mobile), headers);
		template.exchange(this.serviceUrl + serviceUrl, HttpMethod.PUT, httpEntity, String.class);
	}
	
	public void serviceDELETEMobile(String serviceUrl, Mobile mobile) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> httpEntity = new HttpEntity<String>(headers);
	    template.exchange(this.serviceUrl + serviceUrl + "/" + mobile.getRowId(),HttpMethod.DELETE, httpEntity, String.class);
	}
	
}
