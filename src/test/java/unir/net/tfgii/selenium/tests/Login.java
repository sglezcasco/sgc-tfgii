package unir.net.tfgii.selenium.tests;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;
import org.testng.Assert;

import unir.net.tfgii.selenium.pageobjects.PageObjectLoginPage;
import unir.net.tfgii.selenium.pageobjects.PageObjectPrincipalPage;
import unir.net.tfgii.selenium.tests.base.BaseTestCase;
import unir.net.tfgii.selenium.utils.TestDataUtils;

@Test
public class Login extends BaseTestCase {

	private static final Logger LOG = Logger.getLogger(Login.class);
	
	
	/**Elementos del test_data.properties*/
	private String pUser = TestDataUtils.getData("userLogin");
	private String pPass = TestDataUtils.getData("passwordLogin");
	
	@Test
	public void login()  {
		
		PropertyConfigurator.configure("C:\\SoftDesarrollo\\workspace_SeleniumWebdriver\\tfgii_unir_sergiogc\\src\\test\\resources\\log4j.xml");

		/*
		 * Inicializamos el Driver 
		 * Actualizamos baseURL 
		 */
		LOG.debug("INICIO- Caso de Prueba de Login");
		
		/* Acceso URL */
		PageObjectLoginPage polp = irUrlOrigen();
		LOG.debug("01 -Cargamos la página de login");
		
		/*Esperamos que haya cargado*/
		polp.esperaLoginPage();
		LOG.debug("02 -Esperamos que cargue la página de login");
		
		/*Comprobamos que ha cargado la pagina correctamente*/
		Assert.assertTrue(polp.isPagLogin(), "No se encuentra en la pagina de login");
		LOG.debug("03 -Comprobamos que es la pagina de login");
		
		/*Hacemos login*/
		PageObjectPrincipalPage popp = polp.doLogin(pUser,pPass);
		LOG.debug("04 -Hacemos Login con user: "+pUser);
		
		/*Esperamos que haya cargado pagina principal*/
		popp.esperaPrincipalPage();
		LOG.debug("05 -Esperamos que cargue la página principal");
		
		/*Comprobamos que es la pagina principal*/
		Assert.assertTrue(popp.isPagPrincipal(), "No se encuentra en la pagina principal");
		LOG.debug("06 -Comprobamos que es la pagina principal ");
		
		/*Nos movemos a una seccion de la pagina principal*/
		popp.mover2Jenkins();
		LOG.debug("07 -Hacemos click en la seccion Jenkins ");

		/*Desconexion*/
		popp.salir();
		LOG.debug("08 -Salir");
		
		LOG.debug("FIN- TEST OK");
	}
}
