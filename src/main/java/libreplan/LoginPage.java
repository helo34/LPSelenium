package libreplan;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
protected final WebDriver driver;
	
	public LoginPage(WebDriver driver){
		super();
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String idElement = driver.findElement(By.xpath("//div[1]")).getAttribute("id");
		prefixe = idElement.substring(0, 4);
		this.champLogin = driver.findElement(By.id("textfield"));
		this.champPassword = driver.findElement(By.id("textfield2"));
		this.boutonConnexion = driver.findElement(By.id("button"));
	}
	
	String prefixe;
	WebElement champLogin;
	WebElement champPassword;
	WebElement boutonConnexion;
	
	public MenuPage connexion(String login, String password){
		this.champLogin.clear();
		this.champPassword.clear();
		this.champLogin.sendKeys(login);
		this.champPassword.sendKeys(password);
		this.boutonConnexion.click();
		return new MenuPage(driver);
	}
	
	public TableauDeBordPage connexionUser(String login, String password){
		this.champLogin.clear();
		this.champPassword.clear();
		this.champLogin.sendKeys(login);
		this.champPassword.sendKeys(password);
		this.boutonConnexion.click();
		return new TableauDeBordPage(driver);
	}

}
