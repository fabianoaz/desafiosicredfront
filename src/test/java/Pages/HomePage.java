package Pages;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends HomePageMap {

	private WebDriver driver;
	private WebDriverWait wait;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(20));
	}

	public void selectItemList(String texto) {
		WebElement combo = driver.findElement(comboSelect);
		Select select = new Select(combo);
		select.selectByVisibleText(texto);
	}

	public void addCostumer() {
		driver.findElement(btnAddRecord).click();
	}

	public void loadPage() {
		String sucesso = driver.getCurrentUrl();
		while (!sucesso.contains("success")) {
			sucesso = driver.getCurrentUrl();
			if (sucesso.contains("success")) {
				break;
			}
		}
	}

	public void aguardar(int tempo) {
		try {
			Thread.sleep(tempo * 1000);
		} catch (InterruptedException e1) {
			/**/
		}
	}

	public void localizaDeletaRegistro(String nome) {
		boolean check = false;
		int cont = 0;
		driver.findElement(pesquisaNome).sendKeys(nome);



		while (cont < 2) {
			try {
				check = this.wait.until(ExpectedConditions.textToBe(By.xpath("//tr[1]/td[3]"), nome));
			} catch (Exception e) {
				cont++;				
			}
			if (cont == 2) {
				assertFalse("Nome não localizado para exclusão", true);
				break;
			}
			if (check) {
				System.out.println(driver.findElement(By.xpath("//tr[1]/td[3]")).getText());
				break;
			} 
		}

		try {
			this.wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(selecionaTodos)));
			driver.findElement(selecionaTodos).click();
			driver.findElement(btnDelete).click();
		} catch (Exception e1) {
			System.out.println("Ocorreu falha ao clicar no botão DELETE 2\n" + e1.getMessage());
		}

		try {
			String textoModal = driver
					.findElement(By
							.xpath("//div[contains(@class,'delete-multiple-confirmation')]//div[@class='modal-body']"))
					.getText();

			if (textoModal.contains("delete this 1 item?")) {
				System.out.println("Modal apresentou a mensagem: " + textoModal);
				driver.findElement(
						By.xpath("//div[contains(@class,'delete-multiple-confirmation')]/div/div/div[3]/button[2]"))
						.click();
			} else {
				if (textoModal.contains("items?")) {
					System.out.println("Modal apresentou a mensagem para eclusão de diversos itens: " + textoModal
							+ "\nConfirmando a exclusão dos itens");
					driver.findElement(
							By.xpath("//div[contains(@class,'delete-multiple-confirmation')]/div/div/div[3]/button[2]"))
							.click();
				} else {
					System.out.println("Modal apresentou a mensagem inesperada: " + textoModal);
				}
			}
		} catch (Exception e) {
			System.out.println("Ocorreu falha ao confirmar exlcusão!!\n" + e.getMessage());
		}
	}

	public void validaReportSucessoExclusao() {
		aguardar(5);
		WebElement message = this.wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//*[contains(text(),'Your data has been successfully deleted from the database')]")));
		if (message != null) {
			System.out.println(message.getText());
			assertTrue(message.getText().contains("deleted"));
		} else {
			assertTrue("Falhou ao validar mensagem de sucesso de exclusão", false);
		}
	}

}
