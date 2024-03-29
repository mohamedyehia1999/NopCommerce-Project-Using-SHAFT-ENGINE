package pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ContactUsPage
{
    private SHAFT.GUI.WebDriver driver;
    private By YourNameField= By.id("FullName");
    private By YourEmailField= By.id("Email");
    private By EnquiryField= By.id("Enquiry");
    private By SubmitBtn= By.cssSelector("button.button-1.contact-us-button");
    private By ContactUsResult= By.cssSelector("div.result");

    public ContactUsPage(SHAFT.GUI.WebDriver driver){
        this.driver=driver;
    }
    @Step("Enter Your Contact Information")
    public ContactUsPage UserCanPutContactInformation(String YourName , String  YourEmail , String Enquiry )
    {
        driver.element()
                .type(YourNameField,YourName)
                .type(YourEmailField,YourEmail)
                .type(EnquiryField,Enquiry)
                .click(SubmitBtn);
        return this;

    }
    @Step("Verify that Your Contact Us Is Submitted Successfully")
    public ContactUsPage ValidateThatYourContactUsIsSubmittedSuccessfully(){
        driver.element().assertThat(ContactUsResult).exists().perform();
        return this;
    }

}
