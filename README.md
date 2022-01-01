
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
