package pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ShoppingCartPage
{
    private SHAFT.GUI.WebDriver driver;
    private By ProductName= By.cssSelector("td.product");
    private By ProductQuantityField= By.cssSelector("input.qty-input");
    private By ProductPrice=By.cssSelector("span.product-subtotal");
    private By RemovedProductBtn= By.cssSelector("td.remove-from-cart");
    private By UpdateShoppingCartBtn= By.id("updatecart");
    private By NoDataFoundInShoppingCart=By.cssSelector("div.no-data");
    private By TermConditionBtn= By.id("termsofservice");
    private By CheckoutBtn=By.id("checkout");


    public ShoppingCartPage(SHAFT.GUI.WebDriver driver){
        this.driver=driver;
    }
    @Step("Verify that the product is exist in shopping cart")
    public ShoppingCartPage ValidateProductFoundInShoppingCart(String ExpectedResult){
        driver.element().assertThat(ProductName).text().isEqualTo(ExpectedResult).perform();
        return this;
    }
    @Step("User Can Update The Product Quantity")
    public ShoppingCartPage UpdateTheProductQuantity(String Quantity)
    {
        driver.element()
                .clear(ProductQuantityField)
                .type(ProductQuantityField,Quantity)
                .click(UpdateShoppingCartBtn);
        return this;

    }
    @Step("Verify That The Product Quantity Is Updated Successfully")
    public ShoppingCartPage ValidateThatTheProductQuantityIsUpdated(String ExpectedResult)
    {
        driver.element().assertThat(ProductPrice).text().contains(ExpectedResult).perform();
        return this;

    }
    @Step("User Can Remove The Product From The Shopping Cart")
    public ShoppingCartPage RemoveProductFromShoppingCart(){
        driver.element().click(RemovedProductBtn);
        return this;
    }
    @Step("Verify that the product is removed from shopping cart successfully ")
    public ShoppingCartPage ValidateThatProductIsRemovedFromShoppingCart(String ExpectedResult){
        driver.element().assertThat(NoDataFoundInShoppingCart).text().isEqualTo(ExpectedResult).perform();
        return this;
    }
    @Step("Click on Checkout Button")
    public ShoppingCartPage OpenCheckoutPage(){
        driver.element()
                .click(TermConditionBtn)
                .click(CheckoutBtn);
        return this;
    }


}
