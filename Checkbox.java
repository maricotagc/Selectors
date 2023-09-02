package moita;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Dropdown extends Base
{
    private Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    @BeforeEach
    public void openMainPage() {
        driver.get(BASE_URL);
        driver.findElement(By.cssSelector("#details-button")).click();
        driver.findElement(By.cssSelector("#proceed-link")).click();
    }

     @Test
    public void CheckboxSelectionTest(){
        //Given
        String expectedDisplayedInput = "Subscription: Subscribed";

        //When
        // Find the checkbox element
        WebElement checkbox = driver.findElement(By.id("subscribe"));

        // Check the initial state of the checkbox
        boolean isCheckedInitially = checkbox.isSelected();
        Assertions.assertFalse(isCheckedInitially, "Checkbox should not be checked initially");

        // Click the checkbox to toggle its state
        checkbox.click();

        //Click on Submit button
        driver.findElement(By.cssSelector("input[type='button'][value='Display Input'][onclick='displayInput()']")).click();
        String actualDisplayedInput = driver.findElement(By.id("display-subscribe")).getText();

        // Check the updated state of the checkbox
        boolean isCheckedAfterClick = checkbox.isSelected();
        Assertions.assertTrue(isCheckedAfterClick, "Checkbox should be checked after click");
        Assertions.assertEquals(expectedDisplayedInput, actualDisplayedInput);
    }
}


package moita;

import com.moita.demo.selenium.factory.WebDriverFactory;
import com.moita.demo.selenium.util.SeleniumUtil;
import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TechlisticTest
{
    SeleniumUtil seleniumUtil;
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        WebDriverFactory webDriverFactory = new WebDriverFactory();
        driver = webDriverFactory.createChromeDriver();
        seleniumUtil = new SeleniumUtil(driver);

        seleniumUtil.openPage("https://www.techlistic.com/p/selenium-practice-form.html");
        seleniumUtil.clickButtonByCss("#ez-accept-all");
        WebDriver frame1Driver = seleniumUtil.changeIframeById("google_ads_iframe_/1254144,22662382379/techlistic_com-pixel1_0");
        WebDriver frame2Driver = seleniumUtil.changeIframeById(frame1Driver,"ad_iframe");

        List<WebElement> spans = frame2Driver.findElements(By.tagName("span"));

        for (WebElement span : spans) {
            if (span.getText().equals("Close")) {
                span.click();
                break;
            }
        }
        driver.switchTo().parentFrame();
        seleniumUtil.clickButtonById("ezmob-footer-close");
        seleniumUtil.clickButtonById("cookieChoiceDismiss");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void CheckBoxTest(){
        //Given
        WebElement manualTester;
        WebElement seleniumWebDriverTool;

        //When
        seleniumUtil.clickButtonById("profession-0");
        manualTester = driver.findElement(By.id("profession-0"));

        seleniumUtil.clickButtonById("tool-2");
        seleniumWebDriverTool = driver.findElement(By.id("tool-2"));

        //Then
        Assertions.assertTrue(manualTester.isSelected());
        Assertions.assertTrue(seleniumWebDriverTool.isSelected());
    }
}
