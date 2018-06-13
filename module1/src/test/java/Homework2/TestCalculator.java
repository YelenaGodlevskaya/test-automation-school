package Homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class TestCalculator {

    WebDriver driver;


    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "../drivers/geckodriver-v0.20.0-win32/geckodriver.exe");
        System.setProperty("webdriver.firefox.bin", "C:\\tools\\Firefox\\firefox.exe");
        driver = new FirefoxDriver();
        driver.get("http://juliemr.github.io/protractor-demo/");
    }

    @AfterMethod
      public void tearDown() throws Exception {
       driver.quit();}

   @Test
   public void TitleTest() {
       Assert.assertTrue(driver.getTitle().contains("Super Calculator"));
   }

    @Test
    public void SumCheckTest() {
        WebElement inptFirstField = driver.findElement(By.cssSelector("[ng-model='first']"));
        //WebElement inptFirstField = driver.findElement(By.cssSelector(".input-small:first-child"));
        inptFirstField.sendKeys("2");
        //WebElement inptSecondField = driver.findElement(By.cssSelector(".input-small:last-child"));
        WebElement inptSecondField = driver.findElement(By.cssSelector("[ng-model='second']"));
          inptSecondField.sendKeys("3");
        WebElement btnGo = driver.findElement (By.cssSelector("#gobutton"));
        btnGo.sendKeys(Keys.ENTER);


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            WebElement result = driver.findElement(By.cssSelector("h2"));
            //System.out.println("result " + result.getText());
      assertTrue(result.getText().equals("5"));

        }

    @Test
    public void MultipleOperationsCheckTest() {
        WebElement inptFirstField = driver.findElement(By.cssSelector("[ng-model='first']"));
        //WebElement inptFirstField = driver.findElement(By.cssSelector(".input-small:first-child"));
        inptFirstField.sendKeys("8");
        WebElement operator = driver.findElement(By.cssSelector(".span1"));
        operator.sendKeys("-");
        WebElement inptSecondField = driver.findElement(By.cssSelector("[ng-model='second']"));
        inptSecondField.sendKeys("2");
        WebElement btnGo = driver.findElement (By.cssSelector("#gobutton"));
        btnGo.sendKeys(Keys.ENTER);


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement result = driver.findElement(By.cssSelector("h2"));
       // System.out.println("result " + result.getText());
        assertTrue(result.getText().equals("6"));

        inptFirstField.sendKeys("10");
        operator.sendKeys("/");
        inptSecondField.sendKeys("5");
        btnGo.sendKeys(Keys.ENTER);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // System.out.println("result " + result.getText());
        assertTrue(result.getText().equals("2"));

    }
}

