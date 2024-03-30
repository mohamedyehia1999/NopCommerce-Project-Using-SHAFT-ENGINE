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
@Story("Add Product To Compare List")
public class AddToCompareListTest extends BaseTest
{
    private SHAFT.TestData.JSON searchdata;
    private SHAFT.TestData.JSON comparelistdata;
    @Test(description = "User Can Add The Product To Compare list")
    public void UserCanAddProductToCompareList(){
        SearchPage searchPage = new SearchPage(driver);
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        CompareListPage compareListPage = new CompareListPage(driver);


        searchPage.SearchForProduct(searchdata.getTestData("SearchItem"));
        searchPage.ClickOnProductDetails();
        productDetailsPage
                .ClickOnAddToCompareListButton()
                .ValidateThatProductIsAddedSuccessfully(comparelistdata.getTestData("SuccessMessage"));

        searchPage.SearchForProduct(searchdata.getTestData("SearchItem2"));
        searchPage.ClickOnProductDetails();
        productDetailsPage
                .ClickOnAddToCompareListButton()
                .ValidateThatProductIsAddedSuccessfully(comparelistdata.getTestData("SuccessMessage"))
                .ClickOnCompareListLink();

        compareListPage
                .ClearProductsFromCompareList()
                .ValidateThatDataIsRemoved(comparelistdata.getTestData("RemovedSuccessMessage"));

    }

    @BeforeClass
    public void WishlistDataDriven()
    {
        searchdata= new SHAFT.TestData.JSON("src/test/resources/testDataFiles/SearchData.json");
        comparelistdata= new SHAFT.TestData.JSON("src/test/resources/testDataFiles/CompareListData.json");
    }
}
