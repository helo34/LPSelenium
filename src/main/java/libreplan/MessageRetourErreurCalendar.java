package libreplan;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MessageRetourErreurCalendar extends CreateCalendarPage {
	
	public MessageRetourErreurCalendar(WebDriver driver) {
		super(driver);		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//WebDriverWait wait = new WebDriverWait(driver, 10);

}
	
		
	public void afficherMessageErreurEnregistrement(){
		
		String idElement = driver.findElement(By.xpath("//div[1]")).getAttribute("id");
		String prefixe = idElement.substring(0, 4);	
		WebElement messageRetourErreurCalendar = driver.findElement(By.xpath("//td[@id='"+ prefixe +"i4-frame']"));
		messageRetourErreurCalendar.isDisplayed();
	} 

}
