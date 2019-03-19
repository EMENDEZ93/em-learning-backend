package emlearning.em.backend.domains.english.setting.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import emlearning.em.backend.domains.english.setting.constant.SettingConstant;

@Entity
@Table(name = "setting_english")
public class SettingEnglishEntity implements Serializable {

	private static final long serialVersionUID = 3083465801855806100L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private int repeatToLearnedVerb;

	private int repeatToLearnedPresentExampleVerb;

	private int repeatToReviewVerb;

	private int repeatToPastVerb;

	@PrePersist
	public void prePersist() {
		repeatToLearnedVerb = SettingConstant.DEFAULT_REPETTIONS_TO_LEARNED_VERB;
		repeatToLearnedPresentExampleVerb = SettingConstant.DEFAULT_REPETTIONS_TO_LEARNED_PRESENT_EXAMPLE_VERB;
		repeatToReviewVerb = SettingConstant.DEFAULT_REPETTIONS_TO_LEARNED_REVIEW_VERB;
		repeatToPastVerb = SettingConstant.DEFAULT_REPETTIONS_TO_LEARNED_PAST_VERB;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getRepeatToLearnedPresentExampleVerb() {
		return repeatToLearnedPresentExampleVerb;
	}

	public void setRepeatToLearnedPresentExampleVerb(int repeatToLearnedPresentExampleVerb) {
		this.repeatToLearnedPresentExampleVerb = repeatToLearnedPresentExampleVerb;
	}

	public int getRepeatToLearnedVerb() {
		return repeatToLearnedVerb;
	}

	public void setRepeatToLearnedVerb(int repeatToLearnedVerb) {
		this.repeatToLearnedVerb = repeatToLearnedVerb;
	}

	public int getRepeatToReviewVerb() {
		return repeatToReviewVerb;
	}

	public void setRepeatToReviewVerb(int repeatToReviewVerb) {
		this.repeatToReviewVerb = repeatToReviewVerb;
	}

	public int getRepeatToPastVerb() {
		return repeatToPastVerb;
	}

	public void setRepeatToPastVerb(int repeatToPastVerb) {
		this.repeatToPastVerb = repeatToPastVerb;
	}

}
