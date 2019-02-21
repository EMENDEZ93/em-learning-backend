package emlearning.em.backend.domain.service.english.practice.present;

import emlearning.em.backend.persistence.entity.english.verb.ExampleVerbEntity;

public interface PresentExampleVerbPracticeService {

	public ExampleVerbEntity getRandomExampleVerb(String verb);

	public void getChangePresentExampleVerbLearned(String auxiliaryId);
	
}
