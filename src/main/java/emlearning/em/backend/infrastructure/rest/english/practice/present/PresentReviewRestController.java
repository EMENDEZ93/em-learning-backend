package emlearning.em.backend.infrastructure.rest.english.practice.present;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import emlearning.em.backend.application.english.practice.present.query.GetRandomReviewVerbHandler;
import emlearning.em.backend.application.english.practice.present.query.model.PresentReviewQuery;

@CrossOrigin
@RestController
@RequestMapping("api/practice/review")
public class PresentReviewRestController {

	@Autowired
	private GetRandomReviewVerbHandler getRandomReviewVerbHandler;

	@GetMapping("/present/{username}")
	public PresentReviewQuery getRandomLearnVerb(@PathVariable("username") String username) {
		return getRandomReviewVerbHandler.handle(username);
	}

}
