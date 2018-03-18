package unir.net.tfgii.selenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.apache.log4j.Logger;

import unir.net.tfgii.selenium.pageobjects.base.BasePageObject;
import unir.net.tfgii.selenium.utils.TestDataUtils;


public class PageObjectRegisterPage extends BasePageObject {
	
	private static final Logger LOG = Logger.getLogger(PageObjectRegisterPage.class);
	
	/**Elementos del test_data.properties*/
	private String pUser = TestDataUtils.getData("userRegister");
	private String pPass = TestDataUtils.getData("passwordRegister");
	private String pMail = TestDataUtils.getData("mail");
	private String pSexo = TestDataUtils.getData("sexo");
	private String pLocalidad = TestDataUtils.getData("localidad");
	private String pProvincia = TestDataUtils.getData("provincia");
	private String pPais = TestDataUtils.getData("pais");
	
	/**Identificador input login*/
	@FindBy(id="usuario")
	private WebElement user;

	/**Identificador input password*/
	@FindBy(id="pwd")
	private WebElement password;
	
	/**Identificador input confirmar password*/
	@FindBy(id="pwd2")
	private WebElement password2;
	
	/**Identificador input email*/
	@FindBy(id="email")
	private WebElement email;
	
	/**Identificador input confirmar email*/
	@FindBy(id="email2")
	private WebElement email2;
	
	/**Identificador radio sexo*/
	@FindBy(xpath=".//*[@name='sexo' and @value='male']")
	private WebElement sexoMasc;
	
	/**Identificador radio sexo*/
	@FindBy(xpath=".//*[@name='sexo' and @value='female']")
	private WebElement sexoFem;
	
	/**Identificador campo localidad*/
	@FindBy(id="localidad")
	private WebElement localidad;
	
	/**Identificador campo provinca*/
	@FindBy(id="provincia")
	private WebElement provincia;
	
	/**Identificador combo pais*/
	@FindBy(id="pais")
	private WebElement comboPais;
	
	/**Identificador boton Enviar mensaje*/
	@FindBy(xpath="//input[@value='Enviar mensaje']")
	private WebElement btnEnviarRegistro;
	
	/**Identificador boton Volver*/
	@FindBy(xpath="//input[@value='Volver']")
	private WebElement btnVolver;
	
	
	public PageObjectRegisterPage(WebDriver driver) {
		super(driver);
	}


	/** Espera cargue pagina de registro*/
	public void esperaRegistroPage(){
		setWaitTimeout(30);
		waitForElementVisible("email");
	}
	
	
	/** Realiza registro*/
	public void rellenarRegistro(){
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		user.click();
		user.sendKeys(pUser);
		password.sendKeys(pPass);
		password2.sendKeys(pPass);
		email.sendKeys(pMail);
		email2.sendKeys(pMail);

		if (pSexo.equals("Masculino")){
			sexoMasc.click();
		}else{
			sexoFem.click();
		}
		
		localidad.sendKeys(pLocalidad);
		provincia.sendKeys(pProvincia);
		
		Select comboPais = new Select(getDriver().findElement(By.id("pais")));
		comboPais.selectByValue(pPais);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		LOG.debug("Registro rellenado con usuario: "+pUser);

		
		
	}
	
	/**Comprueba que el pagina de registro*/
	public boolean isPagRegistro() {
		try {
			getDriver().findElement(By.id("email"));
			return true;
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage(), e);
			return false;
		}
	
	}
	
	
	/** Dirige a registro*/
	public PageObjectPrincipalPage doRegister(){
		//btnEnviarRegistro.click();
		getDriver().findElement(By.xpath("//input[@value='Enviar mensaje']")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		//doAceptarAlert
		
		LOG.debug("Realizamos el registro. ");
		return initPageObject(PageObjectPrincipalPage.class);
		
	}
	
	
	/**Ir a pagina de login*/
	public PageObjectLoginPage volver() {
		btnVolver.click();
		return initPageObject(PageObjectLoginPage.class);	
	}
	
	


}
