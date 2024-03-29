package pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class AddToWishlistPage
{
    private SHAFT.GUI.WebDriver driver;
    private By UpdateCartBtn= By.id("updatecart");
    private By RemoveFromCartBtn= By.cssSelector("td.remove-from-cart");
    private By ProductInWishlistName= By.cssSelector("td.product");
    private By NoDataFoundInWishlist=By.cssSelector("div.no-data");
    public AddToWishlistPage(SHAFT.GUI.WebDriver driver){
        this.driver=driver;
    }
    @Step("Verify that the product is exist in wishlist")
    public AddToWishlistPage ValidateProductIsExistInWishlist(String ExpectedResult){
        driver.element().assertThat(ProductInWishlistName).text().isEqualTo(ExpectedResult).perform();
        return this;
    }
    @Step("Remove the product from wishlist")
    public AddToWishlistPage RemoveProductFromWishlist(){
        driver.element().click(RemoveFromCartBtn);
        return this;
    }
    @Step("Verify that the product is removed from wishlist")
    public AddToWishlistPage ValidateProductIsRemovedFromWishlist(String ExpectedResult){
        driver.element().assertThat(NoDataFoundInWishlist).text().isEqualTo(ExpectedResult).perform();
        return this;
    }


}
