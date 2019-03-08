package emlearning.em.backend.infrastructure.rest.english.practice.present;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import emlearning.em.backend.domains.english.practice.present.entity.PresentEntity;
import emlearning.em.backend.domains.english.practice.present.service.PresentPracticeService;

@CrossOrigin
@RestController
@RequestMapping("api/practice")
public class PresentPracticeController {

	@Autowired 
	private PresentPracticeService presentPracticeService;
	
	@GetMapping("/present/{username}") 
	public PresentEntity getRandomLearnVerb(@PathVariable("username") String username) {
		return presentPracticeService.getRandomLearnVerb(username); 
	}	

	@GetMapping("/present/learned/{id}")
	public void getChangePresentLearned(@PathVariable("id") Long id) {
		presentPracticeService.getChangePresentLearned(id);
	}
	
}
