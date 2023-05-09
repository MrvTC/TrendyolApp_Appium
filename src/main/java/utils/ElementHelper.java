package utils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;


public class ElementHelper {

    private WebDriver driver;
    private WebDriverWait wait;

    public ElementHelper(WebDriver driver) {
        String time = ConfigReader.getProperty("wait");
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(time)));
    }

    public WebElement findElement(By locator) {
        try {
            return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception e) {
            return scroll(locator).get(0);
        }

    }

    public List<WebElement> findElements(By locator) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public void checkElement(By locator) {
        findElement(locator);
    }


    public void pressEnter() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("mobile:performEditorAction", ImmutableMap.of("action", "done"));
    }

    public void pressSearch() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("mobile:performEditorAction", ImmutableMap.of("action", "search"));
    }

    public void pressEnter2() {
        AndroidDriver driver1 = (AndroidDriver) driver;
        driver1.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public void pressEnter3(String text) {
        driver.findElement(By.xpath("")).sendKeys("tshirt" + "\n");
    }


    public void click(By locator) {
        findElement(locator).click();
    }

    public String getText(By locator) {
        return findElement(locator).getText();
    }

    public void sendKeys(By locator, String text) {
        findElement(locator).sendKeys(text + "\n");
    }

    public void clickElementWithText(By locator, String text) {
        int i = 0;
        boolean check = false;
        findElement(locator);
        while (i < 4) {
            List<WebElement> elementList = findElements(locator);
            for (WebElement elem : elementList) {
                if (elem.getText().equals(text)) {
                    check = true;
                    elem.click();
                    break;
                }
            }
            if (check) {
                break;
            } else {
                scrollDown();
                i++;
            }
        }
        Assert.assertTrue(check, "Listede istediğin textteki elamanı bulamadım!!!");
    }


    public void checkElementWithText(By locator, String text) {
        int i = 0;
        boolean check = false;
        findElement(locator);
        while (i < 4) {
            List<WebElement> elementList = findElements(locator);
            for (WebElement elem : elementList) {
                if (elem.getText().equals(text)) {
                    check = true;
                    break;
                }
            }
            if (check) {
                break;
            } else {
                scrollDown();
                i++;
            }
        }
        Assert.assertTrue(check, "Listede istediğin textteki elamanı bulamadım!!!");
    }

    public List<WebElement> scroll(By by) {
        int i = 0;
        String previusPageSource = ".";
        while (checkElemenEnabled(by) && i < 5 && checkEndOfPage(previusPageSource)) {
            i++;
            previusPageSource = driver.getPageSource();
            scrollDown();
        }
        return driver.findElements(by);
    }

    public boolean checkEndOfPage(String previusPageSource) {
        return !previusPageSource.equals(driver.getPageSource());
    }

    public boolean checkElemenEnabled(By by) {
        return driver.findElements(by).isEmpty();
    }

    public void scrollDown() {
        int startX = driver.manage().window().getSize().getWidth() / 2;
        int startY = driver.manage().window().getSize().getHeight() / 2;
        int endx = driver.manage().window().getSize().getWidth() / 2;
        int endY = (int) (driver.manage().window().getSize().getHeight() * 0.2);


        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence scroll = new Sequence(finger, 0);
        scroll.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        scroll.addAction(finger.createPointerMove(Duration.ofMillis(300), PointerInput.Origin.viewport(), endx, endY));
        scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        ((RemoteWebDriver) driver).perform(List.of(scroll));
    }

    public void scrollDownWithElement(By filtreleme) {
        int startX = driver.findElement(filtreleme).getSize().getWidth() / 2;
        int startY = driver.findElement(filtreleme).getSize().getHeight() / 2;
        int endx = driver.findElement(filtreleme).getSize().getWidth() / 2;
        int endY = (int) (driver.findElement(filtreleme).getSize().getHeight() * 0.2);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence scroll = new Sequence(finger, 0);
        scroll.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        scroll.addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), endx, endY));
        scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        ((RemoteWebDriver) driver).perform(List.of(scroll));
    }

}
