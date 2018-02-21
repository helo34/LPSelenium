package libreplan;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PopUpSuppression {

	public PopUpSuppression(WebDriver driver) {
		super();
		this.driver = driver;
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String idElement = driver.findElement(By.xpath("//div[1]")).getAttribute("id");
		prefixe = idElement.substring(0, 4);		
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		this.boutonOK = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[3]/div[3]/div/div/div/table[2]/tbody/tr/td/table/tbody/tr/td[1]/span/table/tbody/tr[2]")));
		this.boutonAnnuler = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[3]/div[3]/div/div/div/table[2]/tbody/tr/td/table/tbody/tr/td[3]/span/table/tbody/tr[2]")));
		this.textePopUp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[3]/div[3]/div/div/div/table[1]/tbody/tr/td/table/tbody/tr/td[3]/div/span")));
	}

	String prefixe;
	WebDriver driver;
	WebElement boutonAnnuler;
	WebElement boutonOK;
	WebElement textePopUp;

		
		public CriteriaPage clicBoutonAnnulerPopUp(){
			boutonAnnuler.click();
			return new CriteriaPage(driver);
		}
		
		public CriteriaPage clicBoutonOKPopUp(){
			boutonOK.click();
			return new CriteriaPage(driver);
		}
}