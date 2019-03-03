package emlearning.em.backend.domains.english.setting.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emlearning.em.backend.domains.english.setting.entity.SettingEnglishEntity;
import emlearning.em.backend.domains.english.setting.repository.SettingEnglishJpaRepository;
import emlearning.em.backend.domains.english.setting.service.SettingEnglish;

@Service
public class SettingEnglishImpl implements SettingEnglish {

	@Autowired
	private SettingEnglishJpaRepository settingEnglishJpaRepository;
	
	@Override
	public void defaultTest() {
		SettingEnglishEntity setting = new SettingEnglishEntity();
		settingEnglishJpaRepository.save(setting);
	}

	@Override
	public int getRepeatToLearnedVerbNumber() {
		return settingEnglishJpaRepository.getRepeatToLearnedVerbNumber();
	}

	@Override
	public int getRepeatToLearnedPresentExampleVerbNumber() {
		return settingEnglishJpaRepository.getRepeatToLearnedPresentExampleVerbNumber();
	}

}
