import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Chapter2Page extends PageObject{

    @FindBy(xpath = "//div[contains(@id, 'time')]")
    private WebElement dynamicElement;

    public void findElementWithDynamicallyChangedID() {
        for (int i = 0; i < 2; i++) {
            if(dynamicElement.isDisplayed()){
                System.out.println("Found element with dynamic id on page");
            } else {
                System.out.println("Cannot find element with dynamic id on page");
            }
            driver.navigate().refresh();
        }
    }

    public void findAnElementUsingItsName() {
        driver.findElement(By.name("but2"));
        System.out.println("Button with a name attribute was found on Chapter2 page");
    }

    public void findElementUsingItsPrecedingSibling() {
        WebElement sibling = driver.findElement(By.xpath("//input[@id=\"but1\"]/following-sibling::input"));
        System.out.println("The value attribute of sibling button reads: " + sibling.getAttribute("value"));
    }

    public Chapter2Page(WebDriver driver) {
        super(driver);
    }
}
