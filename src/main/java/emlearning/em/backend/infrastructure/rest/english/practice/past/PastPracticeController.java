package emlearning.em.backend.infrastructure.rest.english.practice.past;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import emlearning.em.backend.domains.english.practice.past.entity.PastEntity;
import emlearning.em.backend.domains.english.practice.past.service.PastPracticeService;

@CrossOrigin
@RestController
@RequestMapping("api/past/")
public class PastPracticeController {

	@Autowired
	private PastPracticeService pastPracticeService;
	
	@GetMapping("/{username}") 
	public PastEntity getRandomLearnVerb (@PathVariable("username") String username) {
		return pastPracticeService.getRandomLearnVerb(username);
	}
	
}
