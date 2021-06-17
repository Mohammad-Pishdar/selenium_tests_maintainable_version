import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Chapter4Page extends PageObject {

    @FindBy(css = "#hoverOver")
    private WebElement mouseOverElement;
    @FindBy(css = "#blurry")
    private WebElement inputField;

    public void mouseoverCheck(){
        Actions act = new Actions(driver);
        act.moveToElement(mouseOverElement).perform();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("The alert text was: " + alertText);
        alert.accept();
    }

    public void inputFieldValueAlerted(){
        inputField.sendKeys("Selenium test");
        driver.findElement(By.cssSelector("#selectLoad")).click();
        Alert alert2 = driver.switchTo().alert();
        String alert2Text = alert2.getText();
        if(alert2Text.equals("Selenium test")) {
            System.out.println("The input test was successfully shown on alert");
        } else {
            System.out.println("Alert text does not match the input text");
        }
        alert2.accept();
    }

    public Chapter4Page(WebDriver driver) {
        super(driver);
    }
}
