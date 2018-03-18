package unir.net.tfgii.selenium.drivers;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.apache.log4j.Logger;

import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import unir.net.tfgii.selenium.drivers.base.SeleniumDriverProvider;
import unir.net.tfgii.selenium.exception.TestAutomatizacionException;
import unir.net.tfgii.selenium.utils.TestDataUtils;

/**
 * Clase de Implementacion del Driver de Firefox
 *
 */
public class PhantomJSDriver  implements SeleniumDriverProvider  {
	
	private static final Logger LOG = Logger.getLogger(PhantomJSDriver.class);
	
	public WebDriver initDriver(String execution) throws TestAutomatizacionException,MalformedURLException {
		
		WebDriver driver;
		
		if (execution.equals("local")){
		
			final String phantomJSServer = TestDataUtils.getData("PhantomJSServer");
	
			System.out.println("Inicializando driver PhantomJS:"+phantomJSServer);
			System.setProperty("phantomjs.binary.path",phantomJSServer);
			
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setJavascriptEnabled(true);
			dc.setCapability("takesScreenShot", false);
			dc.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,phantomJSServer);
			dc.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, new String[] {"--ignore-ssl-errors=true", "--ssl-protocol=tlsv1", "--web-security=false", "--webdriver-loglevel=OFF", "--webdriver-loglevel=NONE"});
			dc.setPlatform(Platform.WINDOWS);
			
			LOG.debug("Inicializando driver PhantomJS");
			driver = new org.openqa.selenium.phantomjs.PhantomJSDriver(dc);
			
		}else{
			
			final String phantomJSServer = TestDataUtils.getData("PhantomJSServer");
			System.setProperty("phantomjs.binary.path",phantomJSServer);
			
			@SuppressWarnings("deprecation")
			DesiredCapabilities dc = DesiredCapabilities.phantomjs();
			dc.setJavascriptEnabled(true);
		    dc.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, new String[] {"--web-security=no", "--ignore-ssl-errors=yes"});
		    dc.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, new String[] {"--ignore-ssl-errors=true", "--ssl-protocol=tlsv1", "--web-security=false", "--webdriver-loglevel=OFF", "--webdriver-loglevel=NONE"});
			dc.setCapability("takesScreenshot", false);
		    
			LOG.debug("Inicializando driver PhantomJS Remoto");
			driver=new RemoteWebDriver(new URL("http://192.168.43.247:4444/wd/hub"), dc);

		}
		
		return driver;
	}
	

}	

