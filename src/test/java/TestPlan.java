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

    @AfterSuite
    public static void cleanUp(){
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
