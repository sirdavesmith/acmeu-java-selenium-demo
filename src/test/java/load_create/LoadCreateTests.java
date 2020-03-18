package load_create;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import static org.testng.Assert.fail;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

public class LoadCreateTests {
    private WebDriver driver;
    private String startingUrl;
    private String titlePage;
    private String pageSource;
    private String username;
    private String password;
    private int studentId;
    private StringBuffer verificationErrors = new StringBuffer();

    @Test
    public void testTermBreakAsStudent () throws Exception {
        studentSetUp();
        String url = "https://.acmeu.edu/my-degreeplan";
        titlePage = "My ACMEU Student Portal";
        termBreakTest(url, titlePage);
        WebElement parentFrame = driver.findElement(By.id("_ACMEU_IFrame_Portlet_INSTANCE_aTC3_iframe"));
        driver.switchTo().frame(parentFrame);
        pageSource = driver.getPageSource();
        Assert.assertTrue(pageSource.contains(studentTermBreakMessage)); //Positive Case
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    public void studentSetUp () throws Exception {
        username = "malder1";
        password = "student";
        titlePage = "My ACMEU Student Portal";
        login(username, password, titlePage);
    }

    public void login(String username, String password, String titlePage) throws Exception {
        startingUrl = "https://acmeu.edu/portal";
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(startingUrl);
        driver.findElement(By.id("userName")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("loginButton")).click();
        WebDriverWait waitTitlePage = new WebDriverWait(driver, 10);
        waitTitlePage.until(ExpectedConditions.titleIs(titlePage));
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains(titlePage));
    }

    public void termBreakTest(String url, String titlePage) throws Exception {
        driver.get(url);
        WebDriverWait waitTitlePage = new WebDriverWait(driver, 10);
        waitTitlePage.until(ExpectedConditions.titleIs(titlePage));
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains(titlePage));
    }
}
