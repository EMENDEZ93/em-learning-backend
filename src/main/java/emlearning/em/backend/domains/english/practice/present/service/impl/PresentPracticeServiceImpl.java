package emlearning.em.backend.domains.english.practice.present.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emlearning.em.backend.domains.english.practice.present.entity.PresentEntity;
import emlearning.em.backend.domains.english.practice.present.repository.PresentJpaRepository;
import emlearning.em.backend.domains.english.practice.present.service.PresentPracticeService;

@Service
public class PresentPracticeServiceImpl implements PresentPracticeService {

	@Autowired 
	PresentJpaRepository presentJpaRepository;
	
	@Override
	public PresentEntity getRandomLearnVerb() {
		return presentJpaRepository.getRandomLearnVerb();
	}

	@Override
	public void getChangePresentLearned(Long id) {
		presentJpaRepository.getPresentLearned(id);
	}

}
