package tests;

import com.shaft.driver.SHAFT;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LogoutTest extends BaseTest
{
    private SHAFT.TestData.JSON logindata;

    @Test(description = "User Can Logout From Website")
    public void UserCanLogoutFromWebsite(){
        HomePage homePage =new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        homePage.ClickOnLoginLink();
        loginPage.EnterLoginInformation(logindata.getTestData("Email"),
                logindata.getTestData("Password")).
                ValidateOnLoginSuccess()
                .ClickOnLogoutButton();
        homePage.ValidateThatTheLogoutIsDoneSuccessfully();
    }
    @BeforeClass
    public void LoginDataDriven()
    {
        logindata= new SHAFT.TestData.JSON("src/test/resources/testDataFiles/LoginData.json");
    }
}
