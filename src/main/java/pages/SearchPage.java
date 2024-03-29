package pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class SearchPage
{
    private SHAFT.GUI.WebDriver driver;
    private By SearchBoxText= By.id("small-searchterms");
    private By SearchBtn= By.cssSelector("button.button-1.search-box-button");
    private By SearchResult = By.cssSelector("h2.product-title");
    public SearchPage(SHAFT.GUI.WebDriver driver){
        this.driver=driver;
    }

    @Step("Enter product name in search input and click search button")
    public SearchPage SearchForProduct(String ProductName){
        driver.element()
                .type(SearchBoxText,ProductName)
                .click(SearchBtn);
        return this;
    }
    @Step("Verify that search result does match the search item")
    public SearchPage ValidateThatSearchResultISSameAsSearchItem(String ExpectedResult)
    {
       driver.element().assertThat(SearchResult).text().isEqualTo(ExpectedResult).perform();
       return this;

    }
    @Step("Open Product Details Page")
    public SearchPage ClickOnProductDetails()
    {
        driver.element().click(SearchResult);
        return this;
    }


}
