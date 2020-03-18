package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.Log;

public class StudentViewDegreePlanPage extends PageAbstract {
    private final String iFrame = "_ACMEU_IFrame_Portlet_INSTANCE_aTC3_iframe";
    private final String studentGraduatedMessage = "You have already graduated therefore you will not have access to myDegree Plan";
    private final String studentTermBreakMessage = "You are currently on Term Break. During this time, you will not have access to your Degree Plan.";

    /**
     * Constructor
     */
    public StudentViewDegreePlanPage(WebDriver driver){
        super(driver);

        this.URL = "https://acmeu.edu/group/acmeu-student-v2/my-degreeplan";
        this.pageName = "Student View Degree Plan Page";
        this.pageTitle = "MyACMEU Student Portal";
    }

    public void compareGraduatedMessage() throws InterruptedException {
        compareMessage(studentGraduatedMessage);
    }

    public void compareTermBreakMessage() throws InterruptedException {
        compareMessage(studentTermBreakMessage);
    }

    private void compareMessage(String message) throws InterruptedException {
        Log.logMessage("Validating that the " + this.getPageName() + " contains this message: " + message);
        WebElement parentFrame = this.getDriver().findElement(By.id(this.iFrame));
        this.getDriver().switchTo().frame(parentFrame);

        //TODO: Refactor this when we can get waits to work in an iFrame
        Thread.sleep(10000);
        Assert.assertTrue(this.getPageSource().contains(message), this.getPageName() + " source does NOT contain the message: " + message);
        Log.logMessage("Test has successfully validated that " + this.getPageName() + " contains the following message: " + message);
    }
}
