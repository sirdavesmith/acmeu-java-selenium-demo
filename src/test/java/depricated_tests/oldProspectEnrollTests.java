package depricated_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class oldProspectEnrollTests {
    private WebDriver driver;
    private String startingUrl;
    private String titlePage;
    private String mentorProspectEnrollMessage = "When the student begins the Education Without Boundaries Orientation you will access their Degree Plan here";
    private String studentProspectEnrollMessage = "When you begin the Education Without Boundaries Orientation you will access your Degree Plan here";
    private String username;
    private String password;
    private int studentId;
    private StringBuffer verificationErrors = new StringBuffer();

    @Test
    public void testProspectEnrollAsMentor () throws Exception {
        mentorSetUp();
        String url = "https://l1webapp18.acmeu.edu/acmeu/for/" + studentId;
        titlePage = "Western Governors University | Degree Plan";
        prospectEnrollTest(url, titlePage);
        String pageSource = driver.getPageSource();
        Assert.assertTrue(pageSource.contains(mentorProspectEnrollMessage)); //Positive Case
    }

    @Test
    public void testProspectEnrollAsStudent () throws Exception {
        studentSetUp();
        String url = "https://acmeu.edu/group/acmeu-prospective-student-v2/my-degreeplan";
        titlePage = "MyACMEU Student Portal";
        prospectEnrollTest(url, titlePage);
        WebElement parentFrame = driver.findElement(By.id("_ACMEU_IFrame_Portlet_INSTANCE_aTC3_iframe"));
        driver.switchTo().frame(parentFrame);
        String termBreakMessage = driver.findElement(By.id("id7")).getText();
        Assert.assertTrue(termBreakMessage.contains(studentProspectEnrollMessage)); //Positive Case
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    public int mentorSetUp () throws Exception {
        username = "spoltus";
        password = "T3st1tn0w";
        titlePage = "Home - ACMEU Employee Portal";
        login(username, password, titlePage);
        studentId = mentorSqlData();
        return studentId;
    }

    public int mentorSqlData() throws Exception {
        studentId =
            SELECT studentId
            FROM acmeuacmeu.vw_student
            WHERE studentId in (SELECT studentId FROM acmeubanner.tbl_portal_version WHERE portal_version = 2)
                AND student_status = 'IN'
                AND enrolled_ewb = 1
                AND care_status = 'CLRD'
                AND current_term = 201408
                AND ROWNUM = 1;
        studentId = 206448;
        return studentId;
    }

    public void studentSetUp () throws Exception {
        username = "sturn19";
        password = "student";
        titlePage = "MyACMEU Student Portal";
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
        WebDriverWait waitTitlePage = new WebDriverWait(driver, 30);
        waitTitlePage.until(ExpectedConditions.titleIs(titlePage));
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains(titlePage));
    }

    public void prospectEnrollTest(String url, String titlePage) throws Exception {
        driver.get(url);
        WebDriverWait waitTitlePage = new WebDriverWait(driver, 10);
        waitTitlePage.until(ExpectedConditions.titleIs(titlePage));
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains(titlePage));
    }
}
