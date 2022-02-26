package Pages;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddFormPage extends AddFormPageMap{
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public AddFormPage(WebDriver driver) 
	{
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(20));
	}
	
	public void preencherFormulario(String a,String b,String c,String d,String e,String f,String g,String h,String i,String j,String l,String m) {
		driver.findElement(customerName).sendKeys(a);
		driver.findElement(contactLastName).sendKeys(b);
		driver.findElement(contactFirstName).sendKeys(c);
		driver.findElement(phone).sendKeys(d);
		driver.findElement(addressLine1).sendKeys(e);
		driver.findElement(addressLine2).sendKeys(f);
		driver.findElement(city).sendKeys(g);
		driver.findElement(state).sendKeys(h);
		driver.findElement(postalCode).sendKeys(i);
		driver.findElement(country).sendKeys(j);
		driver.findElement(salesRepEmployeeNumber).sendKeys(l);
		driver.findElement(creditLimit).sendKeys(m);
	}
	
	public void salvar() {
		driver.findElement(btnSave).click();
	}
	
	public void salvarVoltar() {
		driver.findElement(btnBack).click();
	}
	
	public void cancelar() {
		driver.findElement(btnCancel).click();
	}
	
	public void validaReportSucesso() {
		WebElement report = driver.findElement(reportSuccess);
		this.wait.until(ExpectedConditions.textToBePresentInElement(report, "Your data has been successfully stored"));
		if(report.isDisplayed()) {
			System.out.println(report.getText());
			assertTrue(report.getText(), true);
		}else{
			assertFalse("Falha ao apresentar banner", false);
		}
	}

}
