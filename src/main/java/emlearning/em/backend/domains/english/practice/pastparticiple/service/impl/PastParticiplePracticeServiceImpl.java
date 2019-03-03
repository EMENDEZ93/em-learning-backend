package emlearning.em.backend.domain.service.english.practice.pastparticiple.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emlearning.em.backend.domain.service.english.practice.pastparticiple.PastParticipleService;
import emlearning.em.backend.persistence.repository.english.verb.PastParticipleJpaRepository;

@Service
public class PastParticiplePracticeServiceImpl implements PastParticipleService {

	@Autowired
	private PastParticipleJpaRepository pastParticipleJpaRepository;
	
	@Override
	public String getVerb() {
		Long a = (long) 1;
		return pastParticipleJpaRepository.getOne(a).getVerb();
	}

}
