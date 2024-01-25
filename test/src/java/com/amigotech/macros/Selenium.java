package test.src.java.com.amigotech.macros;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class Selenium {
    public static String browserType;

    public static void assertElementNotPresent(String path) {
        List<WebElement> elements = WebDriverGetter.getWebDriver(browserType).findElements(By.xpath(path));
        Assertions.assertEquals(true, elements.isEmpty());
    }

    public static void assertTextEqual(String path, String textValue) {
        Selenium.waitElementVisible(path);
        WebElement element = Selenium.findElements(path);
        String elementText = element.getText();
        Assertions.assertEquals(textValue, elementText);
    }

    public static void clickAt(String path) {
        WebElement element = Selenium.findElements(path);
        Selenium.waitElementVisible(path);
        element.click();
    }

    public static void clickNoError(String path) {
        WebElement element = Selenium.findElements(path);
        synchronized (element) {
            try {
                element.wait(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (element.isDisplayed()) {
            element.click();
        }
    }

    public static WebElement findElements(String path) {
        return WebDriverGetter.getWebDriver(browserType).findElement(By.xpath(path));
    }

    public static void goToPage(String url) {
        WebDriverGetter.getWebDriver(browserType).get(url);
    }

    public static void pause(int timeInMilliseconds) {
        synchronized (WebDriverGetter.getWebDriver(browserType)){
            try {
                WebDriverGetter.getWebDriver(browserType).wait(timeInMilliseconds);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void setBrowserType(String type) {
        browserType = type;
    }

    public static void type(String path, String textValue) {
        Selenium.waitElementVisible(path);
        WebElement element = Selenium.findElements(path);
        element.sendKeys(textValue);
    }

    public static void waitElementVisible(String path) {
        WebElement element = Selenium.findElements(path);
        if (!element.isDisplayed()) {
            Selenium.pause(100);
        }
    }
}
