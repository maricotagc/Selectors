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
        //Find the dropdown element
        WebElement dropdown = driver.findElement(By.id("gender"));

        // Select "Option Female" from the dropdown
        WebElement optionToSelect = dropdown.findElement(By.cssSelector("option[value='female']"));
        optionToSelect.click();

        // Find the selected option
        WebElement selectedOption = dropdown.findElement(By.cssSelector("option[value='female']"));

        // Verify that the selected option is indeed selected
        Assertions.assertTrue(selectedOption.isSelected(), "Female should be selected");
    }

    @Test
    public void CheckboxSelectionTest(){
        // Find the checkbox element
        WebElement checkbox = driver.findElement(By.id("subscribe"));

        // Check the initial state of the checkbox
        boolean isCheckedInitially = checkbox.isSelected();
        Assertions.assertFalse(isCheckedInitially, "Checkbox should not be checked initially");

        // Click the checkbox to toggle its state
        checkbox.click();

        // Check the updated state of the checkbox
        boolean isCheckedAfterClick = checkbox.isSelected();
        Assertions.assertTrue(isCheckedAfterClick, "Checkbox should be checked after click");
        System.out.println("");
    }

    @Test
    public void TextInputTest() {
        //Given
        String expectedValue = "Izabela Moita";

        //When
        // Find the text input field element
        WebElement inputField = driver.findElement(By.id("name"));

        // Enter a value into the input field
        String inputValue = "Izabela Moita";
        inputField.sendKeys(inputValue);
        // Get the current value of the input field
        String actualValue = inputField.getAttribute("value");

        //Then
        // Verify that the value matches the expected input
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testTextareaContentAssertion() {
        //Given
        String expectedResult = "I am the most beautiful baby in the world";

        //When
        // Find the textarea element
        WebElement textarea = driver.findElement(By.id("comments"));

        // Enter content into the textarea
        String inputContent = "I am the most beautiful baby in the world";
        textarea.sendKeys(inputContent);

        // Get the current content of the textarea
        String actualContent = textarea.getAttribute("value");

        // Verify that the content matches the expected input
        Assertions.assertEquals(expectedResult, actualContent);
    }
}
