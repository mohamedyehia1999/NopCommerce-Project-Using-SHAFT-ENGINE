package pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class EmailFriendPage
{
   private SHAFT.GUI.WebDriver driver;
   private By FriendEmailField =By.id("FriendEmail");
   private By YourEmailAddressField= By.id("YourEmailAddress");
    private By PersonalMessageField= By.id("PersonalMessage");
    private By SendEmailBtn=By.cssSelector("button.button-1.send-email-a-friend-button");
    private By sendResult= By.cssSelector("div.result");

    public EmailFriendPage(SHAFT.GUI.WebDriver driver){
        this.driver=driver;
    }

    @Step("User Can Send Message For Friend's Email")
    public EmailFriendPage UserCanSendMessageForFriendEmail(String FriendEmail , String PersonalMessage)
    {
        driver.element()
                .type(FriendEmailField,FriendEmail)
                .type(PersonalMessageField,PersonalMessage)
                .click(SendEmailBtn);
        return this;
    }
    @Step("Verify that the message has been sent successfully")
    public EmailFriendPage ValidateThatMessageIsSentSuccessfully(){
        driver.element().assertThat(sendResult).exists().perform();
        return this;
    }
}
