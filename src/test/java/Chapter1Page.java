import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class Chapter1Page extends PageObject{

    private final String expectedChapter1PageHeaderText = "Assert that this text is on the page";

    @FindBy(css ="#divontheleft")
    private WebElement chapter1PageHeader;
    private final String chapter1PageHeaderText  = chapter1PageHeader.getText();

    public void checkChapter1UniqueText() {
        Assert.assertEquals(this.chapter1PageHeaderText, this.expectedChapter1PageHeaderText);
    }
    public Chapter1Page(WebDriver driver) {
        super(driver);
    }
}
