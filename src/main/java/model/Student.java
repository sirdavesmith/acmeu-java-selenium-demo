package model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import pages.StudentHomePage;

public class Student extends User {
    private int studentId;

    protected Student(String username, String password) {
        super(username, password);
    }

    public void setup (WebDriver driver, WebDriverWait waitTitlePage) {
        LoginPage loginPage = new LoginPage(driver);
        super.setup(driver, waitTitlePage);

        StudentHomePage studentHomePage = loginPage.pressLoginBtnStudent();
        waitTitlePage.until(ExpectedConditions.titleIs(studentHomePage.getPageTitle()));
    }

    public int getStudentId() {
        return studentId;
    }

    protected void setStudentId(int studentId) {
        this.studentId = studentId;
    }
}
