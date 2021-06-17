import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomepageAccessible extends HomePage{

    private final String expectedHeaderText = "Selenium: Beginners Guide";

    @FindBy(css ="body:nth-child(2) > div.mainheading")
    private WebElement header;
    private final String headerText = header.getText();

    public void checkHomepageHeader() {
        Assert.assertEquals(this.headerText, this.expectedHeaderText);
    }


    public HomepageAccessible(WebDriver driver) {
        super(driver);
    }
}
