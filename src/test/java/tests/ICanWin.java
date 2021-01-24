package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import page_objects.Pastebin_startpage;

import java.util.concurrent.TimeUnit;

public class ICanWin {
    public static Pastebin_startpage Pastebin_startpage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        driver = new ChromeDriver();
        Pastebin_startpage = new Pastebin_startpage(driver);
        driver.manage().window().maximize();
        driver.get(ConfProperties.getProperty("pasteBinHomePage"));
    }
    @Test
    public void EnterValues() {
        Pastebin_startpage.enterText1(ConfProperties.getProperty("text1"));
        Pastebin_startpage.expirationDrp.click();
        Pastebin_startpage.expirationValue10.click();
        Pastebin_startpage.putPasteName(ConfProperties.getProperty("name1"));
        Pastebin_startpage.clickCreateBtn();
    }
    //@AfterClass
    //public void shutDown() {
    //    driver.quit(); }
}
