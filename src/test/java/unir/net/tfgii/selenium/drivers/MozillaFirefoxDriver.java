package unir.net.tfgii.selenium.drivers;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import unir.net.tfgii.selenium.drivers.base.SeleniumDriverProvider;
import unir.net.tfgii.selenium.exception.TestAutomatizacionException;
import unir.net.tfgii.selenium.utils.TestDataUtils;

/**
 * Clase de Implementacion del Driver de Firefox
 *
 */
public class MozillaFirefoxDriver implements SeleniumDriverProvider {
	
	private static final Logger LOG = Logger.getLogger(MozillaFirefoxDriver.class);
	
	public WebDriver initDriver(String execution,String host) throws TestAutomatizacionException,MalformedURLException {
		
		WebDriver driver;
		
		if (execution.equals("local")){
		
			final String firefoxServer = TestDataUtils.getData("FirefoxServer");
	
			LOG.debug("Inicializando driver Firefox:"+firefoxServer);
			System.setProperty("webdriver.gecko.driver", firefoxServer);
			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
			
			FirefoxBinary firefoxBinary = new FirefoxBinary();
			//firefoxBinary.addCommandLineOptions("--headless");
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.setBinary(firefoxBinary);

			driver = new FirefoxDriver(firefoxOptions);
		
		}else{
			LOG.debug("Inicializando driver Firefox Remoto");
			FirefoxOptions ffoptions = new FirefoxOptions();
			ffoptions.setHeadless(true);
					
			driver=new RemoteWebDriver(new URL("http://"+host+":4444/wd/hub"), ffoptions);
		
		}
		
		driver.manage().deleteAllCookies();
		
		driver.manage().window().maximize();
		
		return driver;
	}
	

}	

