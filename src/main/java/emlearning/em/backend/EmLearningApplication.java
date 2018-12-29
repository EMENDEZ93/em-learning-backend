package emlearning.em.backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import emlearning.em.backend.domain.service.english.reload.ReloadVerbInTableService;
import emlearning.em.backend.domain.service.english.setting.SettingEnglish;

@SpringBootApplication
public class EmLearningApplication implements CommandLineRunner {

	@Autowired
	private ReloadVerbInTableService reloadVerb;
	
	@Autowired
	private SettingEnglish settingEnglish;
	
	private static final Logger log = LoggerFactory.getLogger(EmLearningApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(EmLearningApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		reloadVerb.reloadAllVerb();
		log.info("*** reload all verb ***");
		
		settingEnglish.defaultTest();
		log.info("*** default setting english learned test ***");

	}
	
	
}
