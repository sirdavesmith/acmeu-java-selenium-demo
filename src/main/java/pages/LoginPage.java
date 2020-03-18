package pages;

import lombok.Getter;
import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Log;

public class LoginPage extends PageAbstract {
    @Getter
    private final String usernameFld = "userName";

    @Getter
    private final String passwordFld = "password";

    private final String loginBtn = "loginButton";

    /**
     * Constructor
     */
    public LoginPage(WebDriver driver){
        super(driver);

        // set the default URL
        this.URL = "https://acmeu.edu/c/portal/login";
        this.pageName = "Login Page";
        this.pageTitle = "Western Governors University";
    }

    public void enterUsername(User user){
        sendTextById(this.getUsernameFld(), user.getUsername());
        Log.logMessage("Accessing page's username element by id: " + this.usernameFld + "\n" + "Entering username: " + user.getUsername());
    }

    public void enterPassword(User user){
        sendTextById(this.getPasswordFld(), user.getPassword());
        Log.logMessage("Accessing page's password element by id: " + this.passwordFld + "\n" + "Entering password: " + user.getPassword());
    }

    private void pressLoginBtn(){
        getDriver().findElement(By.id(loginBtn)).click();
        Log.logMessage("Accessing page's login button by id: " + this.loginBtn + "\n" + "Logging in...");
    }

    public MentorHomePage pressLoginBtnMentor(){
        pressLoginBtn();
        return new MentorHomePage(this.getDriver());
    }

    public StudentHomePage pressLoginBtnStudent(){
        pressLoginBtn();
        return new StudentHomePage(this.getDriver());
    }
}
