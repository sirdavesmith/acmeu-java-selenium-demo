package acmeu_popup_banners;

import mocks.MentorTest;
import mocks.StudentProspectTest;
import model.TestAbstract;
import org.testng.annotations.Test;
import pages.MentorViewDegreePlanPage;
import pages.StudentProspectViewDegreePlanPage;

public class ProspectEnrollTests extends TestAbstract {
    private final MentorTest mentor = new MentorTest();
    private final StudentProspectTest student = new StudentProspectTest();

    @Test
    public void testProspectEnrollMessageAsMentor () throws Exception {
        MentorViewDegreePlanPage mentorViewStudentPlanPage = new MentorViewDegreePlanPage(this.getDriver(), student.getStudentId());

        mentor.setup(this.getDriver(), this.getDriverWait());
        mentorViewStudentPlanPage.open(this.getDriverWait());
        mentorViewStudentPlanPage.compareProspectMessage();
    }

    @Test
    public void testProspectEnrollMessageAsStudent () throws Exception {
        StudentProspectViewDegreePlanPage studentProspectViewDegreePlanPage = new StudentProspectViewDegreePlanPage(this.getDriver());

        student.setup(this.getDriver(), this.getDriverWait());
        studentProspectViewDegreePlanPage.open(this.getDriverWait());
        studentProspectViewDegreePlanPage.compareProspectMessage();
    }
}
