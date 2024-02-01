package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.DataGenerator;

public class CreateAccountPage extends BasePage {

    @FindBy(id = "username")
    WebElement inputUsername;

    @FindBy(id = "password")
    WebElement inputPassword;

    @FindBy(id = "passwordConfirm")
    WebElement inputPasswordConfirm;

    @FindBy(className = "btn-primary")
    WebElement buttonCreateAccount;

    @FindBy(id = "username.errors")
    WebElement errorUsername;

    @FindBy(id = "passwordConfirm.errors")
    WebElement errorPassword;

    CreateAccountPage createAccountPage;


    LoginPage loginPage;

    AccountPage accountPage;

    public String username = DataGenerator.getRandomUsername();

    public String password = DataGenerator.getRandomPassword();


    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    public void createValidAccount() {
        createAccountPage = new CreateAccountPage(driver);
        loginPage = new LoginPage(driver);

        loginPage.clickButtonCreateAccount();

        createAccountPage.enterInputUsername(username);
        createAccountPage.enterInputPassword(password);
        createAccountPage.enterInputPasswordConfirm(password);
        createAccountPage.clickButtonCreateAccount();
    }

    public void enterInputUsername(String username) {
        inputUsername.sendKeys(username);
    }

    public void enterInputPassword(String password) {
        inputPassword.sendKeys(password);
    }

    public void enterInputPasswordConfirm(String password) {
        inputPasswordConfirm.sendKeys(password);
    }

    public void clickButtonCreateAccount() {
        buttonCreateAccount.click();
    }

    public boolean isUsernameErrorDisplayed() {
        return errorUsername.isDisplayed();
    }

    public boolean isPasswordErrorDisplayed() {
        return errorPassword.isDisplayed();
    }
}
