package test.src.java.com.amigotech.macros;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public final class WebDriverGetter {
    private static WebDriver webDriver;

    public static void closeWebDriver() {
        webDriver.close();
        webDriver = null;
    }

    public static WebDriver getWebDriver() {
        if (webDriver == null){
            webDriver = new ChromeDriver();
        }
        return webDriver;
    }

    public static WebDriver getWebDriver(String type) {
        if (webDriver == null){
            if (type.equals("Firefox")) webDriver = new FirefoxDriver();
            else webDriver = new ChromeDriver();
        }
        return webDriver;
    }
}
