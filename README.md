
# How to find elements in the DOM

[Page for practice](https://raphael.moita.gitlab.io/query-selectors/page-1.html)

## Exercises
1. Create a query selector to get the RED block content

    * Attribute used: id="id-1"
    * Dev Tools Console: document.querySelector("#id-1");
    * Selenium: TBC

2. Create a query selector to get the YELLOW block content
    * Attribute used: class="class-a class-b"
    * Dev Tools Console: document.querySelector(".class-a.class-b");
    * Selenium: TBC
    
3. Create a query selector to get the BLUE block content
    * Attribute used: position="3"
    * Dev Tools Console: document.querySelector("div[position='3']");
    * Selenium: TBC
    
4. Create a query selector to get the GREEN block content
    * Attribute used: span
    * Dev Tools Console: document.querySelector("span");
    * Selenium: TBC
    
5. Create a query selector to get the GRAY blockS content
    * Attribute used: style + div
    * Dev Tools Console: document.querySelectorAll("div[style='height:50px;background:green'] > div");
    * Selenium: TBC
    
6. Create a query selector to click on the button
    * Attribute used: button
    * Dev Tools Console: document.querySelector("button").click();
    * Selenium: TBC
    
7. Create a query selector to read the textarea context that will show up after clicking the button
    * Attribute used: id
    * Dev Tools Console: document.querySelector("#screen").value;
    * Selenium: TBC
