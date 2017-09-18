package framework.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;

public class Browser {
    private static ChromeDriver driver;

    public Browser() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
    }

    public Browser click(By locator) {
        buildWebElement(locator).click();
        return this;
    }

    public Browser hitKey(By locator, Keys key) {
        WebElement element = buildWebElement(locator);
        element.sendKeys(Keys.chord(key));
        return this;
    }

    private WebElement buildWebElement(By locator) {
        waitFor(locator);
        Helper.delay(100);
        return driver.findElement(locator);
    }

    public Browser waitFor(By locator) {
        Wait fluentWait = new FluentWait(driver)
                .withTimeout(10, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return this;
    }

    public Boolean isSelected(By locator) {
        return buildWebElement(locator).isSelected();
    }

    public Boolean isVisible(By locator) {
        return isPresent(locator) && buildWebElement(locator).isDisplayed();
    }

    public Boolean isPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public static void navigate(String URL) {
        driver.get(URL);
    }

    public Browser tickCheckBox(By locator) {
        if (!isSelected(locator)) {
            click(locator);
        }
        return this;
    }

    public Browser type(By locator, String text) {
        WebElement element = buildWebElement(locator);
        element.clear();
        element.sendKeys(text);
        return this;
    }

    public static void quit (){
        driver.quit();
    }
}
