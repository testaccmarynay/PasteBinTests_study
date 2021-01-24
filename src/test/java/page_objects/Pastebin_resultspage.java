package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.lang.model.element.Element;

public class Pastebin_resultspage {
    public WebDriver driver;
    public Pastebin_resultspage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //title
    @FindBy(xpath = "//*[contains(@class, 'info-top')]/h1")
    private WebElement title;

    //code element
    @FindBy(xpath = "//*[contains(@class, 'source')]//span[contains(text(), 'git config')]")
    private WebElement codeElement;

    // whole code
    @FindBy(xpath = "//*[@class='textarea']")
    private WebElement wholeCode;

    // methods
    // getting title for comparison
    public String getTitleText() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'info-top')]/h1")));
        String titleName = title.getText();
        return titleName;
    }

    //getting css of 'git config'
    public String getCssColor() {
        String CssColor = codeElement.getCssValue("color");
        return CssColor;
   }

    // getting whole text(code) for comparison
    public String getWholeCode() {
        String wCode = wholeCode.getText();
        return wCode;
    }
}
