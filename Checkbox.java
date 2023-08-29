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
