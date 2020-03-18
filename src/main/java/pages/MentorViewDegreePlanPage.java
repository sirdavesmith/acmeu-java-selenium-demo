package pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.Log;

public class MentorViewDegreePlanPage extends PageAbstract {
    private final String mentorGraduatedMessage = "This student has graduated therefore can no longer access myDegree Plan";
    private final String mentorTermBreakMessage = "This student is currently on term break. They will not be able to access myDegree Plan until they have come back from term break.";
    private final String mentorProspectMessage = "When the student begins the Education Without Boundaries Orientation you will access their Degree Plan here";

    /**
     * Constructor
     */
    public MentorViewDegreePlanPage(WebDriver driver, int studentId){
        super(driver);

        this.URL = "https://l1webapp18.acmeu.edu/acmeu/for/" + studentId;
        this.pageName = "Mentor View Degree Plan Page";
        this.pageTitle = "Western Governors University | Degree Plan";
    }

    public void compareGraduatedMessage() {
        compareMessage(mentorGraduatedMessage);
    }

    public void compareTermBreakMessage() {
        compareMessage(mentorTermBreakMessage);
    }

    public void compareProspectMessage() {
        compareMessage(mentorProspectMessage);
    }

    private void compareMessage(String message){
        Log.logMessage("Validating that the " + this.getPageName() + " contains this message: " + message);
        Assert.assertTrue(this.getPageSource().contains(message), this.getPageName() + " source does NOT contain the message: " + message);
        Log.logMessage("Test has successfully validated that " + this.getPageName() + " contains the following message: " + message);
    }
}
