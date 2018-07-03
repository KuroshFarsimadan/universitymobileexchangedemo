package com.project.authorizationservice;

import org.springframework.stereotype.Service;

@Service
public class AuthorizationServiceImpl implements AuthorizationService {

	public void serviceForAdmins() {
		System.out.println("misc for admins");
	}

	public void serviceForSignedIn() {
		System.out.println("misc for signed in users");
	}

	public void serviceForAll() {
		System.out.println("misc for all");
	}

}
