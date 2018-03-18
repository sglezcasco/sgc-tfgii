package unir.net.tfgii.selenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.apache.log4j.Logger;

import unir.net.tfgii.selenium.pageobjects.base.BasePageObject;


public class PageObjectLoginPage extends BasePageObject {
	
	private static final Logger LOG = Logger.getLogger(PageObjectLoginPage.class);
	
	/**Identificador input login*/
	@FindBy(id="usuario")
	private WebElement user;

	/**Identificador input password*/
	@FindBy(id="pwd")
	private WebElement password;
	
	/**Identificador boton Entrar*/
	@FindBy(xpath="//input[@value='Entrar']")
	private WebElement btnEntrar;
	
	/**Identificador boton Registrar*/
	@FindBy(xpath="//input[@value='Registrarse']")
	private WebElement btnRegistrar;
	
	
	public PageObjectLoginPage(WebDriver driver) {
		super(driver);
	}


	/** Espera cargue pagina de login*/
	public void esperaLoginPage(){
		setWaitTimeout(30);
		waitForElementVisible("usuario");
	}
	
	
	/** Realiza login*/
	public PageObjectPrincipalPage doLogin(String usuario, String pass){
		user.sendKeys(usuario);
		password.sendKeys(pass);
		
		btnEntrar.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		LOG.debug("Logamos con user: "+usuario+ " y pwd: "+password);

		return initPageObject(PageObjectPrincipalPage.class);
		
	}
	
	/**Comprueba que el pagina de login*/
	public boolean isPagLogin() {
		try {
			getDriver().findElement(By.id("usuario"));
			return true;
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage(), e);
			return false;
		}
	
	}
	
	
	/** Dirige a registro*/
	public PageObjectRegisterPage doRegister(){
		btnRegistrar.click();
		LOG.debug("Vamos al registro de usuarios");
		return initPageObject(PageObjectRegisterPage.class);
		
	}


}
