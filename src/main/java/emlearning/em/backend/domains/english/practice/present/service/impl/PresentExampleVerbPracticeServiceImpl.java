package emlearning.em.backend.domains.english.practice.present.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emlearning.em.backend.domains.english.practice.example.entity.ExampleVerbEntity;
import emlearning.em.backend.domains.english.practice.example.entity.repository.ExampleVerbJpaRepository;
import emlearning.em.backend.domains.english.practice.present.service.PresentExampleVerbPracticeService;

@Service
public class PresentExampleVerbPracticeServiceImpl implements PresentExampleVerbPracticeService {

	@Autowired
	ExampleVerbJpaRepository exampleVerbJpaRepository;
	
	@Override
	public ExampleVerbEntity getRandomExampleVerb(String verb) {
		return exampleVerbJpaRepository.getRandomExampleVerb(verb);
	}

	@Override
	public void getChangePresentExampleVerbLearned(String auxiliaryId) {
		exampleVerbJpaRepository.getChangePresentExampleVerbLearned(auxiliaryId);
	}

}
