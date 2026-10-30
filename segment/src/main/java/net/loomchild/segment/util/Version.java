package net.loomchild.segment.util;

import static net.loomchild.segment.util.Util.getJarManifest;

import java.util.jar.Manifest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Retrieves segment version. Singleton.
 * @author loomchild
 */
public class Version {
	
    private static final Logger log = LoggerFactory.getLogger(Version.class);
	
	public static final String VERSION_ATTRIBUTE = "Implementation-Version";  
	public static final String DATE_ATTRIBUTE = "Build-Date";  
	
	private static Version instance = new Version();
	
	private String version;

	private String date;
	
	public static Version getInstance() {
		return instance;
	}
	
	private Version() {
		try {
			Manifest manifest = getJarManifest(Version.class);
			version = manifest.getMainAttributes().getValue(VERSION_ATTRIBUTE);
			date = manifest.getMainAttributes().getValue(DATE_ATTRIBUTE);
		} catch (ResourceNotFoundException e) {
			// Ignore, attributes stay null
			log.debug("Version number cannot be retrieved.");
		}
	}

	/**
	 * @return segment version string
	 */
	public String getVersion() {
		return version;
	}
	
	/**
	 * @return segment build date
	 */
	public String getDate() {
		return date;
	}
	
}
