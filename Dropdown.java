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

public class Examples extends Base
{
    private Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    @BeforeEach
    public void openMainPage() {
        driver.get(BASE_URL);
        driver.findElement(By.cssSelector("#details-button")).click();
        driver.findElement(By.cssSelector("#proceed-link")).click();
    }

   @Test
    public void DropdownSelectionTest(){
        //Given
        String expectedDisplayedInput = "Gender: female";

        //Find the dropdown element
        WebElement dropdown = driver.findElement(By.id("gender"));

        // Select "Option Female" from the dropdown
        WebElement optionToSelect = dropdown.findElement(By.cssSelector("option[value='female']"));
        optionToSelect.click();

        // Find the selected option
        WebElement selectedOption = dropdown.findElement(By.cssSelector("option[value='female']"));

        //Click on Submit button
        driver.findElement(By.cssSelector("input[type='button'][value='Display Input'][onclick='displayInput()']")).click();
        String actualDisplayedInput = driver.findElement(By.id("display-gender")).getText();

        // Verify that the selected option is indeed selected
        Assertions.assertTrue(selectedOption.isSelected(), "Female should be selected");
        Assertions.assertEquals(expectedDisplayedInput, actualDisplayedInput);
    }
}
