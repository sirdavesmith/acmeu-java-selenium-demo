package mocks;

import model.Student;

public class StudentGraduatedTest extends Student {

    public StudentGraduatedTest() {
        super("juliewit", "automate");
        this.setStudentId(9625);
    }

    studentId =
        SELECT studentId
        FROM acmeuacmeu.vw_student
        WHERE
            studentId in (SELECT studentId FROM acmeubanner.tbl_portal_version WHERE portal_version = 2)
            AND student_status = 'IG'
            AND care_status = 'CLRD'
            AND ROWNUM = 1;
}
