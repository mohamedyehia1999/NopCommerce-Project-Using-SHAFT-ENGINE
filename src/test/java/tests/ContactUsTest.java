package tests;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;

@Epic("NopCommerce Project")
@Feature("Home Page")
@Story("Contact Us")
public class ContactUsTest extends  BaseTest
{
    private SHAFT.TestData.JSON contactUsdata;
    @Test(description = "User Can Add Your Contact Us Information Successfully")
    public void UserCanAddYourContactUsInformationSuccessfully(){
        HomePage homePage = new HomePage(driver);
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        homePage.ClickOnContactUsLink();
        contactUsPage.UserCanPutContactInformation(contactUsdata.getTestData("YourName")
                , contactUsdata.getTestData("YourEmail")
                , contactUsdata.getTestData("Enquiry") );
        contactUsPage.ValidateThatYourContactUsIsSubmittedSuccessfully();
    }
    @BeforeClass
    public void ReviewDataDriven() {
        contactUsdata = new SHAFT.TestData.JSON("src/test/resources/testDataFiles/ContactUsData.json");
    }
}
