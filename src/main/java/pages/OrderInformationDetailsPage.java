package pages;

import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class OrderInformationDetailsPage
{
    private SHAFT.GUI.WebDriver driver;
    private By PrintBtn=By.cssSelector("a.button-2.print-order-button");
    private By PDFInvoiceBtn=By.cssSelector("a.button-2.pdf-invoice-button");

    public OrderInformationDetailsPage(SHAFT.GUI.WebDriver driver){
        this.driver=driver;
    }
    @Step("Click on the Print button")
    public OrderInformationDetailsPage PrintTheOrder(){
        driver.element().click(PrintBtn);
        return this;
    }
    @Step("Click on the PDF Invoice Button")
    public OrderInformationDetailsPage ClickOnPDF(){

        driver.element().click(PDFInvoiceBtn);
        return this;
        
    }
  
}
