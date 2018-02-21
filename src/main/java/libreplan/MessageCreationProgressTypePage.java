package libreplan;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertEquals;

public class MessageCreationProgressTypePage extends CreationProgressTypePage {

	public MessageCreationProgressTypePage(WebDriver driver) {
		super(driver);
		String idElement = driver.findElement(By.xpath("//div[1]")).getAttribute("id");
		String prefixe = idElement.substring(0, 4);
		this.messageConirmationCreationProgressType = driver.findElement(By.xpath("//table[@id='"+prefixe+"i4-real']/tbody/tr[3]/td/div/span"));
	}

	WebElement messageConirmationCreationProgressType;
	
	
	
	public void verifMessageCreationProgressType(){
		String contenuMessage = messageConirmationCreationProgressType.getText();
		assertEquals("Progress Type \"Type avancement - Test 2\" saved", contenuMessage);
	}

	public ProgressTypePage annulerCreation(){
		boutonCancel.click();
		return new ProgressTypePage(driver);
	}

	
}
