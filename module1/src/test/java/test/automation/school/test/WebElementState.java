package test.automation.school.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static javax.swing.text.html.CSS.getAttribute;

public class WebElementState {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver-v0.20.0-win32/geckodriver.exe");
        System.setProperty("webdriver.firefox.bin", "C:\\tools\\Firefox\\firefox.exe");

        WebDriver driver = new FirefoxDriver();
//        driver.get("http://www.google.com");
//        WebElement inptSearch = driver.findElement (By.cssSelector("[name='q']"));
//        System.out.println("Search input" + inptSearch.isDisplayed() );
//        driver.get("http://the-internet.herokuapp.com/checkboxes");
//        WebElement chkbxFirstinput = driver.findElement(By.xpath("//*[id='checkboxes']/input[1]"));
//        System.out.println("First checkbox" + chkbxFirstinput.isSelected());
//       System.out.println("First cehckbox: att" + chkbxFirstinput.getAttribute("checked"));
//
//       chkbxFirstinput.click();
//        System.out.println("First cehckbox: att" + chkbxFirstinput.getAttribute("checked"));
//
//        WebElement headerElement = driver.findElement(By.cssSelector("h3"));
//        System.out.println("header text: " + headerElement.getText());
//        //get.Text --> esli estj otkrivajushij i zakrivajushij element
//
//        WebElement divSection = driver.findElement(By.cssSelector("div.example"));
//        System.out.println("div example text: " + divSection.getText());


        driver.get("https://jedwatson.github.io/react-select/");
        WebElement drpFirst = driver.findElement (By.cssSelector(".State-NSW"));
        System.out.println("first" + drpFirst);

        WebElement disableStatesDropdownCheckbox = driver.findElement(By.xpath("//input[following-sibling::*[text()='Disabled']]"));
        System.out.println("is enabled element: " + disableStatesDropdownCheckbox.isEnabled());
        disableStatesDropdownCheckbox.click();
        drpFirst = driver.findElement (By.cssSelector(".State-NSW"));
        System.out.println("dropdown 1st enabled: " + disableStatesDropdownCheckbox.isEnabled());

        //is.Enabled toljko na Input elemetah rabotaet poetomu dla verhnego primera eto ne rabotajet




    }
}
