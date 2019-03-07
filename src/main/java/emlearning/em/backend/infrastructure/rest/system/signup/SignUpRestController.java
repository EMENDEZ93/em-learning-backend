package emlearning.em.backend.infrastructure.rest.system.signup;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import emlearning.em.backend.application.system.signup.command.SignUpEventHandler;
import emlearning.em.backend.application.system.signup.command.model.SignUpCommand;
import emlearning.em.backend.domains.system.exception.SystemException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth/signup")
public class SignUpRestController {

	@Autowired
	private SignUpEventHandler signUpEventHandler;
	
	@PostMapping
	public void register(@Valid @RequestBody SignUpCommand signUpCommand) throws SystemException {
		signUpEventHandler.handle(signUpCommand);
	}
	
}
