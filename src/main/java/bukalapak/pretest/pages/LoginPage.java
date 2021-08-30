package bukalapak.pretest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

	By loginLink = By.xpath("//div[@id='vm__white-header-dweb']/section/header/div[3]/div/div/div[2]/div/a[2]/p");
	By username = By.id("user_session_username");
	By password = By.id("user_session_password");
	By loginBtn = By.name("commit");

	public LoginPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
		PageFactory.initElements(driver.get(), this);
	}

	public void login(String user, String pass) {
		clickAndWaitByXpath(loginLink);
		setText(username, user);
		setText(password, pass);
		clickAndWaitByXpath(loginBtn);

	}

}