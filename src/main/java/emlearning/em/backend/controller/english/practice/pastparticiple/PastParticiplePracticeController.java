package emlearning.em.backend.controller.english.practice.pastparticiple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import emlearning.em.backend.domain.service.english.practice.pastparticiple.PastParticipleService;

@RestController
@RequestMapping("api/practice")
public class PastParticiplePracticeController {

	@Autowired
	private PastParticipleService pastParticipleService;

	@GetMapping("/past/participle")
	public String getPresentPracite() {
		return pastParticipleService.getVerb();
	}

}
