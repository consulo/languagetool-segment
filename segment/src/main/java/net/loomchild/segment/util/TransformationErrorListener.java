package net.loomchild.segment.util;

import javax.xml.transform.ErrorListener;
import javax.xml.transform.TransformerException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Handles XML transformation errors by writing them to logr. 
 * @author loomchild
 */
public class TransformationErrorListener implements ErrorListener {

	private static final Logger log = LoggerFactory
			.getLogger(TransformationErrorListener.class);

	public void warning(TransformerException exception) {
		log.info("Transformation warning: " + exception.getMessage());
	}

	public void error(TransformerException exception)
			throws TransformerException {
		log.warn("Transformation error: " + exception.getMessage());
	}

	public void fatalError(TransformerException exception)
			throws TransformerException {
		throw exception;
	}

}
