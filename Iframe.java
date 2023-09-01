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
        seleniumUtil.clickButtonById("#ezmob-footer-close");
        seleniumUtil.clickButtonById("#cookieChoiceDismiss");
        seleniumUtil.writeInputTextByCss("Chun-Li","[name='firstname']");
        seleniumUtil.writeInputTextByCss("Moita", "[name='lastname']");

        String actualFirstName = seleniumUtil.readInputTextValueByCss("[name='firstname']");
        String actualLastName = seleniumUtil.readInputTextValueByCss("[name='lastname']");

        //Then
        Assertions.assertEquals(expectedFirstName, actualFirstName);
        Assertions.assertEquals(expectedLastName, actualLastName);
    }
}
