package emlearning.em.backend.domain.service.english.practice.present;

import emlearning.em.backend.persistence.entity.english.verb.PresentEntity;

public interface PresentPracticeService {

	public PresentEntity getRandomLearnVerb();
	
	public void getChangePresentLearned(Long id);
	
}
