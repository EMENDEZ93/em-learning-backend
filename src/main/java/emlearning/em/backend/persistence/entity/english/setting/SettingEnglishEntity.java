package emlearning.em.backend.persistence.entity.english.setting;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import emlearning.em.backend.persistence.repository.english.constant.setting.SettingConstant;

@Entity
@Table(name = "setting_english")
public class SettingEnglishEntity implements Serializable {

	private static final long serialVersionUID = 3083465801855806100L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private int repeatToLearnedVerb;

	@PrePersist
	public void prePersist() {
		repeatToLearnedVerb = SettingConstant.DEFAULT_REPETTIONS_TO_LEARNED_VERB;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getRepeatToLearnedVerb() {
		return repeatToLearnedVerb;
	}

	public void setRepeatToLearnedVerb(int repeatToLearnedVerb) {
		this.repeatToLearnedVerb = repeatToLearnedVerb;
	}

}
