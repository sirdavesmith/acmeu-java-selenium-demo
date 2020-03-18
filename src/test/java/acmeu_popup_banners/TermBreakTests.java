package acmeu_popup_banners;

import mocks.MentorTest;
import mocks.StudentTermBreakTest;
import model.TestAbstract;
import org.testng.annotations.Test;
import pages.MentorViewDegreePlanPage;
import pages.StudentViewDegreePlanPage;

public class TermBreakTests extends TestAbstract{
    private final MentorTest mentor = new MentorTest();
    private final StudentTermBreakTest student = new StudentTermBreakTest();

    @Test
    public void testTermBreakMessageAsMentor () throws Exception {
        MentorViewDegreePlanPage mentorViewStudentPlanPage = new MentorViewDegreePlanPage(this.getDriver(), student.getStudentId());

        mentor.setup(this.getDriver(), this.getDriverWait());
        mentorViewStudentPlanPage.open(this.getDriverWait());
        mentorViewStudentPlanPage.compareTermBreakMessage();
    }

    @Test
    public void testTermBreakMessageAsStudent () throws Exception {
        StudentViewDegreePlanPage studentViewDegreePlanPage = new StudentViewDegreePlanPage(this.getDriver());

        student.setup(this.getDriver(), this.getDriverWait());
        studentViewDegreePlanPage.open(this.getDriverWait());
        studentViewDegreePlanPage.compareTermBreakMessage();
    }
}
