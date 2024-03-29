package tests;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

@Epic("NopCommerce Project")
@Feature("Product Details")
@Story("Email A Friend")
public class EmailFriendTest extends BaseTest
{
    private  SHAFT.TestData.JSON logindata;
    private SHAFT.TestData.JSON searchdata;
    private SHAFT.TestData.JSON emaildata;
    @Test(description = "User can Send Message For Email A Friend")
    public void UserCanSendMessageForEmailAFriend(){
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        SearchPage searchPage = new SearchPage(driver);
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
       EmailFriendPage emailFriendPage = new EmailFriendPage(driver);

        homePage.ClickOnLoginLink();
        loginPage.EnterLoginInformation(logindata.getTestData("Email")
                , logindata.getTestData("Password"));

        searchPage.SearchForProduct(searchdata.getTestData("SearchItem"));
        searchPage.ClickOnProductDetails();
        productDetailsPage.ClickOnEmailAFriendButton();

        emailFriendPage.UserCanSendMessageForFriendEmail(emaildata.getTestData("FriendEmail")
                , emaildata.getTestData("PersonalMessage"));
        emailFriendPage.ValidateThatMessageIsSentSuccessfully();

    }
    @BeforeClass
    public void ReviewDataDriven()
    {
        logindata= new SHAFT.TestData.JSON("src/test/resources/testDataFiles/LoginData.json");
        searchdata= new SHAFT.TestData.JSON("src/test/resources/testDataFiles/SearchData.json");
        emaildata= new SHAFT.TestData.JSON("src/test/resources/testDataFiles/EmailAFriendData.json");
    }

}
