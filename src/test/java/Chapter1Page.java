import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Chapter1Page extends PageObject{

    private final String expectedChapter1PageHeaderText = "Assert that this text is on the page";
    private final String exampleDropdownItemText1 = "Selenium Grid";
    private final String exampleDropdownItemText2 = "Selenium Core";

    @FindBy(css ="#divontheleft")
    private WebElement chapter1PageHeader;
    private final String chapter1PageHeaderText  = chapter1PageHeader.getText();
    @FindBy(css = "#selecttype")
    private WebElement dropdownElement;

    public void checkChapter1UniqueText() {
        Assert.assertEquals(this.chapter1PageHeaderText, this.expectedChapter1PageHeaderText);
    }
    public void dropdownCheck() {
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(exampleDropdownItemText1);
        dropdown.selectByVisibleText(exampleDropdownItemText2);
    }
    public Chapter1Page(WebDriver driver) {
        super(driver);
    }
}
