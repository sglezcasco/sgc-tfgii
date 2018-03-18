package unir.net.tfgii.selenium.pageobjects.base;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import unir.net.tfgii.selenium.init.SeleniumDriverOperations;


public class BasePageObject extends SeleniumDriverOperations {
	
	/** Tiempo de espera por defecto*/
	private int waitTimeout = 30;

	
	public BasePageObject(WebDriver driver) {
		setDriver(driver);
	}

	
	/** 
	 * Pulsamos el boton "Aceptar" de un Alert
	 */
	public void doAceptarAlert(){
		getDriver().switchTo().alert().accept();
	}
	
	public void setWaitTimeout(int seconds) {
		getDriver().manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}
	
	public int getWaitTimeout() {
		return this.waitTimeout;
	}
	
	
	/**
	 * Espera a que se cumpla cierta condición.
	 * @param condition Condición a esperar hasta que se cumpla o se llegue al timeout.
	 * @return Elemento retornado en la condición.
	 * @throws TimeoutException si en el tiempo especificado por {@link SeleniumDriverOperations#getWaitTimeout()} no ha econtrado el elemento.
	 */
	protected <T> T waitForCondition(ExpectedCondition<T> condition) {
		final WebDriverWait wdw = new WebDriverWait(getDriver(), getWaitTimeout());
		return wdw.until(condition);
	}
	

	
	/**
	 * Espera a que un elemento esté visible
	 * @param elementId ID del elemento
	 * @return Elemento
	 * @throws TimeoutException si en el tiempo especificado por {@link SeleniumDriverOperations#getWaitTimeout()} no ha econtrado el elemento y además es visible.
	 */
	protected WebElement waitForElementVisible(String elementId) {
		return waitForCondition(ExpectedConditions.visibilityOfElementLocated(By.id(elementId)));
	}
	
	
	/**
	 * Espera a que un elemento esté visible
	 * @param elementId ID del elemento
	 * @return Elemento
	 * @throws TimeoutException si en el tiempo especificado por {@link SeleniumDriverOperations#getWaitTimeout()} no ha econtrado el elemento y además es visible.
	 */
	protected WebElement waitForElementVisibleByXpath(String xpath) {
		return waitForCondition(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}
	

	
	/**
	 * Espera a que un elemento esté visible
	 * @param elementName name del elemento
	 * @return Elemento
	 * @throws TimeoutException si en el tiempo especificado por {@link SeleniumDriverOperations#getWaitTimeout()} no ha econtrado el elemento y además es visible.
	 */
	protected WebElement waitForElementVisibleByName(String elementName) {
		return waitForCondition(ExpectedConditions.visibilityOfElementLocated(By.name(elementName)));
	}
	
	/**
	 * Espera a que un elemento esté presente
	 * @param elementId ID del elemento
	 * @return Elemento
	 * @throws TimeoutException si en el tiempo especificado por {@link SeleniumDriverOperations#DEFAULT_WAIT_TIMEOUT_SECONDS} no ha econtrado el elemento.
	 */
	protected WebElement waitForElementPresent(String elementId) {
		return waitForCondition(ExpectedConditions.presenceOfElementLocated(By.id(elementId)));
	}
	
}
