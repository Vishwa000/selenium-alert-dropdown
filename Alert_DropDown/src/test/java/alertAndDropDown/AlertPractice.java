package alertAndDropDown;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertPractice {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ASUS\\git\\selenium-alert-dropdown\\Alert_DropDown\\target\\chromedriver.exe");

		WebDriver browser = new ChromeDriver(); // launch the browser
		browser.manage().window().maximize();

		browser.navigate().to("https://demo.automationtesting.in/Alerts.html");

		// Alert with OK

		WebElement clickAlert = browser
				.findElement(By.xpath("//button[@onclick='alertbox()' and @onclick='alertbox()']"));
		clickAlert.click();

		Alert alert = browser.switchTo().alert();
		Thread.sleep(3000);
		alert.accept();

		// Alert with OK & Cancel

		WebElement selectAlert = browser.findElement(By.xpath("//a[@class='analystic' and @href='#CancelTab']"));
		selectAlert.click();

		browser.findElement(By.xpath("//button[@onclick='confirmbox()']")).click();

		Alert alert2 = browser.switchTo().alert();
		Thread.sleep(2000);
		alert2.accept();
//		alert.dismiss();

		// Alert with Textbox

		WebElement selectTextAlert = browser.findElement(By.xpath("//a[@href='#Textbox']"));
		selectTextAlert.click();

		browser.findElement(By.xpath("//button[@class='btn btn-info']")).click();

		Alert alert3 = browser.switchTo().alert();
//		clickPopUp.sendKeys("Hello world");
		alert3.sendKeys("Vichu");
		alert3.accept();

		Thread.sleep(5000);
		browser.quit();
	}

}
