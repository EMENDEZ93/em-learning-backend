package emlearning.em.backend.controller.verb.present;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PresentVerb {

	@GetMapping("/present")
	public String getPresentVerb() {
		return "get present verb";
	}
	
}
