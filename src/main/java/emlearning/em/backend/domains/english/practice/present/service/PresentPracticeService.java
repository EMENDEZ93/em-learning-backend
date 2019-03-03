package emlearning.em.backend.domains.english.practice.present.service;

import emlearning.em.backend.domains.english.practice.present.entity.PresentEntity;

public interface PresentPracticeService {

	public PresentEntity getRandomLearnVerb();
	
	public void getChangePresentLearned(Long id);
	
}
