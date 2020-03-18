package model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;

public abstract class User {
    private String username;
    private String password;

    User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setup(WebDriver driver, WebDriverWait waitTitlePage) {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.open(waitTitlePage);
        loginPage.enterUsername(this);
        loginPage.enterPassword(this);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
