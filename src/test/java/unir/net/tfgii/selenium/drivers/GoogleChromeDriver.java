package unir.net.tfgii.selenium.drivers;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;

import unir.net.tfgii.selenium.drivers.base.SeleniumDriverProvider;
import unir.net.tfgii.selenium.exception.TestAutomatizacionException;
import unir.net.tfgii.selenium.utils.TestDataUtils;

/**
 * Clase de Implementacion del Driver de Google Chrome
 *
 */
public class GoogleChromeDriver  implements SeleniumDriverProvider{
	
	private static final Logger LOG = Logger.getLogger(GoogleChromeDriver.class);
	
	public WebDriver initDriver(String execution,String host) throws TestAutomatizacionException,MalformedURLException {
		
		WebDriver driver ;
		
		if(execution.equals("local")){
		
			final String chromeServer = TestDataUtils.getData("ChromeServer");
			final String chromeProfile = TestDataUtils.getData("ChromeProfile");
	
			LOG.debug("Inicializando driver Google Chrome.");
		
			System.setProperty("webdriver.chrome.driver", chromeServer);
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("user-data-dir="+chromeProfile);
			options.addArguments("--start-maximized");
			options.addArguments("--test-type");
			driver = new ChromeDriver(options);
		}else{
			LOG.debug("Inicializando driver Chrome Remoto");
			DesiredCapabilities dc = DesiredCapabilities.chrome();
			dc.setPlatform(Platform.LINUX);
			 
			driver=new RemoteWebDriver(new URL("http://"+host+"/wd/hub"), dc);

		}

		driver.manage().window().maximize();
		
		return driver;
	}
	
}	

	