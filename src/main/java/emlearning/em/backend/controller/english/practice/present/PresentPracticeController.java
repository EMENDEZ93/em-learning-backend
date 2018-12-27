package emlearning.em.backend.controller.english.practice.present;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import emlearning.em.backend.domain.service.english.practice.present.PresentPracticeService;
import emlearning.em.backend.persistence.entity.english.verb.PresentEntity;

@CrossOrigin
@RestController
@RequestMapping("api/practice")
public class PresentPracticeController {

	@Autowired 
	private PresentPracticeService presentPracticeService;
	
	@GetMapping("/present") 
	public PresentEntity getRandomLearnVerb() {
		return presentPracticeService.getRandomLearnVerb(); 
	}	

	@GetMapping("/present/learned/{id}")
	public void getPresentLearned(@PathVariable("id") Long id) {
		presentPracticeService.getPresentLearned(id);
	}
	
}
