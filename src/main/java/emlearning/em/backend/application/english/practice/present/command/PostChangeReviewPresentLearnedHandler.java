package emlearning.em.backend.application.english.practice.present.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import emlearning.em.backend.application.CommandHandler;
import emlearning.em.backend.application.english.practice.present.command.model.PresentReviewCommand;
import emlearning.em.backend.domains.english.practice.present.service.PresentReviewService;
import emlearning.em.backend.domains.system.exception.SystemException;

@Component
public class PostChangeReviewPresentLearnedHandler implements CommandHandler<PresentReviewCommand> {

	@Autowired
	private PresentReviewService presentReviewService;
	
	@Override
	public void handle(PresentReviewCommand command) throws SystemException {
		presentReviewService.changeReviewPresentLearnedHandler(command);
	
		commandHandler(command);
	}

	@Override
	public void commandHandler(PresentReviewCommand command) {
		System.out.println("commandHandler");
	}

}
