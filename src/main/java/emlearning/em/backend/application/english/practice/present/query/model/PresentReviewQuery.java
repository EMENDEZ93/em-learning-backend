package emlearning.em.backend.application.english.practice.present.query.model;

public class PresentReviewQuery {

	private Long id;

	private String verb;

	public PresentReviewQuery(Long id, String verb) {
		this.id = id;
		this.verb = verb;
	}

	public Long getId() {
		return id;
	}

	public String getVerb() {
		return verb;
	}

}
