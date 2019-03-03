package emlearning.em.backend.infrastructure.rest.system.signup;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import emlearning.em.backend.application.command.system.signup.model.SignUpCommand;
import emlearning.em.backend.domains.system.exception.SystemException;
import emlearning.em.backend.domains.system.user.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth/signup")
public class SignUpRestController {

	@Autowired
	private UserService userService;
	
	@PostMapping
	public void register(@Valid @RequestBody SignUpCommand signUpCommand) throws SystemException {
		this.userService.register(signUpCommand);
	}
	
}
