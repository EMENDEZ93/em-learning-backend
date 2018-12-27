package emlearning.em.backend.domain.dto.english.verb;

import java.io.Serializable;

public class VerbDto implements Serializable {

	private static final long serialVersionUID = 3935590182777680021L;

	private String present;

	private String past;

	private String pastParticiple;

	public String getPresent() {
		return present;
	}

	public void setPresent(String present) {
		this.present = present;
	}

	public String getPast() {
		return past;
	}

	public void setPast(String past) {
		this.past = past;
	}

	public String getPastParticiple() {
		return pastParticiple;
	}

	public void setPastParticiple(String pastParticiple) {
		this.pastParticiple = pastParticiple;
	}

}
