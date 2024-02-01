import org.junit.jupiter.api.Test;
import pageObjects.AccountPage;
import pageObjects.CreateAccountPage;
import pageObjects.LoginPage;
import utils.DataGenerator;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateAccountPageTest extends BaseTest {
    CreateAccountPage createAccountPage;

    LoginPage loginPage;

    AccountPage accountPage;

    String username = DataGenerator.getRandomUsername();

    String password = DataGenerator.getRandomPassword();

    @Test
    void createAccountValid() {
        createAccountPage = new CreateAccountPage(driver);
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);

        loginPage.clickButtonCreateAccount();

        createAccountPage.enterInputUsername(username);
        createAccountPage.enterInputPassword(password);
        createAccountPage.enterInputPasswordConfirm(password);
        createAccountPage.clickButtonCreateAccount();

        assertTrue(accountPage.buttonLogout.isDisplayed());
    }


    @Test
    void createAccountInvalid() {
        createAccountPage = new CreateAccountPage(driver);
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);

        loginPage.clickButtonCreateAccount();

        createAccountPage.enterInputUsername(username);
        createAccountPage.enterInputPassword(password);
        createAccountPage.enterInputPasswordConfirm("aaa");
        createAccountPage.clickButtonCreateAccount();

        assertTrue(createAccountPage.isPasswordErrorDisplayed());
    }
}
