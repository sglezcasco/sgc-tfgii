package unir.net.tfgii.selenium.init;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import unir.net.tfgii.selenium.drivers.base.SeleniumDriverProvider;
import unir.net.tfgii.selenium.exception.TestAutomatizacionException;



/**
 * Clase base de los tests de automatización basados en TestNG.
 * --Init driver
 * --Init pageobject
 */
public abstract class SeleniumDriverOperations  {
	private static final Logger LOG = Logger.getLogger(SeleniumDriverOperations.class);
	
	public static final String DRIVER_PROVIDERS_DEFAULT_PACKAGE = "unir.net.tfgii.selenium.drivers";
	
	/** Driver de Selenium WebDriver. */
	private WebDriver driver;
	

	
	/**
	 * Método que se ejecutará al inicio de cada test.
	 * Dado el parametro driverProvider, levanta objeto de la clase driver e inicializa el driver
	 * 
	 */

	@BeforeClass
	@Parameters({"driverProvider","execution","host"})
	@SuppressWarnings("unchecked")
	public void testBeforeClass(String driverProvider,String execution,String host) {
		
			final String driverProviderClassName = DRIVER_PROVIDERS_DEFAULT_PACKAGE + "." + driverProvider;
		
			SeleniumDriverProvider provider =null;
				
			
				try {
					final Class<? extends SeleniumDriverProvider> driverProviderClass = (Class<? extends SeleniumDriverProvider>) Class.forName(driverProviderClassName);
					
					try {
						provider = driverProviderClass.newInstance();
						
						/**inicializa el driver*/
						try {
							setDriver(provider.initDriver(execution,host));
							LOG.debug("Driver inicializado correctamente");
						} catch (TestAutomatizacionException e) {
							LOG.error(e.getLocalizedMessage(), e);
							throw new TestAutomatizacionException("Error al inicializar driver mediante provider [" + provider + "].", e);
						}
							
					} catch (Exception e) {
						LOG.error(e.getLocalizedMessage(), e);
					}
				} catch (Exception e) {
					LOG.error(e.getLocalizedMessage(), e);
				}
		

	}

	
	/**
	 * Método ejecutado al final de cada test por TestNG.
	 */
	@AfterClass
	public void testAfterClass() {
		closeDriverSafe();
	}
	

	/**
	 * Cierra el navegador y el driver actual.
	 */
	protected void closeDriverSafe() {
		if (this.driver != null) {
			this.driver.quit();
			this.driver = null;
		}
	}


	/**
	 * Recupera el driver actual.
	 * @return Driver actual.
	 */
	protected WebDriver getDriver() {
		return this.driver;
	}


	/**
	 * Asigna el driver para todas las operaciones con WebDriver.
	 * @param driver Driver de WebDriver.
	 */
	protected void setDriver(WebDriver driver) {
		closeDriverSafe();
		this.driver = driver;
	}

	/**
	 * Inicializa un objeto PageObject.
	 * @param <T> Clase del PageObject.
	 * @param pageObjectClass Clase del PageObject.
	 * @return Objeto PageObject de la clase indicada a partir de la URL actual del driver Selenium.
	 */
	public <T> T initPageObject(Class<T> pageObjectClass) {
		return PageFactory.initElements(driver, pageObjectClass);
	}
}
