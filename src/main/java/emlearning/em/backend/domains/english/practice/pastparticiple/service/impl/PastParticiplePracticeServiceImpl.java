package emlearning.em.backend.domains.english.practice.pastparticiple.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emlearning.em.backend.domains.english.practice.pastparticiple.repository.PastParticipleJpaRepository;
import emlearning.em.backend.domains.english.practice.pastparticiple.service.PastParticipleService;

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
