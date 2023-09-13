
# How to find elements in the DOM

[Page for practice](https://raphael.moita.gitlab.io/query-selectors/page-1.html)

## Exercises
1. Create a query selector to get the RED block content

    * Attribute used: id="id-1"
    * Dev Tools Console: document.querySelector("#id-1");
    * Selenium: driver.findElement(By.id("id-1"));

2. Create a query selector to get the YELLOW block content
    * Attribute used: class="class-a class-b"
    * Dev Tools Console: document.querySelector(".class-a.class-b");
    * Selenium: driver.findElement(By.cssSelector(".class-a.class-b"));
    
3. Create a query selector to get the first BLUE block content
    * Attribute used: position="3" and not having level attribute
    * Dev Tools Console: document.querySelector("div[position='3']:not([level='5']");
    * Selenium: driver.findElement(By.cssSelector("div[position='3']:not([level='5']"));
    
4. Create a query selector to get the GREEN block content
    * Attribute used: div and span
    * Dev Tools Console: document.querySelectorAll("div > span");
    * Selenium: driver.findElement(By.cssSelector("div > span"));
    
5. Create a query selector to get the GRAY blocks content
    * Attribute used: wildcard ^ (starts with)
    * Dev Tools Console: document.querySelectorAll("[class^='class-special']");
    * Selenium: driver.findElements(By.cssSelector("[class^='class-special']"));
    
6. Create a query selector to click on the button
    * Attribute used: button
    * Dev Tools Console: document.querySelector("button").click();
    * Selenium: driver.findElement(By.tagName("button"));
    
7. Create a query selector to read the textarea context that will show up after clicking the button
    * Attribute used: id
    * Dev Tools Console: document.querySelector("#screen").value;
    * Selenium: driver.findElement(By.id("screen")).getAttribute("value"));

## Wildcards
[id^='someId'] will match all ids starting with someId.


[id$='someId'] will match all ids ending with someId.


[id*='someId'] will match all ids containing someId.

# Page for practice 2
https://raphael.moita.gitlab.io/query-selectors/selenium/

## WebElements

1. Dropdown: [Code Example](/https://github.com/maricotagc/Selectors/blob/main/Dropdown.java)
2. Checkbox: [Code Example](/https://github.com/maricotagc/Selectors/blob/main/Checkbox.java)
3. TextInput: [Code Example](/https://github.com/maricotagc/Selectors/blob/main/TextInput.java)
4. TextArea: [Code Example](/https://github.com/maricotagc/Selectors/blob/main/Textarea.java)
5. IFrame: [Code Example](/https://github.com/maricotagc/Selectors/blob/main/Iframe.java)
6. Radio Button: [Code Example](/https://github.com/maricotagc/Selectors/blob/main/RadioButton.java)
7. Select Box: [Code Example](/https://github.com/maricotagc/Selectors/blob/main/SelectBox.java)
8. Multi Select Box: [Code Example](/https://github.com/maricotagc/Selectors/blob/main/MultiSelectBox.java)
9. Upload Image: [Code Example](/https://github.com/maricotagc/Selectors/blob/main/UploadFile.java)

## Approach for same selector containing many elements

Example: 

<picture>
  <source media="(prefers-color-scheme: dark)" srcset="https://github.com/maricotagc/Selectors/blob/main/Images/selector_many_elements.jpg">
  <img alt="Shows an illustrated sun in light mode and a moon with stars in dark mode." src="https://github.com/maricotagc/Selectors/blob/main/Images/selector_many_elements.jpg">
</picture>

Solution: 
1. To get element above and assign it to a variable.
2. From this variable create a 
