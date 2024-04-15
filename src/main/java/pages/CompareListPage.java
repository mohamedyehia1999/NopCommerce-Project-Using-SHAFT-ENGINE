package pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class CompareListPage
{
    private SHAFT.GUI.WebDriver driver;
    private By ClearListBtn= By.cssSelector("a.clear-list");
    private By ProductNameRow=By.cssSelector("tr.product-name");
    private By ProductCpu=By.cssSelector("tr.specification");
    private By NoDataFoundInCompareList= By.cssSelector("div.no-data");
    public CompareListPage(SHAFT.GUI.WebDriver driver){
        this.driver=driver;
    }
    @Step("Clear the product from the compare list")
    public CompareListPage ClearProductsFromCompareList(){
        driver.element().click(ClearListBtn);
        return this;
    }
    @Step("Verify that the product is removed successfully from the compare list ")
    public CompareListPage ValidateThatDataIsRemoved(String ExpectedResult){
        driver.element()
                .assertThat(NoDataFoundInCompareList)
                .text().isEqualTo(ExpectedResult).perform();
        return this;
    }

}
