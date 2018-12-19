package emlearning.em.backend.controller.english.practice.past;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import emlearning.em.backend.domain.service.english.practice.past.PastPracticeService;

@RestController
@RequestMapping("api/practice")
public class PastPracticeController {

	@Autowired
	private PastPracticeService pastPracticeService;
	
	@GetMapping("/past") 
	public String getPresentPracite() {
		return pastPracticeService.getVerb();
	}
	
}
