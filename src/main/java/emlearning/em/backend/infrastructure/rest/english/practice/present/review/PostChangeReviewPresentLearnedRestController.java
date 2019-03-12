package emlearning.em.backend.infrastructure.rest.english.practice.present.review;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import emlearning.em.backend.application.english.practice.present.command.PostChangeReviewPresentLearnedHandler;
import emlearning.em.backend.application.english.practice.present.command.model.PresentReviewCommand;
import emlearning.em.backend.domains.system.exception.SystemException;

@CrossOrigin
@RestController
@RequestMapping("api/practice/review")
public class PostChangeReviewPresentLearnedRestController {

	@Autowired
	private PostChangeReviewPresentLearnedHandler postChangeReviewPresentLearnedHandler;
	
	@PostMapping("/present/learned")
	public void getChangePresentLearned(@Valid @RequestBody PresentReviewCommand command) throws SystemException {
		postChangeReviewPresentLearnedHandler.handle(command);
	}

}
