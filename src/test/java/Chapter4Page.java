import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Chapter4Page extends PageObject {

    @FindBy(css = "#hoverOver")
    private WebElement mouseOverElement;

    public void mouseoverCheck(){
        Actions act = new Actions(driver);
        act.moveToElement(mouseOverElement).perform();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("The alert text was: " + alertText);
        alert.accept();
    }

    public Chapter4Page(WebDriver driver) {
        super(driver);
    }
}
