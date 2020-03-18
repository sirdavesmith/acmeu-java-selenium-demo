package acmeu_popup_banners;

import mocks.MentorTest;
import mocks.StudentGraduatedTest;
import model.TestAbstract;
import org.testng.annotations.Test;
import pages.MentorViewDegreePlanPage;
import pages.StudentViewDegreePlanPage;

public class GraduatedTests extends TestAbstract {
    private final MentorTest mentor = new MentorTest();
    private final StudentGraduatedTest student = new StudentGraduatedTest();

    @Test
    public void testGraduatedMessageAsMentor () throws Exception {
        MentorViewDegreePlanPage mentorViewStudentPlanPage = new MentorViewDegreePlanPage(this.getDriver(), student.getStudentId());

        mentor.setup(this.getDriver(), this.getDriverWait());
        mentorViewStudentPlanPage.open(this.getDriverWait());
        mentorViewStudentPlanPage.compareGraduatedMessage();
    }

    @Test
    public void testGraduatedMessageAsStudent () throws Exception {
        StudentViewDegreePlanPage studentViewDegreePlanPage = new StudentViewDegreePlanPage(this.getDriver());

        student.setup(this.getDriver(), this.getDriverWait());
        studentViewDegreePlanPage.open(this.getDriverWait());
        studentViewDegreePlanPage.compareGraduatedMessage();
    }
}
