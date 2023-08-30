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
    public void testTextareaContentAssertion() {
        //Given
        String expectedResult = "I am the most beautiful baby in the world";
        //Given
        String expectedDisplayedInput = "Comments: I am the most beautiful baby in the world";

        //When
        // Find the textarea element
        WebElement textarea = driver.findElement(By.id("comments"));

        // Enter content into the textarea
        String inputContent = "I am the most beautiful baby in the world";
        textarea.sendKeys(inputContent);

        // Get the current content of the textarea
        String actualContent = textarea.getAttribute("value");

        //Click on Submit button
        driver.findElement(By.cssSelector("input[type='button'][value='Display Input'][onclick='displayInput()']")).click();
        String actualDisplayedInput = driver.findElement(By.id("display-comments")).getText();

        // Verify that the content matches the expected input
        Assertions.assertEquals(expectedResult, actualContent);
        Assertions.assertEquals(expectedDisplayedInput, actualDisplayedInput);
    }
}
