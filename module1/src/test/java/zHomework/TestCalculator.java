package zHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class TestCalculator {

    WebDriver driver;


    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "../drivers/geckodriver-v0.20.0-win32/geckodriver.exe");
        System.setProperty("webdriver.firefox.bin", "C:\\tools\\Firefox\\firefox.exe");
        driver = new FirefoxDriver();
        driver.get("http://juliemr.github.io/protractor-demo/");
    }

      //@AfterMethod
     // public void tearDown() throws Exception {
      //    driver.quit();
   // }

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
            WebElement result = driver.findElement (By.cssSelector("h2"));

            //Integer resultCheck;
            //resultCheck()= result.getText();
      //Assert.assertTrue(result.getText()=="5");

            //System.out.println("result", result.getText());
      Assert.assertEquals(result.getText(), "5");

        }






}}

