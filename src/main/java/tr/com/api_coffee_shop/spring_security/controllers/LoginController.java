package tr.com.api_coffee_shop.spring_security.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"*"}, maxAge = 3600)
@RestController
@RequestMapping("/api/secret")
public class LoginController {

	@GetMapping("/dashboard")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public boolean userAccess() {
		return true;
	}

}
