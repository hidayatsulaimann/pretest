package bukalapak.pretest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends BasePage {

	By registerLink = By.xpath("//div[@id='vm__white-header-dweb']/section/header/div[3]/div/div/div[2]/div/a/p");
	By emailAddress = By.xpath("//input[@type='text']");
	By clickRegisterBtn = By.xpath("//html/body/main/div/div[2]/section/div[2]/button/span");
	By sentOTPCode = By.xpath(
			"//body[1]/div[1]/section[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/button[1]/span[1]");

	public RegisterPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
		PageFactory.initElements(driver.get(), this);
	}

	public void register(String email) {
		clickAndWaitByXpath(registerLink);
		setText(emailAddress, email);
		clickAndWaitByXpath(clickRegisterBtn);
		clickAndWaitByXpath(sentOTPCode);

	}

}
