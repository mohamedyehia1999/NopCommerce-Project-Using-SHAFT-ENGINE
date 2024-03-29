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
@Story("Add Product To Cart")

public class AddToCartTest extends BaseTest
{
    private SHAFT.TestData.JSON logindata;
    private SHAFT.TestData.JSON searchdata;
    private SHAFT.TestData.JSON shoppingdata;
    @Test(description = "User can Add The Product To Cart")
    public void UserCanAddProductToCart(){
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        SearchPage searchPage = new SearchPage(driver);
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);


        homePage.ClickOnLoginLink();
        loginPage.EnterLoginInformation(logindata.getTestData("Email")
                , logindata.getTestData("Password"));

        searchPage.SearchForProduct(searchdata.getTestData("SearchItem"));
        searchPage.ClickOnProductDetails();
        productDetailsPage
                .ClickOnAddToCartButton()
                .ClickOnShoppingCartLink();

        shoppingCartPage
                .ValidateProductFoundInShoppingCart(shoppingdata.getTestData("ProductName"))
                .UpdateTheProductQuantity(shoppingdata.getTestData("Quantity"))
                .ValidateThatTheProductQuantityIsUpdated(shoppingdata.getTestData("TotalPrice"))
                .RemoveProductFromShoppingCart()
                .ValidateThatProductIsRemovedFromShoppingCart(shoppingdata.getTestData("RemovedSuccessMessage"));


    }

    @BeforeClass
    public void WishlistDataDriven()
    {
        logindata= new SHAFT.TestData.JSON("src/test/resources/testDataFiles/LoginData.json");
        searchdata= new SHAFT.TestData.JSON("src/test/resources/testDataFiles/SearchData.json");
        shoppingdata= new SHAFT.TestData.JSON("src/test/resources/testDataFiles/ShoppingCartData.json");
    }
}
