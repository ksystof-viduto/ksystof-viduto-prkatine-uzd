package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.DataGenerator;

public class LoginPage extends BasePage {


    CreateAccountPage createAccountPage;

    LoginPage loginPage;

    AccountPage accountPage;
    @FindBy(linkText = "Sukurti naują paskyrą")
    WebElement buttonCreateAccount;

    @FindBy(name = "username")
    WebElement inputUsername;

    @FindBy(name = "password")
    WebElement inputPassword;

    @FindBy(className = "btn-primary")
    WebElement buttonLogin;

    String logoutMessage = "Sėkmingai atsijungėte";


    String loginErrorMessage = "Įvestas prisijungimo vardas ir/ arba slaptažodis yra neteisingi";

    String username = DataGenerator.getRandomUsername();

    String password = DataGenerator.getRandomPassword();

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void loginValidUser() {
        accountPage = new AccountPage(driver);
        createAccountPage = new CreateAccountPage(driver);
        loginPage = new LoginPage(driver);

        loginPage.clickButtonCreateAccount();

        createAccountPage.enterInputUsername(username);
        createAccountPage.enterInputPassword(password);
        createAccountPage.enterInputPasswordConfirm(password);
        createAccountPage.clickButtonCreateAccount();

        accountPage.clickButtonLogout();

        loginPage.enterInputUsername(username);
        loginPage.enterInputPassword(password);
        loginPage.clickButtonLogin();
    }

    public void enterInputUsername(String username) {
        inputUsername.sendKeys(username);
    }

    public void enterInputPassword(String password) {
        inputPassword.sendKeys(password);
    }

    public void clickButtonLogin() {
        buttonLogin.click();
    }

    public void clickButtonCreateAccount() {
        buttonCreateAccount.click();
    }

    public boolean isLoginErrorMessageVisible() {
        return driver.getPageSource().contains(loginErrorMessage);

    }

    public boolean isLogoutSuccessful() {
        return driver.getPageSource().contains(logoutMessage);
    }

}
