package libreplan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateNewUserPage extends PersonalDataWorkerPage {



	public CreateNewUserPage(WebDriver driver) {
		super(driver);
		String idElement = driver.findElement(By.xpath("//div[1]")).getAttribute("id");
		String prefixe = idElement.substring(0, 4);
		this.champUsername = driver.findElement(By.id(prefixe+"i8"));
		this.champPassword = driver.findElement(By.id(prefixe+"l8"));
		this.champPasswordConfirm = driver.findElement(By.id(prefixe+"o8"));
		this.champEmail = driver.findElement(By.id(prefixe+"r8"));
		this.boutonSaveWorker = driver.findElement(By.xpath("//table[@id='"+prefixe+"7f-box']/tbody/tr[2]/td[2]"));
	}	 
	
	WebElement champEmail;
	WebElement champPasswordConfirm;
	WebElement champPassword;
	WebElement champUsername;
	WebElement boutonSaveWorker;
	
	public void remplirDataUser(String name, String password, String email){
		champUsername.sendKeys(name);
		champPassword.sendKeys(password);
		champPasswordConfirm.sendKeys(password);
		champEmail.sendKeys(email);
	}
	
	public WorkerPage enregistrerNewWorker(){
		boutonSaveWorker.click();
		return new WorkerPage(driver);
		}
	
}
