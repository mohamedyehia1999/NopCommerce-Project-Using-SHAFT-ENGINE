package tests;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;
@Epic("NopCommerce Project")
@Feature("Cart Module")
@Story("Checkout the product")
public class CheckoutTest extends BaseTest
{
    private SHAFT.TestData.JSON logindata;
    private SHAFT.TestData.JSON searchdata;
    private SHAFT.TestData.JSON checkoutdata;


@Test(description = "User Can Checkout the product and complete the payment method successfully")
    public void UserCanPayTheProductSuccessfully(){
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        SearchPage searchPage = new SearchPage(driver);
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        OrderInformationDetailsPage orderInformationDetailsPage = new OrderInformationDetailsPage(driver);


        homePage.ClickOnLoginLink();
        loginPage.EnterLoginInformation(logindata.getTestData("Email")
                , logindata.getTestData("Password"));

        searchPage.SearchForProduct(searchdata.getTestData("SearchItem"));
        searchPage.ClickOnProductDetails();
        productDetailsPage
                .ClickOnAddToCartButton()
                .ClickOnShoppingCartLink();

        shoppingCartPage.OpenCheckoutPage();
        checkoutPage.EnterBillingAddressInformation(checkoutdata.getTestData("Company")
                ,checkoutdata.getTestData("Country")
                ,checkoutdata.getTestData("City")
                , checkoutdata.getTestData("Address1")
                , checkoutdata.getTestData("Address2")
                , checkoutdata.getTestData("PostalCode")
                , checkoutdata.getTestData("PhoneNumber")
                , checkoutdata.getTestData("FaxNumber") );

        checkoutPage
                .ShoppingMethodSelection()
                .Payment()
                .ValidateThatOrderIsSuccessfullyProcessed(checkoutdata.getTestData("ConfirmationMessage"))
                .OpenOrderDetailsPae();

        orderInformationDetailsPage
                .PrintTheOrder()
                .ClickOnPDF();


    }

    @BeforeClass
    public void WishlistDataDriven()
    {
        logindata= new SHAFT.TestData.JSON("src/test/resources/testDataFiles/LoginData.json");
        searchdata= new SHAFT.TestData.JSON("src/test/resources/testDataFiles/SearchData.json");
        checkoutdata= new SHAFT.TestData.JSON("src/test/resources/testDataFiles/CheckoutData.json");
    }
}
