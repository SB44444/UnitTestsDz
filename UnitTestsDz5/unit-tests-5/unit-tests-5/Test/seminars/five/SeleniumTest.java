package seminars.five;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import org.junit.Test;
import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertTrue;


public class SeleniumTest {
    @Test
    public  void testOpenSite(){
        WebDriver webDriver=new ChromeDriver();
        webDriver.get("https://www.google.com");
        WebElement webElement=webDriver.findElement(By.name("q"));
        webElement.sendKeys("Selenium");
        webElement.submit();

        List<WebElement> result = webDriver.findElements(By.cssSelector("div"));

        boolean found=false;
        for (WebElement element : result) {
            if (element.getText().contains("selenium.dev")){
                found=true;
                break;
            }
        }

        assertTrue(found);
        webDriver.quit();

    }

}
