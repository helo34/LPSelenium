package libreplan;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessageRetourEnregistrementCriteria{
	
	public MessageRetourEnregistrementCriteria(WebDriver driver) {
		super();
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		String idElement = driver.findElement(By.xpath("//div[1]")).getAttribute("id");
		prefixe = idElement.substring(0, 4);
		this.titreDeLaPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@id='"+ prefixe +"15-cnt']")));
		this.boutonCancel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='"+ prefixe +"j6']")));

}
	WebDriver driver;
	String prefixe;
	WebElement titreDeLaPage;
	WebElement boutonCancel;
		
	public void afficherMessageConfirmationEnregistrement(){
		
		WebElement messageRetourEditionCritere = driver.findElement(By.xpath("//td[@id='"+ prefixe +"i4-frame']/table/tbody/tr/td/div"));
		messageRetourEditionCritere.isDisplayed();
	}
	
	public CriteriaPage clicAnnulerEdit(){
		boutonCancel.click();
		return new CriteriaPage(driver);
	}
}