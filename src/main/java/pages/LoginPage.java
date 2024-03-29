package pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LoginPage {
    private SHAFT.GUI.WebDriver driver;

    private By email_login = By.id("Email");
    private By password_login = By.id("Password");
    private By loginbtn = By.cssSelector("button.button-1.login-button");
    private By MyAccountLink=By.className("ico-account");
    private By LogoutBtn= By.cssSelector("a.ico-logout");




    public LoginPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    @Step("Enter Login Information")
    public LoginPage EnterLoginInformation(String Email, String Password)
    {
        driver.element()
                .type(email_login,Email)
                .type(password_login,Password)
                .click(loginbtn);
        return this;
    }
    @Step("Validate on User Login Successfully")
    public LoginPage ValidateOnLoginSuccess(){
        driver.element().assertThat(MyAccountLink).exists().perform();
        return this;
    }
    @Step("Click on My Account Link")
    public LoginPage ClickOnMyAccountLink(){
        driver.element().click(MyAccountLink);
        return this;
    }
    @Step("Click on Logout button")
    public LoginPage ClickOnLogoutButton(){
        driver.element().click(LogoutBtn);
        return this;
    }

}
