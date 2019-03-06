package emlearning.em.backend.application.system.signup.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import emlearning.em.backend.application.CommandHandler;
import emlearning.em.backend.application.system.signup.command.model.SignUpCommand;
import emlearning.em.backend.domains.system.exception.SystemException;
import emlearning.em.backend.domains.system.user.service.UserService;

@Component
public class SignUpEventHandler implements CommandHandler<SignUpCommand> {

	@Autowired
	private UserService userService;	
	
	@Override
	public void handle(SignUpCommand command) throws SystemException {
		this.userService.register(command);
	}

	@Override
	public void commandHandler(SignUpCommand command) {
		
	}

}
