package unir.net.tfgii.selenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.apache.log4j.Logger;

import unir.net.tfgii.selenium.pageobjects.base.BasePageObject;

public class PageObjectPrincipalPage extends BasePageObject {
	
	private static final Logger LOG = Logger.getLogger(PageObjectPrincipalPage.class);
	
	/**Identificador link Salir*/
	@FindBy(xpath=".//a[@href='http://www.sgc-tfgii.es/index.html']")
	private WebElement btnSalir;
	
	/**Identificador link Jenkins*/
	@FindBy(xpath=".//a[@href='#jenkins']")
	private WebElement btnSectionJenkins;
	
	/**Identificador link DummyWeb*/
	@FindBy(xpath=".//a[@href='#page-top']")
	private WebElement btnSectionHeader;
	
	

	public PageObjectPrincipalPage(WebDriver driver) {
		super(driver);
	}


	/** Espera cargue pagina principal*/
	public void esperaPrincipalPage(){
		setWaitTimeout(30);
		waitForElementVisibleByXpath(".//a[@href='#jenkins']");
	}
	
	
	
	/**Comprueba que el pagina principal*/
	public boolean isPagPrincipal() {
		try {
			getDriver().findElement(By.xpath(".//a[@href='#jenkins']"));
			return true;
		} catch (NoSuchElementException e) {
			LOG.error(e.getLocalizedMessage(), e);
			return false;
		}
	
	}
	
	/**Ir a una seccion*/
	public void  mover2Jenkins() {
		btnSectionJenkins.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}
	
	/**Ir a una seccion del header*/
	public void  mover2Header() {
		btnSectionHeader.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}
	
	/**Ir a pagina de login*/
	public PageObjectLoginPage salir() {
		//btnSalir.click();
		getDriver().get("http://www.sgc-tfgii.es/index.html");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		return initPageObject(PageObjectLoginPage.class);	
	}
	
	
	


}
