package pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class RegistrationPage
{
    private SHAFT.GUI.WebDriver driver;
    private By gendermale= By.id("gender-male");
    private By firstname= By.id("FirstName");
    private By lastname= By.id("LastName");
    private By dateofbirthday= By.xpath("//*[@name='DateOfBirthDay']");
    private By monthofbirthday= By.xpath("//*[@name='DateOfBirthMonth']");
    private By yearofbirthday= By.xpath("//*[@name='DateOfBirthYear']");
    private By email= By.id("Email");
    private By password= By.id("Password");
    private By confirmapassword= By.id("ConfirmPassword");
    private By registerbtn=By.id("register-button");
    private By result=By.className("result");

    public RegistrationPage(SHAFT.GUI.WebDriver driver){
        this.driver=driver;
    }
    @Step("Enter Register Information")
    public RegistrationPage EnterRegisterInformation(String FirstName , String LastName , String day , String month , String year ,String Email , String Password , String ConfirmPassword)
    {
        driver.element().click(gendermale)
                .type(firstname , FirstName)
                .type(lastname,LastName)
                .select(dateofbirthday,day)
                .select(monthofbirthday,month)
                .select(yearofbirthday,year)
                .type(email,Email)
                .type(password,Password)
                .type(confirmapassword,ConfirmPassword)
                .click(registerbtn);
        return this;

    }
    @Step("Validate on Account Created")
    public RegistrationPage ValidateOnAccountCreated(String expectedResult){
        driver.element().assertThat(result).text().isEqualTo(expectedResult).perform();
        return this;
    }
}
