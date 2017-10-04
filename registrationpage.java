package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import core2.ActionDriver;

public class registrationpage extends ActionDriver {
	public registrationpage(WebDriver driver)
	{
	super(driver);
	}
	String firstname="firstname";
	String middlename="middlename";
	String lastname="lastname";
	String email="email_address";
	String password="password";
	String confirmation="confirmation";
	String registration=".//*[@id='form-validate']/div[2]/button";
	
	public By getFirstname() {
	     return By.id(firstname);
	               }
	
	public By getMiddlename() {
	     return By.id(middlename);
	               }
	public By getLastname() {
	     return By.id(lastname);
	               }
	public By getEmail() {
	     return By.id(email);
	               }
	public By getPassword() {
	     return By.id(password);
	               }
	
	public By getConfirmation() {
	     return By.id(confirmation);
	               }
	public By getRegistraion() {
	     return By.xpath(registration);
	               }
	
	//_____________________________________
	
	
	public void typeFirstname(String value) {
	type(getFirstname(),value);
	}
	public void typeMiddleame(String value) {
		type(getMiddlename(),value);
		}
	public void typeLastname(String value) {
		type(getLastname(),value);
		}
	public void typeEmail(String value) {
		type(getEmail(),value);
		}
	public void typePass(String value) {
		type(getPassword(),value);
		}
	public void typeConfirmation(String value) {
		type(getConfirmation(),value);
		}
	public void clickRegistration() {
		click(getRegistraion());
		}
}
