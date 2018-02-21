package libreplan;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MessageRetourEnregistrementCalendar extends CreateCalendarPage {
	
	public MessageRetourEnregistrementCalendar(WebDriver driver) {
		super(driver);
		this.driver = driver;
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//WebDriverWait wait = new WebDriverWait(driver, 10);

}
	
		
	public void afficherMessageConfirmationEnregistrement(){
		
		String idElement = driver.findElement(By.xpath("//div[1]")).getAttribute("id");
		String prefixe = idElement.substring(0, 4);	
		WebElement messageRetourEditionCalendar = driver.findElement(By.xpath("//table[@id='"+ prefixe +"i4-frame']/table/tbody/tr/td/div"));
		messageRetourEditionCalendar.isDisplayed();
	}
	

}

