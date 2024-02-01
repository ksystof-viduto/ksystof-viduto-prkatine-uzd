package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage {

    @FindBy(partialLinkText = "Logout")
    public WebElement buttonLogout;

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public void clickButtonLogout() {
        buttonLogout.click();
    }

    public boolean isButtonLogoutDisplayed() {
        return buttonLogout.isDisplayed();
    }
}
