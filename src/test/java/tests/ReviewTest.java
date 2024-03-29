package tests;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

@Epic("Demo Ecommerce Project")
@Feature("Product Details")
@Story("Add Your Review")
public class ReviewTest extends BaseTest
{
    private  SHAFT.TestData.JSON logindata;
    private SHAFT.TestData.JSON searchdata;
    private SHAFT.TestData.JSON reviewdata;


    @Test(description = "User can Add Your Review On Product")
    public void UserCanAddYourReviewOnProductItem(){
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        SearchPage searchPage = new SearchPage(driver);
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        ReviewPage reviewPage = new ReviewPage(driver);

        homePage.ClickOnLoginLink();
        loginPage.EnterLoginInformation(logindata.getTestData("Email")
                , logindata.getTestData("Password"));

        searchPage.SearchForProduct(searchdata.getTestData("SearchItem"));
        searchPage.ClickOnProductDetails();
        productDetailsPage.ClickOnReviewLink();

        reviewPage.UserCanAddYourReview(reviewdata.getTestData("ReviewTitle")
                , reviewdata.getTestData("ReviewText"));
        reviewPage.ValidateThatReviewIsAddSuccessfully();
    }
    @BeforeClass
    public void ReviewDataDriven()
    {
        logindata= new SHAFT.TestData.JSON("src/test/resources/testDataFiles/LoginData.json");
        searchdata= new SHAFT.TestData.JSON("src/test/resources/testDataFiles/SearchData.json");
        reviewdata= new SHAFT.TestData.JSON("src/test/resources/testDataFiles/ReviewData.json");
    }
}
