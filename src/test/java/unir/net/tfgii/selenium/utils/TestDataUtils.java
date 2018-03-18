package unir.net.tfgii.selenium.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.log4j.Logger;

/**
 * Utilidades para datos de tests.
 * 
 */
public final class TestDataUtils {
	private static final Logger LOG = Logger.getLogger(TestDataUtils.class);

	private static final String TEST_DATA = "test_data";
	private static final String PROPERTIES_EXT = ".properties";
	public static final String DATA_FILES_CLASSPATH = "unir/net/tfgii/selenium/";


	private TestDataUtils() {
	}
	

	public static String getData(String key)  {
		
		String fileClasspath = DATA_FILES_CLASSPATH + TEST_DATA + PROPERTIES_EXT;
		
		final InputStream inputStream =TestDataUtils.class.getClassLoader().getResourceAsStream(fileClasspath);
        
		Properties prop = new Properties();
		
		/**load properties file*/
		try {
			prop.load(inputStream);
			inputStream.close();
		} catch (IOException e) {
			LOG.error(e.getLocalizedMessage(), e);
		}
		
		String value=null;;
		try {
			value = prop.getProperty(key);

			if (value == null) {
				LOG.debug("No se ha encontrado el dato para la clave "+key);
			}
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage(), e);
		}

		return value;
	}

	
}

