package pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ReviewPage
{
    private SHAFT.GUI.WebDriver driver;
    private By ReviewTitleField= By.id("AddProductReview_Title");
    private By ReviewTextField= By.id("AddProductReview_ReviewText");
    private By RatingRatio=By.id("addproductrating_4");
    private By SubmitReviewBtn=By.cssSelector("button.button-1.write-product-review-button");
    private By ProductReviewResult=By.cssSelector("div.result");
    public ReviewPage(SHAFT.GUI.WebDriver driver){
        this.driver=driver;
    }
    @Step("User Can Add Your Review On Product")
    public void UserCanAddYourReview(String ReviewTitle , String ReviewText )
    {
        driver.element()
                .type(ReviewTitleField ,ReviewTitle)
                .type(ReviewTextField,ReviewText)
                .click(RatingRatio)
                .click(SubmitReviewBtn);
    }
    @Step("Verify That The Product Review Is Add Successfully")
    public ReviewPage ValidateThatReviewIsAddSuccessfully(){
        driver.element().assertThat(ProductReviewResult).isEnabled().perform();
        return this;
    }

}
