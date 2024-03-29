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
@Story("Add Product To Wishlist")

public class AddToWishlistTest extends BaseTest
{
    private SHAFT.TestData.JSON searchdata;
    private SHAFT.TestData.JSON wishlistdata;
    @Test(description = "User Can Add The Product To Wishlist")
    public void UserCanAddProductToWishlist(){
      SearchPage searchPage = new SearchPage(driver);
      ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
      AddToWishlistPage addToWishlistPage = new AddToWishlistPage(driver);

        searchPage.SearchForProduct(searchdata.getTestData("SearchItem"));
        searchPage.ClickOnProductDetails();
        productDetailsPage
                .ClickOnAddToWishlistButton()
                .ClickOnWishlistLink();


        addToWishlistPage
                .ValidateProductIsExistInWishlist(wishlistdata.getTestData("ProductNameExist"))
                .RemoveProductFromWishlist()
                .ValidateProductIsRemovedFromWishlist(wishlistdata.getTestData("WishlistEmptyMessage"));

    }

    @BeforeClass
    public void WishlistDataDriven()
    {
        searchdata= new SHAFT.TestData.JSON("src/test/resources/testDataFiles/SearchData.json");
        wishlistdata= new SHAFT.TestData.JSON("src/test/resources/testDataFiles/AddToWishlistData.json");
    }
}
