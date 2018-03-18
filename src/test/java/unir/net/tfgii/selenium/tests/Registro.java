package unir.net.tfgii.selenium.tests;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;
import org.testng.Assert;

import unir.net.tfgii.selenium.pageobjects.PageObjectLoginPage;
import unir.net.tfgii.selenium.pageobjects.PageObjectPrincipalPage;
import unir.net.tfgii.selenium.pageobjects.PageObjectRegisterPage;
import unir.net.tfgii.selenium.tests.base.BaseTestCase;

@Test
public class Registro extends BaseTestCase {

	private static final Logger LOG = Logger.getLogger(Registro.class);
	
	@Test
	public void registro()  {
		
		PropertyConfigurator.configure("C:\\SoftDesarrollo\\workspace_SeleniumWebdriver\\tfgii_unir_sergiogc\\src\\test\\resources\\log4j.xml");

		/*
		 * Inicializamos el Driver 
		 * Actualizamos baseURL 
		 */
		LOG.debug("INICIO- Caso de Prueba de Registro");
		
		/* Acceso URL */
		PageObjectLoginPage polp = irUrlOrigen();
		LOG.debug("01 -Cargamos la página de login");
		
		/*Esperamos que haya cargado*/
		polp.esperaLoginPage();
		LOG.debug("02 -Esperamos que cargue la página de login");
		
		/*Comprobamos que ha cargado la pagina correctamente*/
		Assert.assertTrue(polp.isPagLogin(), "No se encuentra en la pÃ¡gina de login");
		LOG.debug("03 -Comprobamos que es la pagina de login");
		
		/*Vamos al registro */
		PageObjectRegisterPage porp = polp.doRegister();
		LOG.debug("04 -Vamos al registro de usuarios");
		
		/*Esperamos que haya cargado pagina de registro*/
		porp.esperaRegistroPage();
		LOG.debug("05 -Esperamos que cargue la página de registro");
		
		/*Comprobamos que es la pagina de registro*/
		Assert.assertTrue(porp.isPagRegistro(), "No se encuentra en la página de regstro");
		LOG.debug("06 -Comprobamos que es la pagina de registro ");
		
		/*Rellenamos datos usuario a registrar*/
		porp.rellenarRegistro();
		LOG.debug("07 -Datos formulario registro rellenados");
		
		/*Nos movemos a una seccion de la pagina principal*/
		PageObjectPrincipalPage popp = porp.doRegister();
		LOG.debug("08 -Enviar Registrado");
		
		/*Desconexion*/
		popp.salir();
		LOG.debug("09 -Salir");
		
		
		LOG.debug("FIN- TEST OK");
	}
}
