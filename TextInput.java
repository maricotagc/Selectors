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
    public void TextInputTest() {
        //Given
        String expectedValue = "Izabela Moita";
        String expectedDisplayedInput = "Name: Izabela Moita";

        //When
        // Find the text input field element
        WebElement inputField = driver.findElement(By.id("name"));

        // Enter a value into the input field
        String inputValue = "Izabela Moita";
        inputField.sendKeys(inputValue);
        // Get the current value of the input field
        String actualValue = inputField.getAttribute("value");

        //Click on Submit button
        driver.findElement(By.cssSelector("input[type='button'][value='Display Input'][onclick='displayInput()']")).click();
        String actualDisplayedInput = driver.findElement(By.id("display-name")).getText();

        //Then
        // Verify that the value matches the expected input
        Assertions.assertEquals(expectedValue, actualValue);
        Assertions.assertEquals(expectedDisplayedInput, actualDisplayedInput);
    }
}
