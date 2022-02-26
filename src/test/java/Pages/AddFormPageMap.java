package Pages;

import org.openqa.selenium.By;

public class AddFormPageMap {

	protected By customerName = By.xpath("//input[@id='field-customerName']");

	protected By contactLastName = By.xpath("//input[@id='field-contactLastName']");

	protected By contactFirstName = By.xpath("//input[@id='field-contactFirstName']");

	protected By phone = By.xpath("//input[@id='field-phone']");

	protected By addressLine1 = By.xpath("//input[@id='field-addressLine1']");

	protected By addressLine2 = By.xpath("//input[@id='field-addressLine2']");

	protected By city = By.xpath("//input[@id='field-city']");

	protected By state = By.xpath("//input[@id='field-state']");

	protected By postalCode = By.xpath("//input[@id='field-postalCode']");

	protected By country = By.xpath("//input[@id='field-country']");

	protected By salesRepEmployeeNumber = By.xpath("//input[@id='field-salesRepEmployeeNumber']");

	protected By creditLimit = By.xpath("//input[@id='field-creditLimit']");

	protected By btnSave = By.xpath("//*[@id='form-button-save']");

	protected By btnBack = By.xpath("//*[@id='save-and-go-back-button']");

	protected By btnCancel = By.xpath("//*[@id='cancel-button']");
	
	protected By reportSuccess = By.xpath("//*[@id='report-success']");
}
