package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class StoryWallPage {
    private WebDriver driver;

    public StoryWallPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getSwimlanes() {
        return driver.findElements(By.className("wall-column"));
    }
}
