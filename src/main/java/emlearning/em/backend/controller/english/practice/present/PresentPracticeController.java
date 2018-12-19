package emlearning.em.backend.controller.english.practice.present;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import emlearning.em.backend.domain.service.english.practice.present.PresentPracticeService;

@RestController
@RequestMapping("api/practice")
public class PresentPracticeController {

	@Autowired PresentPracticeService presentPracticeService;
	
	@GetMapping("/") 
	public String getPresentPracite() {
		return presentPracticeService.getPresent(); 
	}
	
}
