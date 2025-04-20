package e2e;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

// This class contains test cases to verify the login functionality of the Naukri website.
public class LoginTest {

    @Test
    // It checks if the user can log in with valid credentials and ensures
    // redirection to the homepage.
    // This test verifies the successful login behavior on the Naukri website.
    public void loginTest() throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64)");
        WebDriver driver = new ChromeDriver(options);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.manage().deleteAllCookies();

        driver.get("https://www.naukri.com/");
        System.out.println("opend successfully");

        driver.findElement(By.xpath("//a[@title='Jobseeker Login']")).click();

        System.out.println("clicked successfully");

        driver.findElement(By.xpath("//input[@placeholder='Enter your active Email ID / Username']"))
                .sendKeys(System.getProperty("login.username"));

        driver.findElement(By.xpath("//input[@placeholder='Enter your password']"))
                .sendKeys(System.getProperty("login.password"));

        driver.findElement(By.xpath("//button[@class='btn-primary loginButton']"))
                .click();

        // Assert
Thread.sleep(2000);
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".reco-title")));
        String actual = driver.getCurrentUrl();

        System.out.println("current url is " + actual);

        Assert.assertTrue(actual.equals("https://www.naukri.com/mnjuser/homepage"));

        System.out.println("successfully validated");

        driver.quit();

    }

}
