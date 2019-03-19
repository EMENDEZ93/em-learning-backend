package emlearning.em.backend.infrastructure.rest.english.practice.past;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import emlearning.em.backend.application.english.practice.past.command.PostChangePastLearnedHandler;
import emlearning.em.backend.application.english.practice.past.command.model.PastCommand;
import emlearning.em.backend.domains.system.exception.SystemException;

@CrossOrigin
@RestController
@RequestMapping("api/past/learned")
public class PostChangePastVerbLearnedRestController {

	@Autowired
	private PostChangePastLearnedHandler postChangePAstLearnedHandler;
	
	@PostMapping
	public void getChangePastLearned(@Valid @RequestBody PastCommand command) throws SystemException {
		postChangePAstLearnedHandler.handle(command);
	}
	
}
