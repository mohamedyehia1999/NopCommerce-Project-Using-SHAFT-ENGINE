package tests;

import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest
{
    protected SHAFT.GUI.WebDriver driver;
    @BeforeClass
    public void SetUp(){
        driver= new SHAFT.GUI.WebDriver();
        driver.browser().navigateToURL("https://demo.nopcommerce.com/");
    }

    @AfterClass
    public void teardown(){driver.quit();
    }
}
