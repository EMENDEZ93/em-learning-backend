package emlearning.em.backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import emlearning.em.backend.domains.english.reload.service.ReloadVerbInTableService;
import emlearning.em.backend.domains.english.setting.service.SettingEnglish;
import emlearning.em.backend.domains.system.role.service.RoleService;

@SpringBootApplication
public class EmLearningApplication implements CommandLineRunner {

	@Autowired
	private ReloadVerbInTableService reloadVerb;
	
	@Autowired
	private SettingEnglish settingEnglish;
	
	@Autowired
	private RoleService roleService;
	
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

		reloadVerb.reloadAllExampleVerb();
		log.info("*** reload all example verb ***");
		
		log.info("*** reload all roles ***");		
		roleService.reloadAllRoles();
		
	}
	
	
}
