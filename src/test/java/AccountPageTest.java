import org.junit.jupiter.api.Test;
import pageObjects.AccountPage;
import pageObjects.CreateAccountPage;
import pageObjects.LoginPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccountPageTest extends BaseTest {

    CreateAccountPage createAccountPage;

    LoginPage loginPage;

    AccountPage accountPage;

    @Test
    void logout() {
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);
        createAccountPage = new CreateAccountPage(driver);

        loginPage.loginValidUser();

        accountPage.clickButtonLogout();

        assertTrue(loginPage.isLogoutSuccessful());
    }


}
