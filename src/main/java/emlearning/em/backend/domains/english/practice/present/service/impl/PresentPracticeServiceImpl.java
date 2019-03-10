package emlearning.em.backend.domains.english.practice.present.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emlearning.em.backend.application.english.practice.present.query.model.PresentReviewQuery;
import emlearning.em.backend.domains.english.practice.present.entity.PresentEntity;
import emlearning.em.backend.domains.english.practice.present.repository.PresentJpaRepository;
import emlearning.em.backend.domains.english.practice.present.service.PresentPracticeService;

@Service
public class PresentPracticeServiceImpl implements PresentPracticeService {

	@Autowired 
	PresentJpaRepository presentJpaRepository;
	
	@Override
	public PresentEntity getRandomLearnVerb(String username) {
		return presentJpaRepository.getRandomLearnVerb(username);
	}

	@Override
	public void getChangePresentLearned(Long id) {
		presentJpaRepository.getPresentLearned(id);
	}

	@Override
	public PresentReviewQuery getRandomReviewVerb(String username) {
		
		PresentEntity verb = presentJpaRepository.getRandomReviewVerb(username);
		
		return new PresentReviewQuery(verb.getId(), verb.getVerb());
	}

}
