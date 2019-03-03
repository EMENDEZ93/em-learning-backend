package emlearning.em.backend.domains.system.user.service;

import emlearning.em.backend.application.command.system.signup.model.SignUpCommand;
import emlearning.em.backend.domains.system.exception.SystemException;

public interface UserService {

	public void register(SignUpCommand signUpCommand) throws SystemException;
	
}
