package pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ProductDetailsPage
{
    SHAFT.GUI.WebDriver driver;
    private By AddToCartBtn= By.id("add-to-cart-button-4");
    private By AddToWishlistBtn= By.id("add-to-wishlist-button-4");
    private By AddToCompareListBtn= By.xpath("//*[@class='compare-products']");
    private By AddYourReviewLink=By.linkText("Add your review");
    private By EmailAFriendBtn=By.cssSelector("button.button-2.email-a-friend-button");
    private By WishlistLink=By.linkText("wishlist");
    private By CompareListLink= By.linkText("product comparison");
    private By AddToCompareSuccessMessage= By.cssSelector("p.content");
    private By ShoppingCartLink= By.linkText("shopping cart");


    public ProductDetailsPage(SHAFT.GUI.WebDriver driver){
        this.driver=driver;
    }
    @Step("Click On Add Your Review Link")
    public ProductDetailsPage ClickOnReviewLink(){
        driver.element().click(AddYourReviewLink);
        return this;
    }
    @Step("Click On Email A Friend")
    public ProductDetailsPage ClickOnEmailAFriendButton(){
        driver.element().click(EmailAFriendBtn);
        return this;
    }
    @Step("Click On Add To Wishlist")
    public ProductDetailsPage ClickOnAddToWishlistButton(){
        driver.element().click(AddToWishlistBtn);
        return this;
    }
    @Step("Click On Add To Compare List")
    public ProductDetailsPage ClickOnAddToCompareListButton(){
        driver.element().click(AddToCompareListBtn);
        return this;
    }
    @Step("Click On Wishlist Link")
    public ProductDetailsPage ClickOnWishlistLink(){
        driver.element().click(WishlistLink);
        return this;
    }
    @Step("Click On Compare List Link")
    public ProductDetailsPage ClickOnCompareListLink(){
        driver.element().click(CompareListLink);
        return this;
    }
    @Step("Click On Add To Cart")
    public ProductDetailsPage ClickOnAddToCartButton(){
        driver.element().click(AddToCartBtn);
        return this;
    }
    @Step("Click On Shopping Cart Link")
    public ProductDetailsPage ClickOnShoppingCartLink(){
        driver.element().click(ShoppingCartLink);
        return this;
    }
    @Step("Verify That The Product Is Added To Compare List Successfully")
    public ProductDetailsPage ValidateThatProductIsAddedSuccessfully(String ExpectedResult){
        driver.element().assertThat(AddToCompareSuccessMessage).text().contains(ExpectedResult).perform();
        return this;
    }
}
