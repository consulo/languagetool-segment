package net.loomchild.segment.util;

import jakarta.xml.bind.ValidationEvent;
import jakarta.xml.bind.ValidationEventHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Handles XML validation errors by writing them to log.
 * @author loomchild
 */
public class LoggingValidationEventHandler implements ValidationEventHandler {

	private static final Logger log = LoggerFactory
			.getLogger(LoggingValidationEventHandler.class);

	public boolean handleEvent(ValidationEvent event) {
		if ((event.getSeverity() == ValidationEvent.FATAL_ERROR)
				|| (event.getSeverity() == ValidationEvent.ERROR)) {
			return false;
		} else if (event.getSeverity() == ValidationEvent.WARNING) {
			log.debug("Validation warning: " + event.getMessage() + ".");
			return true;
		} else {
			log.warn("Unknown validation event type.");
			return false;
		}
	}

}
