package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Pastebin_startpage {
    public WebDriver driver;
    public Pastebin_startpage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    // paste text field
    @FindBy(id = "postform-text")
    public WebElement textField;

    // expiration dropdown
    @FindBy(id = "select2-postform-expiration-container")
    public WebElement expirationDrp;

    // selecting expiration - 10
    @FindBy(xpath = "//*[contains(@class, 'select2-results__options')]/li[contains(text(), '10 Minutes')]")
    public WebElement expirationValue10;

    // highlighting dropdown
    @FindBy(id = "select2-postform-format-container")
    public WebElement highlightDrp;

    // select Highlighting - Bash
    @FindBy(xpath = "//*[contains(@class, 'select2-results__options')]//li[contains(text(), 'Bash')]")
    public WebElement bashHighlighting;

    // paste title field
    @FindBy(id = "postform-name")
    public WebElement pasteTitle;

    // creating paste
    @FindBy(xpath = "//*[@class='btn -big']")
    public WebElement createPasteBtn;

    // methods
    // entering code or text
    public void enterText1(String text) {
        textField.sendKeys(text);
    }

    // entering paste name / title
    public void putPasteName(String name) {
        pasteTitle.sendKeys(name);
    }

    // creating new paste method
    public void clickCreateBtn() {
        createPasteBtn.click();
    }

    public void highlightDrpClick () {
        WebDriverWait wait1 = new WebDriverWait(driver, 5);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("select2-postform-format-container")));
        highlightDrp.click();
    }

    public void bashClick () {
        WebDriverWait wait1 = new WebDriverWait(driver, 5);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'select2-results__options select2-results__options--nested')]/li[contains(text(), 'Bash')]")));
        bashHighlighting.click();
    }


}
