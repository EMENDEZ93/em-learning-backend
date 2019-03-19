package emlearning.em.backend.application.english.practice.past.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import emlearning.em.backend.application.CommandHandler;
import emlearning.em.backend.application.english.practice.past.command.model.PastCommand;
import emlearning.em.backend.domains.english.practice.past.service.impl.PastPracticeServiceImpl;
import emlearning.em.backend.domains.system.exception.SystemException;

@Component
public class PostChangePastLearnedHandler implements CommandHandler<PastCommand> {

	@Autowired
	private PastPracticeServiceImpl pastPracticeService;
	
	@Override
	public void handle(PastCommand command) throws SystemException {
		pastPracticeService.changePastLearned(command);
	}

	@Override
	public void commandHandler(PastCommand command) {		
	}

}
