package emlearning.em.backend.infrastructure.rest.english.practice.present.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import emlearning.em.backend.application.english.practice.present.command.GetResetReviewByUsernameHandler;
import emlearning.em.backend.domains.system.exception.SystemException;

@CrossOrigin
@RestController
@RequestMapping("api/practice/review")
public class GetResetReviewByUsernameRestController {

	@Autowired
	GetResetReviewByUsernameHandler getResetReviewByUsername;
	
	@GetMapping("/present/reset/{username}")
	public void getRandomExampleVerb(@PathVariable(value="username") String username) throws SystemException {
		getResetReviewByUsername.handle(username);
	} 
	
}
