package test.automation.school.tasks;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.automation.school.waits.ExplicitWaitExample;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;
import static org.testng.Assert.assertTrue;

public class WaitTest {
    //TODO - tests should use new browser instance for each test method

    WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "../drivers/geckodriver-v0.20.0-win32/geckodriver.exe");
        System.setProperty("webdriver.firefox.bin", "C:\\tools\\Firefox\\firefox.exe");
        driver = new FirefoxDriver();
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
    }
    //@AfterMethod
   //public void tearDown() throws Exception { driver.quit();}

    //TODO 1 - inside of test fixture (test setup) - initialize WebDriver instance and navigate to http://automationpractice.com/

    //TODO 1


    //TODO 2 - Destroy WebDriver instance in a test fixture (test test teardown)

    //TODO 2

    //TODO 3 - Create TestNg test method which
    //TODO 3 - 1. verifies that checkbox element dissapears after hitting "Remove" button
    //TODO 3 - 2. verifies that checkbox element appears after hitting "Add" button
    //TODO 3 - Use Explicit Wait without Implicit Wait


@Test
        public void ExplicitTest() {
    WebElement button = driver.findElement(By.cssSelector("#btn"));
    button.click();
    WebDriverWait wait = new WebDriverWait(driver, 7);
    WebElement checkbox = driver.findElement(By.cssSelector("#checkbox"));
    //WebElement progressBar = driver.findElement(By.cssSelector("#loading"));
    //wait.until(ExpectedConditions.invisibilityOf(progressBar));
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#loading")));
    assertTrue(driver.findElements(By.cssSelector("#checkbox")).size()==0);

    button.click();
   // wait.until(ExpectedConditions.invisibilityOf(progressBar));
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#loading")));
    assertTrue(driver.findElements(By.cssSelector("#checkbox")).size()!=0);

}

        //TODO 3


    //TODO 4 - Create TestNg test method which
    //TODO 4 - 1. verifies that checkbox element dissapears after hitting "Remove" button
    //TODO 4 - 2. verifies that checkbox element appears after hitting "Add" button
    //TODO 4 - Use Implicit Wait without Explicit Wait
    @Test
    public void ImplicitTest() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        assertTrue(driver.findElement(By.cssSelector("#checkbox")).isDisplayed());
        WebElement checkbox = driver.findElement(By.cssSelector("#checkbox"));
        WebElement button = driver.findElement(By.cssSelector("#btn"));
        button.click();

        WebElement txtIsGone = driver.findElement(By.cssSelector("#message"));
         assertTrue(driver.findElements(By.cssSelector("#checkbox")).size()==0);
        Assert.assertEquals(txtIsGone.getText(), "It's gone!");
        button.click();
//        // assertTrue(driver.findElement(By.cssSelector("#checkbox")).isDisplayed());
//        assertTrue(driver.findElements(By.cssSelector("#checkbox")).size()!=0);



    //TODO 4


    //TODO 5 - examine both approaches! which one is better?
}}

