package model;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public abstract class TestAbstract {
    @Getter
    @Setter
    private WebDriver driver;

    @Getter
    @Setter
    private WebDriverWait driverWait;

    @BeforeMethod
    public void setUp() throws Exception {
        this.setDriver(new FirefoxDriver());
        this.setDriverWait(new WebDriverWait(driver, 10));
        this.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() throws Exception {
        this.getDriver().quit();

        String verificationErrorString = "";
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
