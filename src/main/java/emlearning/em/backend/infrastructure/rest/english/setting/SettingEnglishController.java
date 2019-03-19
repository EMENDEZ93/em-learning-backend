package emlearning.em.backend.infrastructure.rest.english.setting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import emlearning.em.backend.domains.english.setting.service.SettingEnglish;

@CrossOrigin
@RestController
@RequestMapping("api/english/setting/")
public class SettingEnglishController {
	
	@Autowired
	private SettingEnglish settingEnglish;
	
	@GetMapping("repeat/verb/learned")
	public int getRepeatToLearnedVerbNumber() {
		return settingEnglish.getRepeatToLearnedVerbNumber();
	}

	@GetMapping("repeat/present/example/verb/learned")
	public int getRepeatToLearnedPresentExampleVerbNumber() {
		return settingEnglish.getRepeatToLearnedPresentExampleVerbNumber();
	}	

	@GetMapping("repeat/review/present/verb/learned")
	public int getRepeatToReviewVerbNumber() {
		return settingEnglish.getRepeatToReviewVerbNumber();
	}	

	@GetMapping("repeat/past/verb/learned")
	public int getRepeatToPastVerbNumber() {
		return settingEnglish.getRepeatToPastVerbNumber();
	}
	
}
