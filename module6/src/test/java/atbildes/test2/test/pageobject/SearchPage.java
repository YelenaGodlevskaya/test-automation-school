package atbildes.test2.test.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
    private WebDriver driver;
    WebDriverWait wait;

    private static final By SEARCH_INPUT_LOCATOR = By.cssSelector(".main_table");
//    private static final By SEARCH_BUTTON_LOCATOR = By.cssSelector("#sbtn");
    private static final By LABEL_LOCATOR = By.xpath("//*[contains(text(),'Искомое слово') or contains(text(),'Meklējamais vārds')]");
    private static final By SEARCH_BUTTON_LOCATOR = By.cssSelector("#sbtn");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(SEARCH_INPUT_LOCATOR));

    }

    public void searchForPhrase(String phraseToSearch) {
        driver.findElement(SEARCH_INPUT_LOCATOR).sendKeys(phraseToSearch);
    }

    public void performSearch() {
        driver.findElement(SEARCH_BUTTON_LOCATOR).click();
    }


}
