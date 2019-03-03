package emlearning.em.backend.infrastructure.rest.system.signup;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import emlearning.em.backend.application.command.system.signup.model.SignUpCommand;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth/signup")
public class SignUpRestController {

	@PostMapping
	public void register(@Valid @RequestBody SignUpCommand signUpCommand) {
		
	}
	
}
