package emlearning.em.backend.domains.english.reload.service.impl;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import emlearning.em.backend.domains.english.constant.verb.VerbConstant;
import emlearning.em.backend.domains.english.practice.example.entity.repository.ExampleVerbJpaRepository;
import emlearning.em.backend.domains.english.practice.past.entity.PastEntity;
import emlearning.em.backend.domains.english.practice.past.repository.PastJpaRepository;
import emlearning.em.backend.domains.english.practice.pastparticiple.entity.PastParticipleEntity;
import emlearning.em.backend.domains.english.practice.pastparticiple.repository.PastParticipleJpaRepository;
import emlearning.em.backend.domains.english.practice.present.entity.PresentEntity;
import emlearning.em.backend.domains.english.practice.present.repository.PresentJpaRepository;
import emlearning.em.backend.domains.english.reload.service.ReloadVerbInTableService;

@Service
public class ReloadVerbInTableImpl implements ReloadVerbInTableService {

	@Autowired
	private PresentJpaRepository presentJpaRepository;

	@Autowired
	private PastJpaRepository pastJpaRepository;

	@Autowired
	private PastParticipleJpaRepository pastParticipleJpaRepository;

	@Autowired
	private ExampleVerbJpaRepository exampleVerbJpaRepository;

	@Override
	public void reloadAllVerb() throws IOException, InvalidFormatException {
		reloadPresentVerbInTable();
	}

	@Override
	public void reloadPresentVerbInTable() throws InvalidFormatException, IOException {
		getAllverbForTime(VerbConstant.presentTime).stream().forEach(verbDto -> {
			if (!presentJpaRepository.existsByVerb(verbDto.getPresent())) {

					PresentEntity newVerb = new PresentEntity();
					newVerb.setVerb(verbDto.getPresent());
					presentJpaRepository.save(newVerb);
					
			}
		});
	}

	@Override
	public PastEntity reloadPastVerbInTable(String pastVerb) throws InvalidFormatException, IOException {
		PastEntity newVerb = new PastEntity();
		newVerb.setVerb(pastVerb);
		return pastJpaRepository.save(newVerb);
	}

	@Override
	public PastParticipleEntity reloadPastParticipleVerbInTable(String pastParticipleVerb)
			throws InvalidFormatException, IOException {
		PastParticipleEntity newVerb = new PastParticipleEntity();
		newVerb.setVerb(pastParticipleVerb);
		return pastParticipleJpaRepository.save(newVerb);
	}

	@Transactional
	@Override
	public void reloadAllExampleVerb() throws IOException, InvalidFormatException {
		getAllExampleVerb().forEach(example -> {

			if (!exampleVerbJpaRepository.existsByAuxiliaryId(example.getAuxiliaryId())) {

				if (presentJpaRepository.existsByVerb(example.getVerb())) {
					exampleVerbJpaRepository.save(example);
				}

			}

		});
	}

}
