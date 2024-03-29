package tests;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
@Epic("Demo Ecommerce Project")
@Feature("My Account - Change Password")
@Story("User Can Change Password ")
public class MyAccountTest extends BaseTest
{
    private SHAFT.TestData.JSON logindata;
    private SHAFT.TestData.JSON changePassData;

    @Test(description = "Verify that User Can Change Password Successfully")
    public void UserCanChangePasswordSuccessfully()
    {
        HomePage homePage =new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        homePage.ClickOnLoginLink();
        loginPage.EnterLoginInformation(logindata.getTestData("Email"),logindata.getTestData("Password"));
        loginPage.ClickOnMyAccountLink();
        myAccountPage.EnterChangePasswordInformation(changePassData.getTestData("OldPassword")
                ,changePassData.getTestData("NewPassword"),changePassData.getTestData("NewPassword") );

        myAccountPage.ValidateOnChangePasswordSuccess();

    }
    @BeforeClass
    public void MyAccountDataDriven()
    {
        logindata= new SHAFT.TestData.JSON("src/test/resources/testDataFiles/LoginData.json");
        changePassData= new SHAFT.TestData.JSON("src/test/resources/testDataFiles/MyAccountChangePasswordData.json");
    }
}
