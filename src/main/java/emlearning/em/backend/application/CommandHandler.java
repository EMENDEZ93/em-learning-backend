package emlearning.em.backend.application;

import emlearning.em.backend.domains.system.exception.SystemException;

public interface CommandHandler<T> {

	public void handle(T command) throws SystemException;
	
	public void commandHandler(T command);
	
}
