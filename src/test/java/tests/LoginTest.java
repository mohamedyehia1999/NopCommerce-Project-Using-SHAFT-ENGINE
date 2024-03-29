package tests;


import com.shaft.driver.SHAFT;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

@Epic("NopCommerce Project")
@Feature("Home Page")
@Story("Login")
public class LoginTest extends BaseTest
{
    private SHAFT.TestData.JSON logindata;

    @Test(description = "Verify that User Can Login to Website Successfully")
    public void UserCanLoginSuccessfully(){
        HomePage homePage= new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        homePage.ClickOnLoginLink();
        loginPage.EnterLoginInformation(logindata.getTestData("Email"),
                logindata.getTestData("Password")).ValidateOnLoginSuccess();

    }
    @BeforeClass
    public void LoginDataDriven()
    {
        logindata= new SHAFT.TestData.JSON("src/test/resources/testDataFiles/LoginData.json");
    }



}
