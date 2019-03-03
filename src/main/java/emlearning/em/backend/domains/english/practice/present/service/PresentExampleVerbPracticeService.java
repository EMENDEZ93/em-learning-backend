package emlearning.em.backend.domains.english.practice.present.service;

import emlearning.em.backend.domains.english.practice.example.entity.ExampleVerbEntity;

public interface PresentExampleVerbPracticeService {

	public ExampleVerbEntity getRandomExampleVerb(String verb);

	public void getChangePresentExampleVerbLearned(String auxiliaryId);
	
}
