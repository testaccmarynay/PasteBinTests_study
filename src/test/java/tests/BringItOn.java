package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page_objects.Pastebin_resultspage;
import page_objects.Pastebin_startpage;

import java.util.List;

public class BringItOn {
    public static Pastebin_startpage Pastebin_startpage;
    public static Pastebin_resultspage Pastebin_resultspage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        driver = new ChromeDriver();
        Pastebin_startpage = new Pastebin_startpage(driver);
        Pastebin_resultspage = new Pastebin_resultspage(driver);
        driver.manage().window().maximize();
        driver.get(ConfProperties.getProperty("pasteBinHomePage"));
    }

    @Test
    public void EnterValuesAndTest () {
        Pastebin_startpage.enterText1(ConfProperties.getProperty("text2"));
        Pastebin_startpage.highlightDrpClick();
        Pastebin_startpage.bashClick();
        Pastebin_startpage.expirationDrp.click();
        Pastebin_startpage.expirationValue10.click();
        Pastebin_startpage.putPasteName(ConfProperties.getProperty("name2"));
        Pastebin_startpage.clickCreateBtn();

        // checking the results
        String titleR = Pastebin_resultspage.getTitleText();
        Assert.assertEquals(ConfProperties.getProperty("name2"), titleR);

        String textR = Pastebin_resultspage.getWholeCode();
        Assert.assertEquals(ConfProperties.getProperty("text2"), textR);

        String colorR = Pastebin_resultspage.getCssColor();
        Assert.assertEquals(ConfProperties.getProperty("titleCssValue"), colorR);
    }
    @AfterClass
    public static void shutDown() {
        driver.quit();
    }

}