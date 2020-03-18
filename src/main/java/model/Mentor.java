package model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import pages.MentorHomePage;

public class Mentor extends User {
    protected Mentor(String username, String password) {
        super(username, password);
    }

    public void setup (WebDriver driver, WebDriverWait waitTitlePage) {
        LoginPage loginPage = new LoginPage(driver);
        super.setup(driver, waitTitlePage);

        MentorHomePage mentorHomePage = loginPage.pressLoginBtnMentor();
        waitTitlePage.until(ExpectedConditions.titleIs(mentorHomePage.getPageTitle()));
    }
}
