import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class Chapter8Page extends PageObject{

    public void testCookies(){
        Set<Cookie> ck = driver.manage().getCookies();
        System.out.println("First cookie is: " + ck.toString());
        driver.findElement(By.cssSelector("#secondCookie")).click();
        driver.navigate().refresh();
        Set <Cookie> ck2 = driver.manage().getCookies();
        System.out.println("Cookie button is pressed: \n The first cookie is now updated:\n and the second cooke also added:\n " + ck2.toString());
    }

    public Chapter8Page(WebDriver driver) {
        super(driver);
    }
}
