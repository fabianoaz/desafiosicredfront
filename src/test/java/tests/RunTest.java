package tests;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import Pages.AddFormPage;
import Pages.HomePage;
import core.Driver;

public class RunTest {

	Driver myDriver = new Driver();
	WebDriver driver = null;

	@Before
	public void Begin() {
		driver = myDriver.GetDriver();
		driver.navigate().to("https://www.grocerycrud.com/v1.x/demo/my_boss_is_in_a_hurry/bootstrap");
		driver.manage().window().maximize();
	}
	
	@After
	public void after() {
		driver.quit();
	}
	
	@Test
	public void InclusaoDeCadastro() {
		HomePage hm = new HomePage(driver);
		hm.selectItemList("Bootstrap V4 Theme");
		hm.addCostumer();
		
		AddFormPage form = new AddFormPage(driver);
		form.preencherFormulario("Teste Sicredi", "Teste", "Fabiano Azevedo", "51 9999-9999", "Av Assis Brasil, 3970", "Torre D", "Porto Alegre", "RS", "91000-000", "Brasil", "123456789", "200");
		form.salvar();
		form.validaReportSucesso();
	}
	
	@Test
	public void ExclusaoDeCadastro() {
		HomePage hm = new HomePage(driver);
		hm.selectItemList("Bootstrap V4 Theme");
		hm.localizaDeletaRegistro("Teste Sicredi");
		hm.validaReportSucessoExclusao();
	}
	
	@Test
	public void InclusaoExclusaoDeCadastro() {
		HomePage hm = new HomePage(driver);
		hm.selectItemList("Bootstrap V4 Theme");
		hm.addCostumer();
		
		AddFormPage form = new AddFormPage(driver);
		form.preencherFormulario("Teste Sicredi", "Teste", "Fabiano Azevedo", "51 9999-9999", "Av Assis Brasil, 3970", "Torre D", "Porto Alegre", "RS", "91000-000", "Brasil", "123456789", "200");
		form.salvarVoltar();
		
		hm.loadPage();
		hm.localizaDeletaRegistro("Teste Sicredi");
		hm.validaReportSucessoExclusao();
	}
}
