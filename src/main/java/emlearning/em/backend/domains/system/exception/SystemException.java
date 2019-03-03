package emlearning.em.backend.domains.system.exception;

public class SystemException extends Exception {

	private static final long serialVersionUID = 499437815003789726L;
	private final String message;

	public SystemException(String message) {
		super(message);
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
