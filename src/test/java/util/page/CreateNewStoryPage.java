package util.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CreateNewStoryPage {
    private WebDriver driver;

    public CreateNewStoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement titleField() {
        List<WebElement> inputs = driver.findElement(By.tagName("form")).findElements(By.tagName("input"));
        return inputs.get(0);
    }

    public WebElement estimateField() {
        List<WebElement> inputs = driver.findElement(By.tagName("form")).findElements(By.tagName("input"));
        return inputs.get(1);

    }
}
