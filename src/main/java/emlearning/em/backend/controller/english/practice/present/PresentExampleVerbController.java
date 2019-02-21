package emlearning.em.backend.controller.english.practice.present;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import emlearning.em.backend.domain.service.english.practice.present.PresentExampleVerbPracticeService;
import emlearning.em.backend.persistence.entity.english.verb.ExampleVerbEntity;

@CrossOrigin
@RestController
@RequestMapping("api/practice/present/example/verb")
public class PresentExampleVerbController {

	@Autowired
	PresentExampleVerbPracticeService presentExampleVerbPracticeService;
	
	@GetMapping("/{verb}")
	public ExampleVerbEntity getRandomExampleVerb(@PathVariable(value="verb") String verb) {
		return presentExampleVerbPracticeService.getRandomExampleVerb(verb);
	} 

	@GetMapping("/learned/{auxiliaryId}")
	public void getChangePresentExampleVerbLearned(@PathVariable("auxiliaryId") String auxiliaryId) {
		presentExampleVerbPracticeService.getChangePresentExampleVerbLearned(auxiliaryId);
	}
	
}
