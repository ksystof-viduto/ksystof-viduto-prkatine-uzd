package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class WaitUtils {

    public static final int DEFAULT_TIME_FOR_WAIT = 5;

    public static void waitForDisplayed(WebDriver driver, WebElement webElement) {
        waitForDisplayed(driver, webElement, DEFAULT_TIME_FOR_WAIT);
    }

    public static void waitForDisplayed(WebDriver driver, WebElement webElement, int secondsToWait) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(secondsToWait));
        wait.until(visibilityOf(webElement));
    }
}
