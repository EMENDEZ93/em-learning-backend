package emlearning.em.backend.domain.service.english.practice.present.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emlearning.em.backend.domain.service.english.practice.present.PresentExampleVerbPracticeService;
import emlearning.em.backend.persistence.entity.english.verb.ExampleVerbEntity;
import emlearning.em.backend.persistence.repository.english.verb.ExampleVerbJpaRepository;

@Service
public class PresentExampleVerbPracticeServiceImpl implements PresentExampleVerbPracticeService {

	@Autowired
	ExampleVerbJpaRepository exampleVerbJpaRepository;
	
	@Override
	public ExampleVerbEntity getRandomExampleVerb(String verb) {
		return exampleVerbJpaRepository.getRandomExampleVerb(verb);
	}

}
