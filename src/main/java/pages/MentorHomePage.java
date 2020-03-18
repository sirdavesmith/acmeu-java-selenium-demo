package pages;

import org.openqa.selenium.WebDriver;

public class MentorHomePage extends PageAbstract {
    /**
     * Constructor
     */
    public MentorHomePage(WebDriver driver){
        super(driver);

        this.URL = "https://l1horizon.acmeu.edu/group/academics/home";
        this.pageName = "Mentor Home Page";
        this.pageTitle = "Home - ACMEU Employee Portal";
    }
}
