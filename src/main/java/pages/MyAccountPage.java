package pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class MyAccountPage {
    private SHAFT.GUI.WebDriver driver;
    private By ChangePasswordLink = By.linkText("Change password");
    private By OldPasswordField = By.id("OldPassword");
    private By NewPasswordField = By.id("NewPassword");
    private By ConfirmNewPasswordField = By.id("ConfirmNewPassword");
    private By ChangePasswordBtn = By.cssSelector("button.button-1.change-password-button");
    private By NotificationSuccess=By.cssSelector("div.bar-notification.success");

    public MyAccountPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    @Step("Enter Change Password Information")
    public MyAccountPage EnterChangePasswordInformation(String OldPassword, String NewPassword, String ConfirmNewPassword)
    {
        driver.element()
                .click(ChangePasswordLink)
                .type(OldPasswordField,OldPassword)
                .type(NewPasswordField,NewPassword)
                .type(ConfirmNewPasswordField,ConfirmNewPassword)
                .click(ChangePasswordBtn);
        return this;
    }
    @Step("Validate Password Is Changed Successfully")
    public MyAccountPage ValidateOnChangePasswordSuccess()
    {
        String NotificationSuccessMessage=driver.element().getText(NotificationSuccess);
        driver.element().assertThat(NotificationSuccess).text().isEqualTo(NotificationSuccessMessage);
        return this;
    }

}