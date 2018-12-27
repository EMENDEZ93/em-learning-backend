package emlearning.em.backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import emlearning.em.backend.domain.service.english.reload.ReloadVerbInTableService;

@SpringBootApplication
public class EmLearningApplication implements CommandLineRunner {

	@Autowired
	private ReloadVerbInTableService reloadVerb;
	
	private static final Logger log = LoggerFactory.getLogger(EmLearningApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(EmLearningApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		reloadVerb.reloadAllVerb();
		log.info("*** reload all verb ***");
	}
}
