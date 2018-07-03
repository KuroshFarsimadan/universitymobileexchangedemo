

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mobileserviceapi.connection.MobileServiceConnection;
import com.mobileserviceapi.connection.PersonServiceConnection;
import com.mobileserviceapi.model.Mobile;
import com.mobileserviceapi.model.MobileImpl;
import com.mobileserviceapi.model.Person;
import com.project.authorizationservice.AuthorizationService;

@Controller
@RequestMapping(value = "/secureController")
public class SecureController {
	
	@Inject
	private AuthorizationService authorizationService;
	
	public AuthorizationService getMiscService() {
		return authorizationService;
	}

	public void setMiscService(AuthorizationService authorizationService) {
		this.authorizationService = authorizationService;
	}
	
	@Inject
	private PersonServiceConnection personService;
	
	public PersonServiceConnection getPersonServiceConnection() {
		return this.personService;
	}

	public void setPersonServiceConnection(PersonServiceConnection personService) {
		this.personService = personService;
	}	
	
	@Inject
	private MobileServiceConnection mobileService;
	
	public MobileServiceConnection getMobileServiceConnection() {
		return this.mobileService;
	}

	public void setMobileServiceConnection(MobileServiceConnection mobileService) {
		this.mobileService = mobileService;
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("mobile", new MobileImpl());
		authorizationService.serviceForSignedIn();
		return "redirect:/index";
	}
	
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String about(Model model) {
		model.addAttribute("mobile", new MobileImpl());
		authorizationService.serviceForSignedIn();
		return "redirect:/about";
	}
	
	/******************************************************************************************/
	/** GENERAL PERSON & AUTHORIZATION service Create (POST), Read (GET), Update (PUT), Delete (Delete) FUNCTIONALITY   */
	/******************************************************************************************/

	@RequestMapping(value = "/secureAll", method = RequestMethod.GET)
	public String secureAll(Model model) {
		authorizationService.serviceForSignedIn();
		return "Secure/secureAll";
	} 
	
	@RequestMapping(value = "/userPanel", method = RequestMethod.GET)
	public String userPanel(Model model) {
		authorizationService.serviceForSignedIn();
		return "Secure/userPanel";
	}
	
	@RequestMapping(value = "/userProfile", method = RequestMethod.GET)
	public String userProfile(Model model, Principal principal) throws JSONException {
		authorizationService.serviceForSignedIn();
		Person person = personService.serviceGETPerson("/personByFirstName", principal.getName());
		model.addAttribute("person", person);
		return "Secure/userProfile";
	}
		
	/******************************************************************************************/
	/** GENERAL MOBILE service Create (POST), Read (GET), Update (PUT), Delete (Delete) FUNCTIONALITY*/
	/******************************************************************************************/
	
	@RequestMapping(value = "/updateMobiles", method = RequestMethod.POST)
	public String updateMobile(Model model, @ModelAttribute(value="mobile") @Valid MobileImpl mobile, BindingResult result, Principal principal,@RequestParam(value = "submitButtons") String updateOrDelete) throws JSONException {
		authorizationService.serviceForSignedIn();
		model.addAttribute("mobile", new MobileImpl());
		model.addAttribute("mobile", mobile);
		if(updateOrDelete.equalsIgnoreCase("Update")) {
			mobileService.servicePUTMobile("/mobile", mobile);
		} else {
			System.out.println("public String updateMobile POST "+ mobile.toString());
			mobileService.serviceDELETEMobile("/mobile", mobile);
		}
		return "redirect:/secureController/getAllMobile";
	}
	
	@RequestMapping(value = "/createMobile", method = RequestMethod.GET)
	public String createMobile(Model model) {
		model.addAttribute("mobile", new MobileImpl());
		authorizationService.serviceForSignedIn();
		return "Secure/createMobile";
	}
	
	@RequestMapping(value = "/createMobile", method = RequestMethod.POST)
	public String createMobile(Model model, @ModelAttribute(value="mobile")
	MobileImpl mobile, @RequestParam(value = "file", required = false) MultipartFile file, 
	BindingResult result, Principal principal) throws JSONException, IOException { 
		authorizationService.serviceForSignedIn();
		Person person = personService.serviceGETPerson("/personByFirstName", principal.getName());
		String returnVal = "Secure/userPanel";
	    if(result.hasErrors()) {
	    	returnVal = "Secure/createMobile";
	    } else {
	    	mobile.setPersonId(person.getId());
	    	mobileService.servicePOSTMobile("/mobile", mobile);
		    model.addAttribute("mobile", mobile);
	    }      
		return returnVal;
	}
	
	@RequestMapping(value="/getAllMobile", method=RequestMethod.GET)
	public String getAllMobile(Model model) throws JSONException {
		authorizationService.serviceForSignedIn();
		ArrayList<Mobile> mobiles = mobileService.serviceGETMobiles("/mobile"); 
		model.addAttribute("mobileList", mobiles);
		return "Secure/getAllMobile" ;
	}
	
	@RequestMapping(value = "/getPersonMobile", method = RequestMethod.GET)
	public String getPersonMobile(Model model, Principal principal) throws JSONException {
		authorizationService.serviceForSignedIn();
	    List<Mobile> mobiles = mobileService.serviceGETPersonMobiles("/personMobile/", principal.getName());
		model.addAttribute("mobileList", mobiles);
		model.addAttribute("mobile", new MobileImpl());
		return "Secure/getOwnMobile";
	}
	
}
