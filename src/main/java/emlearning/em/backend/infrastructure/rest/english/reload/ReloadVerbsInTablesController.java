package emlearning.em.backend.infrastructure.rest.english.reload;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import emlearning.em.backend.domains.english.reload.service.ReloadVerbInTableService;

import java.io.IOException;

@RestController
@RequestMapping("api/reload/")
public class ReloadVerbsInTablesController {

	@Autowired
	private ReloadVerbInTableService reloadVerb;

	@GetMapping("/index")
	public String index() {
		return "em-learning";
	}	
	
	@GetMapping("/all/verb")
	public void reloadAllVerb() throws IOException, InvalidFormatException {
		reloadVerb.reloadAllVerb();
	}

}
