package pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class CheckoutPage
{
    private SHAFT.GUI.WebDriver driver;
    private By CompanyNameField= By.id("BillingNewAddress_Company");
    private By CountryNameField=By.id("BillingNewAddress_CountryId");

    private By CityNameField= By.id("BillingNewAddress_City");
    private By Address1Field=By.id("BillingNewAddress_Address1");
    private By Address2Field=By.id("BillingNewAddress_Address2");
    private By PostalCodeField= By.id("BillingNewAddress_ZipPostalCode");
    private By PhoneNumberField= By.id("BillingNewAddress_PhoneNumber");
    private By FaxNumberField= By.id("BillingNewAddress_FaxNumber");
    private By BillingContinueBtn=By.id("billing-buttons-container");
    private By NextDayAirOption=By.id("shippingoption_1");
    private By ShippingContinueBtn=By.cssSelector("button.button-1.shipping-method-next-step-button");
    private By PaymentContinueBtn=By.cssSelector("button.button-1.payment-method-next-step-button");
    private By PaymentInformationContinueBtn=By.cssSelector("button.button-1.payment-info-next-step-button");
    private By ConfirmOrderBtn=By.cssSelector("button.button-1.confirm-order-next-step-button");
    private By SuccessConfirm=By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div/div[1]/strong");
    private By OrderDetailsLink= By.linkText("Click here for order details.");
    private By CompleteContinueBtn=By.cssSelector("button.button-1.order-completed-continue-button");
    public CheckoutPage(SHAFT.GUI.WebDriver driver){
        this.driver=driver;
    }
    @Step("Enter Billing Information")
    public CheckoutPage EnterBillingAddressInformation( String CompanyName,String CountryName , String CityName , String Address1 , String Address2 , String PostalCode , String PhoneNumber , String FaxNumber)
    {
        driver.element().type(CompanyNameField,CompanyName)
                .select(CountryNameField,CountryName)
                .type(CityNameField,CityName)
                .type(Address1Field,Address1)
                .type(Address2Field,Address2)
                .type(PostalCodeField,PostalCode)
                .type(PhoneNumberField,PhoneNumber)
                .type(FaxNumberField,FaxNumber)
                .click(BillingContinueBtn);
        return this;

    }
    @Step("Select the Shopping Method")
    public CheckoutPage ShoppingMethodSelection(){
        driver.element().
                click(NextDayAirOption)
                .click(ShippingContinueBtn);
        return this;
    }
    @Step("Select Payment Method")
    public CheckoutPage Payment(){
        driver.element()
                .click(PaymentContinueBtn)
                .click(PaymentInformationContinueBtn)
                .click(ConfirmOrderBtn);
        return this;
    }
    @Step("Verify that the order is successfully processed")
    public CheckoutPage ValidateThatOrderIsSuccessfullyProcessed(String ExpectedResult){
        driver.element().assertThat(SuccessConfirm).text().isEqualTo(ExpectedResult).perform();
        return this;
    }
    @Step("Click on order details link")
    public CheckoutPage OpenOrderDetailsPae(){
        driver.element().click(OrderDetailsLink);
        return this;
    }

}
