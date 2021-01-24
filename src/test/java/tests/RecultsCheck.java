package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page_objects.Pastebin_resultspage;
import page_objects.Pastebin_startpage;

// this is a class for checking the results assertion work correctly without logging in.
// it will refer to the page with paste created and valid till July, 24th.
// all the parameters for this mok paste are the same as in the task 'Bring it On', except Paste Expiration.
// Paste Expiration was changed from '10 Minutes' to '6 Months' in order to be able to check the assertions

public class RecultsCheck {
    public static page_objects.Pastebin_startpage Pastebin_startpage;
    public static page_objects.Pastebin_resultspage Pastebin_resultspage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        driver = new ChromeDriver();
        Pastebin_startpage = new Pastebin_startpage(driver);
        Pastebin_resultspage = new Pastebin_resultspage(driver);
        driver.manage().window().maximize();
        driver.get(ConfProperties.getProperty("pasteBinResultsPage"));
    }
    @Test
    public void AssertValues () {
        String titleR = Pastebin_resultspage.getTitleText();
        Assert.assertEquals(ConfProperties.getProperty("name2"), titleR);

        String textR = Pastebin_resultspage.getWholeCode();
        Assert.assertEquals(ConfProperties.getProperty("text2"), textR);

        String colorR = Pastebin_resultspage.getCssColor();
        Assert.assertEquals(ConfProperties.getProperty("titleCssValue"), colorR);
    }
}
