package Pages;

import org.openqa.selenium.By;

public class HomePageMap {
	
	
	protected By comboSelect =  By.xpath("//*[@id='switch-version-select']");
	
	protected By btnAddRecord =  By.xpath("//*[@class='header-tools']/*[@class='floatL t5']/a");
	
	protected By pesquisaNome =  By.xpath("//*[@name='customerName']");
	
	protected By selecionaTodos =  By.xpath("//*[@class='select-all-none']");
	
	protected By btnDelete =  By.xpath("//a[@title='Delete']//span[text()='Delete']");
	
	protected By modal =  By.xpath("//*[@class='modal-dialog']");
	
	protected By modalTexto =  By.xpath("//*[@class='modal-dialog']//*[@class='modal-body']");
	
	protected By modalBtnDelete =  By.xpath("//*[@class='modal-dialog']//*[@class='modal-footer']/button[text()='Delete']");
	
	protected By modalBtnCancel =  By.xpath("//*[@class='modal-dialog']//*[@class='modal-footer']/button[text()='Cancel']");

	protected By alertaSucesso = By.xpath("//[@class='alert alert-success growl-animated animated bounceInDown']");
}
