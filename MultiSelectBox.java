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
import org.openqa.selenium.support.ui.Select;

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
    public void MultiSelectBoxTest(){
        //Given
        Select seleniumCommands = new Select(driver.findElement(By.id("selenium_commands")));

        //When
        seleniumCommands.selectByVisibleText("Wait Commands");
        seleniumCommands.selectByVisibleText("WebElement Commands");
        List<WebElement> selectedOptions = seleniumCommands.getAllSelectedOptions();

        //Then
        Assertions.assertEquals(2, selectedOptions.size());
        Assertions.assertTrue(selectedOptions.get(0).getText().equals("Wait Commands"));
        Assertions.assertTrue(selectedOptions.get(1).getText().equals("WebElement Commands"));
    }
}
