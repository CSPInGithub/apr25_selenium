package e2e;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

// This class contains test cases to verify the login functionality of the Naukri website.
public class LoginTest {

        @Test
        // It checks if the user can log in with valid credentials and ensures
        // redirection to the homepage.
        // This test verifies the successful login behavior on the Naukri website.
        public void loginTest() throws InterruptedException, IOException {

                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless=new");
                // options.addArguments("--window-size=1920,1080");
                // options.addArguments("--disable-gpu");
                // options.addArguments("--no-sandbox");
                // options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--disable-blink-features=AutomationControlled");
                options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64)");
                WebDriver driver = new ChromeDriver(options);

                // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
                driver.manage().window().maximize();

                driver.manage().deleteAllCookies();

                driver.get("https://www.naukri.com/");
                System.out.println("website opend successfully");

                WebElement jsLogin = driver.findElement(By.xpath("//a[@title='Jobseeker Login']"));

                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", jsLogin);

                System.out.println("js login clicked successfully");

                driver.findElement(By.xpath("//input[@placeholder='Enter your active Email ID / Username']"))
                                .sendKeys(System.getProperty("login.username"));

                driver.findElement(By.xpath("//input[@placeholder='Enter your password']"))
                                .sendKeys(System.getProperty("login.password"));

                WebElement loginBtn = driver.findElement(By.xpath("//button[@class='btn-primary loginButton']"));
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", loginBtn);
                loginBtn.click();

                System.out.println("login clicked successfully after entering credentials..");
                // Capture Screenshot
                TakesScreenshot screenshot = (TakesScreenshot) driver;
                File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
                File destFile = new File("target/dashboard_screenshot.png");
                Files.copy(srcFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

                // Assert
                Thread.sleep(6000);
                // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".reco-title")));
                String actual = driver.getCurrentUrl();

                System.out.println("current url is " + actual);
                TakesScreenshot screenshot1 = (TakesScreenshot) driver;
                File srcFile1 = screenshot1.getScreenshotAs(OutputType.FILE);
                File destFile1 = new File("target/dashboard_screenshot1.png");
                Files.copy(srcFile1.toPath(), destFile1.toPath(), StandardCopyOption.REPLACE_EXISTING);

                Assert.assertTrue(actual.equals("https://www.naukri.com/mnjuser/homepage"));

                System.out.println("successfully validated");

                driver.quit();

        }

}
