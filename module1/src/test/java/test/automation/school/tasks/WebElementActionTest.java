package test.automation.school.tasks;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebElementActionTest {

    WebDriver driver;
    //TODO - tests should use new browser instance for each test method


    //TODO 1 - inside of test fixture (test setup) - initialize WebDriver instance and navigate to http://automationpractice.com/WebDriver driver = new FirefoxDriver();
    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "../drivers/geckodriver-v0.20.0-win32/geckodriver.exe");
        System.setProperty("webdriver.firefox.bin", "C:\\tools\\Firefox\\firefox.exe");
        driver = new FirefoxDriver();
        driver.get("http://automationpractice.com/");
    }
    //TODO 1


    //TODO 2 - Destroy WebDriver instance in a test fixture (test test teardown)
    //  @AfterMethod
    //  public void tearDown() throws Exception {
    //      driver.quit();
    // }
    //TODO 2


    //TODO 3 - Create TestNg Test method which navigates to Contact info page (click()) and verify that user is navigated to other page
    // NOTE - in order to verify that user has been navigated to new page, you can use 'driver.getTitle()', however this will work only for non Single Page Applications
    @Test
    public void NavigationToContact() {
        WebElement btnContact = driver.findElement(By.cssSelector("#contact-link"));
        btnContact.click();
       // String title = driver.getTitle();
      // Assert.assertTrue(title=="Contact us - My Store");
        Assert.assertTrue(driver.getTitle().contains("Contact us - My Store"));
    }
    //TODO 3


    //TODO 4 -Create TestNg Test method which inputs some value into search input field and then clear the inputted text. Try do it in 2 possible ways.
    //TODO 4 - Also verify inputted text after each input action.
    @Test
    public void SearchCriteria() {
        WebElement inputSearch = driver.findElement(By.cssSelector(".search_query"));
        inputSearch.sendKeys("dress");
       //Assert.assertTrue(driver.findElement(By.cssSelector(".search_query")).getText().contains("dress"));
        inputSearch.clear();
    }
    //TODO 4


    //TODO 5 - Create TestNg Test method - input some value into search input field and submit the result. Verify that user is navigated to new page
    // NOTE - in order to verify that user has been navigated to new page, you can use 'driver.getTitle()', however this will work only for non Single Page Applications
    @Test
    public void SearchResults() {
        WebElement inputSearch = driver.findElement(By.cssSelector(".search_query"));
        inputSearch.sendKeys("dress", Keys.ENTER);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(driver.getTitle().contains("Search - My Store"));

    }
}
        //TODO 5



