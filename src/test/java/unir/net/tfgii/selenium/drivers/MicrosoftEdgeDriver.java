package unir.net.tfgii.selenium.drivers;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
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
public class MicrosoftEdgeDriver  implements SeleniumDriverProvider{
	
	private static final Logger LOG = Logger.getLogger(MicrosoftEdgeDriver.class);
	
	public WebDriver initDriver(String execution) throws TestAutomatizacionException,MalformedURLException {
		
		WebDriver driver;
		
		if(execution.equals("local")){
			final String edgeServer = TestDataUtils.getData("EdgeServer");
	
			LOG.debug("Inicializando driver Microsoft Edge.");
		
			System.setProperty("webdriver.edge.driver", edgeServer);
			
			EdgeOptions options = new EdgeOptions();
			options.setPageLoadStrategy("eager");
			
			driver =  new EdgeDriver();
			
		}else{
			LOG.debug("Inicializando driver Edge Remoto");
			DesiredCapabilities dc = DesiredCapabilities.edge();
			dc.setPlatform(Platform.WINDOWS);

			driver=new RemoteWebDriver(new URL("http://172.30.141.59:4444/wd/hub"), dc);
				
		}
		
		
		driver.manage().window().maximize();

		return  driver;
	}

	
	
}	

	