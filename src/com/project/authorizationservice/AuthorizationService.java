package com.project.authorizationservice;

import org.springframework.security.access.prepost.PreAuthorize;

public interface AuthorizationService {

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public abstract void serviceForAdmins();

	@PreAuthorize("isAuthenticated()")
	public abstract void serviceForSignedIn();

	@PreAuthorize("permitAll")
	public abstract void serviceForAll();

}