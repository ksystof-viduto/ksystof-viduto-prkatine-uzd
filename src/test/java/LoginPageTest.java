import org.junit.jupiter.api.Test;
import pageObjects.AccountPage;
import pageObjects.CreateAccountPage;
import pageObjects.LoginPage;
import utils.WaitUtils;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPageTest extends BaseTest {

    CreateAccountPage createAccountPage;

    LoginPage loginPage;

    AccountPage accountPage;

    String invalidPassword = "invalidPass";



    @Test
    void loginUserValid() {
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);
        createAccountPage = new CreateAccountPage(driver);

        loginPage.loginValidUser();

        WaitUtils.waitForDisplayed(driver, accountPage.buttonLogout);

        assertTrue(accountPage.isButtonLogoutDisplayed());
    }

    @Test
    void loginUserInvalid() {
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);
        createAccountPage = new CreateAccountPage(driver);

        createAccountPage.createValidAccount();
        accountPage.clickButtonLogout();

        loginPage.enterInputUsername(createAccountPage.username);
        loginPage.enterInputPassword(invalidPassword);
        loginPage.clickButtonLogin();

        assertTrue(loginPage.isLoginErrorMessageVisible());

    }

}
