package emlearning.em.backend.domains.english.practice.present.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emlearning.em.backend.application.english.practice.present.command.model.PresentReviewCommand;
import emlearning.em.backend.domains.english.practice.present.entity.PresentReviewEntity;
import emlearning.em.backend.domains.english.practice.present.repository.PresentReviewJpaRepository;

@Service
public class PresentReviewService {

	@Autowired
	private PresentReviewJpaRepository presentReviewJpaRepository;
	
	public void changeReviewPresentLearnedHandler(PresentReviewCommand command){
		
		PresentReviewEntity review = new PresentReviewEntity();
		review.setVerbId(command.getVerbId());
		review.setVerb(command.getVerb());
		review.setUsername(command.getUsername());
		
		presentReviewJpaRepository.save(review);
		
	}
	
}
