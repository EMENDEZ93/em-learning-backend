package emlearning.em.backend.domain.service.english.reload.impl;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emlearning.em.backend.domain.constant.english.verb.VerbConstant;
import emlearning.em.backend.domain.service.english.reload.ReloadVerbInTableService;
import emlearning.em.backend.persistence.entity.english.verb.PastEntity;
import emlearning.em.backend.persistence.entity.english.verb.PastParticipleEntity;
import emlearning.em.backend.persistence.entity.english.verb.PresentEntity;
import emlearning.em.backend.persistence.repository.english.verb.PastJpaRepository;
import emlearning.em.backend.persistence.repository.english.verb.PastParticipleJpaRepository;
import emlearning.em.backend.persistence.repository.english.verb.PresentJpaRepository;

@Service
public class ReloadVerbInTableImpl implements ReloadVerbInTableService {

	@Autowired
	private PresentJpaRepository presentJpaRepository;

	@Autowired
	private PastJpaRepository pastJpaRepository;

	@Autowired
	private PastParticipleJpaRepository pastParticipleJpaRepository;

	@Override
	public void reloadAllVerb() throws IOException, InvalidFormatException {
		reloadPresentVerbInTable();
		reloadPastVerbInTable();
		reloadPastParticipleVerbInTable();
	}

	@Override
	public void reloadPresentVerbInTable() throws InvalidFormatException, IOException {
		getAllverbForTime(VerbConstant.presentTime).stream().forEach(verb -> {
			if (!presentJpaRepository.existsByVerb(verb)) {
				PresentEntity newVerb = new PresentEntity();
				newVerb.setVerb(verb);
				presentJpaRepository.save(newVerb);
			}
		});
	}

	@Override
	public void reloadPastVerbInTable() throws InvalidFormatException, IOException {
		getAllverbForTime(VerbConstant.pastTime).stream().forEach(verb -> {
			if (!pastJpaRepository.existsByVerb(verb)) {
				PastEntity newVerb = new PastEntity();
				newVerb.setVerb(verb);
				pastJpaRepository.save(newVerb);
			}
		});
	}

	@Override
	public void reloadPastParticipleVerbInTable() throws InvalidFormatException, IOException {
		getAllverbForTime(VerbConstant.pastPraticipleTime).stream().forEach(verb -> {
			if (!pastParticipleJpaRepository.existsByVerb(verb)) {
				PastParticipleEntity newVerb = new PastParticipleEntity();
				newVerb.setVerb(verb);
				pastParticipleJpaRepository.save(newVerb);
			}
		});
	}

}
