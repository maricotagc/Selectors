public class TechlisticTest
{
    SeleniumUtil seleniumUtil;
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        WebDriverFactory webDriverFactory = new WebDriverFactory();
        driver = webDriverFactory.createChromeDriver();
        seleniumUtil = new SeleniumUtil(driver);

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
        seleniumUtil.clickButtonById("ezmob-footer-close");
        seleniumUtil.clickButtonById("cookieChoiceDismiss");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
  
    @Test
    public void RadioButtonTest(){
        //Given
        WebElement female;
        WebElement experience;

        //When
        seleniumUtil.clickButtonById("sex-1");
        female = driver.findElement(By.id("sex-1"));

        seleniumUtil.clickButtonById("exp-4");
        experience = driver.findElement(By.id("exp-4"));

        //Then
        Assertions.assertTrue(female.isSelected());
        Assertions.assertTrue(experience.isSelected());
    }
