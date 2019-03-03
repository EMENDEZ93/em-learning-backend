package emlearning.em.backend.domain.service.english.setting.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emlearning.em.backend.domain.service.english.setting.SettingEnglish;
import emlearning.em.backend.persistence.entity.english.setting.SettingEnglishEntity;
import emlearning.em.backend.persistence.repository.english.setting.SettingEnglishJpaRepository;

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
