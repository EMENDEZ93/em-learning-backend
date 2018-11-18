package emlearning.em.backend.controller.english.verb;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import emlearning.em.backend.domain.service.english.verb.ReloadVerbInTableService;

import java.io.IOException;

@RestController
public class ReloadVerbsInTablesController {

	@Autowired
	private ReloadVerbInTableService reloadVerb;

	@GetMapping("/present")
	public void getPresentVerb() throws IOException, InvalidFormatException {
		reloadVerb.reloadAllVerb();
	}

}
