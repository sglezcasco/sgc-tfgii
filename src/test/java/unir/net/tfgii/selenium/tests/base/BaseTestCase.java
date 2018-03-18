package unir.net.tfgii.selenium.tests.base;

import org.testng.annotations.Test;

import unir.net.tfgii.selenium.init.SeleniumDriverOperations;
import unir.net.tfgii.selenium.pageobjects.PageObjectLoginPage;
import unir.net.tfgii.selenium.utils.TestDataUtils;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;

public class BaseTestCase extends SeleniumDriverOperations {
	
	private static final Logger LOG = Logger.getLogger(BaseTestCase.class);
	



	@Test
	public PageObjectLoginPage irUrlOrigen() {

		String baseUrl= TestDataUtils.getData("baseUrl");
		//System.out.println("La url base es: "+baseUrl);
		
		String urlLogin= TestDataUtils.getData("urlOrigin");
		//System.out.println("La url personalizada es: "+urlLogin);
		
		//Creamos url final
		String urlInicio=baseUrl+urlLogin;
		System.out.println("La url de inicio es: "+urlInicio);
		
		getDriver().get(urlInicio);
		
		return initPageObject(PageObjectLoginPage.class);	
	}
	
	
	@AfterClass
	public void doFinalizarDriver() {
		
		LOG.debug("Cerrando el driver");

		try{
			//Si aun existe el driver, finaliza todas las ventanas asociadas al driver
			
			//getDriver().quit();
			
		}catch(Exception e){
			LOG.error(e.getLocalizedMessage(), e);
		}
	}
	
	
}
