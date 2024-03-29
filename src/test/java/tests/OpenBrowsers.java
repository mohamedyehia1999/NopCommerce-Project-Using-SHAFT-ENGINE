package tests;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class OpenBrowsers
{
    SHAFT.GUI.WebDriver driver;
    @Test
    public void OpenChromeDriver(){
        driver= new SHAFT.GUI.WebDriver();
        driver.browser().navigateToURL("https://www.google.com/");
        By textarea=By.className("gLFyf");
        driver.element().type(textarea,"selenium");
    }
}
