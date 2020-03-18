package acmeu_buttons;

import mocks.MentorTest;
import mocks.StudentGraduatedTest;
import model.TestAbstract;
import org.testng.annotations.Test;
import pages.MentorViewDegreePlanPage;

public class FieldExperienceTests extends TestAbstract {
    private final MentorTest mentor = new MentorTest();
    private final StudentGraduatedTest student = new StudentGraduatedTest();
    private final MentorViewDegreePlanPage viewStudentPlanPage = new MentorViewDegreePlanPage(this.getDriver(), student.getStudentId());

    @Test
    public void testFieldExperience() throws Exception {
        mentor.setup(this.getDriver(), this.getDriverWait());
        viewStudentPlanPage.open(this.getDriverWait());
        viewStudentPlanPage.compareGraduatedMessage();
    }
}
