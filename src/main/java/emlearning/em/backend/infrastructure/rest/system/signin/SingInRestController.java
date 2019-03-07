package emlearning.em.backend.infrastructure.rest.system.signin;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import emlearning.em.backend.application.system.signin.command.model.LoginCommand;
import emlearning.em.backend.domains.system.user.service.impl.UserServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth/signin")
public class SingInRestController {

	@Autowired
	UserServiceImpl	userServiceImpl;
	
	@PostMapping
	public ResponseEntity<?> authenticate(@Valid @RequestBody LoginCommand loginCommand){
		return userServiceImpl.authenticate(loginCommand);
	}

}
