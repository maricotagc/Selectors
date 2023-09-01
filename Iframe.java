public class TechlisticTest
{
    SeleniumUtil seleniumUtil;
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        WebDriverFactory webDriverFactory = new WebDriverFactory();
        driver = webDriverFactory.createChromeDriver();
        seleniumUtil = new SeleniumUtil(driver);
    }

    @Test
    public void iFrameTest() {
        //Given
        String expectedFirstName = "Chun-Li";
        String expectedLastName = "Moita";

        //When
        seleniumUtil.openPage("https://www.techlistic.com/p/selenium-practice-form.html");
        seleniumUtil.clickButtonByCss("#ez-accept-all");
        WebDriver frame1Driver = driver.switchTo().frame("google_ads_iframe_/1254144,22662382379/techlistic_com-pixel1_0");
        WebDriver frame2Driver = frame1Driver.switchTo().frame("ad_iframe");
        List<WebElement> spans = frame2Driver.findElements(By.tagName("span"));

        for (WebElement span : spans) {
            System.out.println("Oi" +span.getText());
            if (span.getText().equals("Close")) {
                span.click();
                break;
            }
        }

        seleniumUtil.clickButtonByCss(".ns-nnbzd-e-16");
        seleniumUtil.writeInputTextByCss("Chun-Li","firstname");
        seleniumUtil.writeInputTextByCss("Moita", "lastname");

        String actualFirstName = seleniumUtil.readInputTextValueByCss("firstname");
        String actualLastName = seleniumUtil.readInputTextValueByCss("lastname");

        //Then
        Assertions.assertEquals(expectedFirstName, actualFirstName);
        Assertions.assertEquals(expectedLastName, actualLastName);
    }
}
