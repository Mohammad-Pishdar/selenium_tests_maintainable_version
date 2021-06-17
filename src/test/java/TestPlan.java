import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestPlan {
    private static final WebDriver driver = new ChromeDriver();

    @BeforeSuite
    public static void main(String[] args) {
        // ChromeDriver location set up in Utils class
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
    }

    @Test(testName = "Home page is accessible")
    public static void checkHomepage(){
        driver.get(Utils.BASE_URL);
        HomepageAccessible homePage = new HomepageAccessible(driver);
        homePage.checkHomepageHeader();
    }

    @Test(testName = "Chapter 1 unique text is present")
    public static void checkChapter1Text(){
        driver.get(Utils.CHAPTER1_URL);
        Chapter1Page chapter1Page = new Chapter1Page(driver);
        chapter1Page.checkChapter1UniqueText();
    }

    @Test(testName = "Chapter 1 dropdown menu works")
    public static void checkDropdown(){
        driver.get(Utils.CHAPTER1_URL);
        Chapter1Page chapter1Page = new Chapter1Page(driver);
        chapter1Page.dropdownCheck();
    }

    @Test(testName = "Chapter 1 specific button is in there")
    public static void checkButton(){
        driver.get(Utils.CHAPTER1_URL);
        Chapter1Page chapter1Page = new Chapter1Page(driver);
        chapter1Page.buttonCheck();
    }

    @Test(testName = "Chapter 1 pop up window works")
    public static void checkPopupWindow() throws InterruptedException {
        driver.get(Utils.CHAPTER1_URL);
        Chapter1Page chapter1Page = new Chapter1Page(driver);
        chapter1Page.popupWindowCheck();
    }

    @Test(testName = "Chapter 1 ajax call works")
    public static void checkAjax() throws InterruptedException {
        driver.get(Utils.CHAPTER1_URL);
        Chapter1Page chapter1Page = new Chapter1Page(driver);
        chapter1Page.ajaxCheck();
    }

    @AfterSuite
    public static void cleanUp(){
        driver.close();
    }
}
