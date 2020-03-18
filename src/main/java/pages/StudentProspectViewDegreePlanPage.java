package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.Log;

public class StudentProspectViewDegreePlanPage extends StudentViewDegreePlanPage {
    private final String iFrame = "_ACMEU_IFrame_Portlet_INSTANCE_2luP_iframe";
    private final String studentProspectMessage = "When you begin the Education Without Boundaries Orientation you will access your Degree Plan here";

    /**
     * Constructor
     */
    public StudentProspectViewDegreePlanPage(WebDriver driver){
        super(driver);

        this.URL = "https://acmeu.edu/group/acmeu-prospective-student-v2/my-degreeplan";
    }

    public void compareProspectMessage() throws InterruptedException {
        compareMessage(studentProspectMessage);
    }

    private void compareMessage(String message) throws InterruptedException {
        Log.logMessage("Validating that the " + this.getPageName() + " contains this message: " + message);
        WebElement parentFrame = this.getDriver().findElement(By.id(this.iFrame));
        this.getDriver().switchTo().frame(parentFrame);

        Assert.assertTrue(this.getPageSource().contains(message), this.getPageName() + " source does NOT contain the message: " + message);
        Log.logMessage("Test has successfully validated that " + this.getPageName() + " contains the following message: " + message);
    }

}
