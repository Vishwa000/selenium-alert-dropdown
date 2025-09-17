package alertAndDropDown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownPractice {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ASUS\\git\\selenium-alert-dropdown\\Alert_DropDown\\target\\chromedriver.exe");

		WebDriver browser = new ChromeDriver(); // launch the browser
		browser.manage().window().maximize();

		browser.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/#google_vignette");

		// single value dropdown

		WebElement clickDropDown = browser.findElement(By.tagName("select"));
		clickDropDown.click();

		Select drop = new Select(clickDropDown);
		Thread.sleep(2000);
		drop.selectByValue("AIA");
		Thread.sleep(2000);
		drop.selectByIndex(109);
		Thread.sleep(2000);
		drop.selectByVisibleText("China");

		List<WebElement> getCountryNames = drop.getOptions();

		System.out.println(getCountryNames.size());
		for (int i = getCountryNames.size() - 1; i >= 0; i--) {

			WebElement names = getCountryNames.get(i);
			String getName = names.getText();
			System.out.println(getName);

		}

		boolean checksDropDownValue = drop.isMultiple();
		System.out.println(checksDropDownValue); // check if it's single
													// value dropdown or
													// multiple value
													// dropdown
		Thread.sleep(2000);

		browser.switchTo().newWindow(WindowType.TAB);

		// multiple value dropdown

		browser.navigate().to("https://theautomationzone.blogspot.com/2020/07/basic-dropdown.html");

		WebElement clickDropDowns = browser.findElement(By.xpath("//select[@name='cars']"));

		Select down = new Select(clickDropDowns);
		down.selectByIndex(0);
		down.selectByVisibleText("Saab");
		down.selectByValue("opel");
		down.selectByIndex(3);

		WebElement getFirstSelector = down.getFirstSelectedOption(); // console the first selector text
		System.out.println(getFirstSelector.getText());

		down.deselectByValue("opel");
		Thread.sleep(2000);
		down.deselectAll();

		Thread.sleep(6000);
		browser.quit();
	}

}
