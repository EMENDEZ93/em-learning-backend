package emlearning.em.backend.application.english.practice.present.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import emlearning.em.backend.application.english.practice.present.query.model.PresentReviewQuery;
import emlearning.em.backend.domains.english.practice.present.service.PresentPracticeService;

@Component
public class GetRandomReviewVerbHandler {

	@Autowired
	private PresentPracticeService presentPracticeService;

	public PresentReviewQuery handle(String username) {
		return presentPracticeService.getRandomReviewVerb(username);
	}


	
}
