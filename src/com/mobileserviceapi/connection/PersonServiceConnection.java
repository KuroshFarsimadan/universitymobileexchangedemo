package com.mobileserviceapi.connection;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.mobileserviceapi.model.Person;
import com.mobileserviceapi.model.PersonImpl;
import com.mobileserviceapi.utility.Converter;

@Service
public class PersonServiceConnection {
	
	private final String serviceUrl = "http://localhost:9995/PersonService";
	private RestTemplate template = new RestTemplate();
	private Converter conv = new Converter();
	
	public PersonServiceConnection() {

	}
	
	public ArrayList<Person> serviceGETPersons(String serviceUrl, Person person) throws JSONException {
		String personJson = template.getForObject(this.serviceUrl + serviceUrl, String.class ).toString();
		System.out.println(person.toString());
		ArrayList<Person> persons = new ArrayList<Person>();
		try {
			persons.addAll(conv.jsonToPersons(personJson));
			System.out.println(persons.toString());
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return persons;
	}
	
	public Person serviceGETPerson(String serviceUrl, String personUsername) throws JSONException {
		String personJson = template.getForObject(this.serviceUrl + serviceUrl + "/" + personUsername, String.class ).toString();
		Person person = new PersonImpl();
		try {
			person = conv.jsonToPerson(personJson);
			System.out.println(person.toString());
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return person;
	}

	public void servicePOSTPerson(String serviceUrl, Person person) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> httpEntity = new HttpEntity<String>(conv.personToJSONString(person), headers);
		template.exchange(this.serviceUrl + serviceUrl, HttpMethod.POST, httpEntity, String.class);
	}
	
}
