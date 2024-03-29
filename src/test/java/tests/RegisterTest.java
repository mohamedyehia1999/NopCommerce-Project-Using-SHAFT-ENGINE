package tests;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegistrationPage;


@Epic("NopCommerce Project")
@Feature("Home Page")
@Story("Register")
public class RegisterTest extends BaseTest
{
    private SHAFT.TestData.JSON registerdata;


    @Test(description = "Verify that User Can Register to Ecommerce Website Successfully",priority = 1)
    public void UserCanRegisterSuccessfully()
    {
        HomePage homePage = new HomePage(driver);
        RegistrationPage registrationPage=new RegistrationPage(driver);
        homePage.ClickOnRegisterLink();
        registrationPage
                .EnterRegisterInformation(registerdata.getTestData("Firstname"),
                        registerdata.getTestData("Lastname"),
                        registerdata.getTestData("day"),
                        registerdata.getTestData("month"),
                        registerdata.getTestData("year"),
                        registerdata.getTestData("Email"),
                        registerdata.getTestData("Password"),
                        registerdata.getTestData("Password"));

        registrationPage.ValidateOnAccountCreated(registerdata.getTestData("RegisteredSuccessMessage"));
    }
    @BeforeClass
    public void RegisterDataDriven()
    {
        registerdata= new SHAFT.TestData.JSON("src/test/resources/testDataFiles/RegisterData.json");
    }



}
