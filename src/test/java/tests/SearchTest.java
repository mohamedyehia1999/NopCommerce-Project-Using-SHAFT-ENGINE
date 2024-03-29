package tests;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.SearchPage;

@Epic("Demo Ecommerce Project")
@Feature("Search For Product")
@Story("User Can Make search For Product")
public class SearchTest extends BaseTest
{
    private SHAFT.TestData.JSON searchdata;

    @Test(description = "User Can make Search For Product Successfully")
    public void UserCanSearchForProductSuccessfully(){
    SearchPage searchPage = new SearchPage(driver);
    searchPage.SearchForProduct(searchdata.getTestData("SearchItem"));
    searchPage.ValidateThatSearchResultISSameAsSearchItem(searchdata.getTestData("SearchItem"));
}
    @BeforeClass
    public void SearchDataDriven()
    {
        searchdata= new SHAFT.TestData.JSON("src/test/resources/testDataFiles/SearchData.json");
    }
}
