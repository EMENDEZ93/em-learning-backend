package emlearning.em.backend.domain.service.english.practice.present.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emlearning.em.backend.domain.service.english.practice.present.PresentPracticeService;
import emlearning.em.backend.persistence.entity.english.verb.PresentEntity;
import emlearning.em.backend.persistence.repository.english.verb.PresentJpaRepository;

@Service
public class PresentPracticeServiceImpl implements PresentPracticeService {

	@Autowired 
	PresentJpaRepository presentJpaRepository;
	
	@Override
	public PresentEntity getRandomLearnVerb() {
		return presentJpaRepository.getRandomLearnVerb();
	}

}
