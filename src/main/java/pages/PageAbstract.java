package pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Log;

public abstract class PageAbstract {
    @Getter
    protected String URL;

    @Getter
    protected String pageName;

    @Getter
    private final WebDriver driver;

    @Getter
    protected String pageTitle;

    /**
     * Constructor
     */
    PageAbstract(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Checks if page is loaded by comparing the expected page-title with an actual page-title.
     **/
    public boolean isPageLoad(){
        return (this.getDriver().getTitle().contains(pageTitle));
    }

    /**
     * Open the default url of a page
     * @param driverWait
     */
    public void open(WebDriverWait driverWait){
        this.getDriver().get(URL);
        driverWait.until(ExpectedConditions.titleIs(getPageTitle()));
        Log.pageLoaded(this);
    }

    String getPageSource() {
        return this.getDriver().getPageSource();
    }

    /**
     * Send text keys to the element that finds by cssSelector.
     * It shortens "driver.findElement(By.cssSelector()).sendKeys()".
     * @param cssSelector
     * @param text
     */
    public void sendTextByCSS(String cssSelector, String text) {
        this.getDriver().findElement(By.cssSelector(cssSelector)).sendKeys(text);
    }

    void sendTextById(String textId, String text) {
        this.getDriver().findElement(By.id(textId)).sendKeys(text);
    }

    /**
     * Is the text present in page.
     * @param text
     */
    public boolean isTextPresent(String text){
        return this.getDriver().getPageSource().contains(text);
    }

    /**
     * Is the Element in the page.
     * @param by
     */
    public boolean isElementPresent(By by) {
        try {
            this.getDriver().findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Is the Element present in the DOM.
     * @param _cssSelector 		element locator
     */
    public boolean isElementPresent(String _cssSelector){
        try {
            this.getDriver().findElement(By.cssSelector(_cssSelector));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Checks if the element is in the DOM and displayed.
     * @param by - selector to find the element
     */
    public boolean isElementPresentAndDisplay(By by) {
        try {
            return this.getDriver().findElement(by).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
