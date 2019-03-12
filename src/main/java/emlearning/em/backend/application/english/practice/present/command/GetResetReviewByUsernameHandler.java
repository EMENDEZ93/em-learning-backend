package emlearning.em.backend.application.english.practice.present.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import emlearning.em.backend.domains.english.practice.present.service.PresentReviewService;
import emlearning.em.backend.domains.system.exception.SystemException;

@Component
public class GetResetReviewByUsernameHandler {

	@Autowired
	private PresentReviewService presentReviewService;

	public void handle(String username) throws SystemException {
		presentReviewService.resetReviewByUsername(username);
		commandHandler(username);		
	}

	public void commandHandler(String username) {
		System.out.println("commandHandler -> GetResetReviewByUsernameHandler");
	}

	
	
}
