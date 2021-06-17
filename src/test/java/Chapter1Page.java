import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class Chapter1Page extends PageObject{

    private final String expectedChapter1PageHeaderText = "Assert that this text is on the page";
    private final String exampleDropdownItemText1 = "Selenium Grid";
    private final String exampleDropdownItemText2 = "Selenium Core";

    @FindBy(css ="#divontheleft")
    private WebElement chapter1PageHeader;
    private final String chapter1PageHeaderText  = chapter1PageHeader.getText();
    @FindBy(css = "#selecttype")
    private WebElement dropdownElement;
    @FindBy(css = "#verifybutton")
    private WebElement button;
    @FindBy(xpath = "/html[1]/body[1]/div[5]")
    private WebElement popupLink;
    @FindBy(css = "#loadajax")
    private WebElement ajaxLink;

    public void checkChapter1UniqueText() {
        Assert.assertEquals(this.chapter1PageHeaderText, this.expectedChapter1PageHeaderText);
    }
    public void dropdownCheck() {
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(exampleDropdownItemText1);
        dropdown.selectByVisibleText(exampleDropdownItemText2);
    }
    public void buttonCheck() {
        if(button.isDisplayed()){
            System.out.println("Verify button is there");
        } else {
            System.out.println("Verify button is not displayed");
        }
    }

    public void popupWindowCheck() throws InterruptedException {
        popupLink.click();
        Set<String> handler = driver.getWindowHandles();
        Iterator<String> it = handler.iterator();
        String parentWindowId = it.next();
        System.out.println("Parent window id: " + parentWindowId);
        String childWindowId = it.next();
        System.out.println("Child window id: " + childWindowId);
        driver.switchTo().window(childWindowId);
        WebElement popupWindowText = driver.findElement(By.cssSelector("#popuptext"));
        if(popupWindowText.isDisplayed()){
            System.out.println(popupWindowText.getText());
        } else {
            System.out.println("Popup window text is not displayed");
        }
        driver.findElement(By.cssSelector("#closepopup")).click();
        driver.switchTo().window(parentWindowId);
    }

    public void ajaxCheck() {
        ajaxLink.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement ajaxText = driver.findElement(By.xpath("/html[1]/body[1]/div[9]/p[1]"));
        if (ajaxText.isDisplayed()){
            System.out.println("Ajax text is displayed which reads: " + ajaxText.getText());
        } else {
            System.out.println("Ajax text is not displayed!");
        }
    }



    public Chapter1Page(WebDriver driver) {
        super(driver);
    }
}
