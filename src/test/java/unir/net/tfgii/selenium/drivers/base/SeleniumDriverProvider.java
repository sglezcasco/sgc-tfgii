package unir.net.tfgii.selenium.drivers.base;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;

import unir.net.tfgii.selenium.exception.TestAutomatizacionException;

/**
 * Proveedor de drivers de Selenium.
 */
public interface SeleniumDriverProvider {
	WebDriver initDriver(String execution) throws TestAutomatizacionException, MalformedURLException;
}
