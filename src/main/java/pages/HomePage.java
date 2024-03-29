package pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class HomePage {
    private SHAFT.GUI.WebDriver driver;
    private By RegisterLink = By.className("ico-register");
    private By LoginLink = By.className("ico-login");
    private By ContactUsLink=By.linkText("Contact us");

    public HomePage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;

    }
    @Step("Click on Register Link")
    public HomePage ClickOnRegisterLink(){
        driver.element().click(RegisterLink);
        return this;
    }
    @Step("Click on Login Link")
    public HomePage ClickOnLoginLink(){
        driver.element().click(LoginLink);
        return this;
    }
    @Step("Click on Contact Us")
    public HomePage ClickOnContactUsLink(){
        driver.element().click(ContactUsLink);
        return this;
    }
    @Step("Verify That The Login Link Is Exist")
    public HomePage ValidateThatTheLogoutIsDoneSuccessfully(){
        driver.element().assertThat(LoginLink).exists().perform();
        return this;
    }
}
