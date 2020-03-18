package pages;

import org.openqa.selenium.WebDriver;

public class StudentHomePage extends PageAbstract {
    /**
     * Constructor
     */
    public StudentHomePage(WebDriver driver){
        super(driver);

        this.URL = "https://acmeu.edu/group/acmeu-student-v2";
        this.pageName = "Student Home Page";
        this.pageTitle = "MyACMEU Student Portal";
    }
}
