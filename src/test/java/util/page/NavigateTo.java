package util.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class NavigateTo {
    public static StoryWallPage storyWallPage(WebDriver driver) {
        driver.get("http://localhost:8080/stories");
        return new StoryWallPage(driver);
    }

    public static CreateNewStoryPage createStoryPage(HtmlUnitDriver driver) {
        driver.get("http://localhost:8080/stories/new");
        return new CreateNewStoryPage(driver);
    }
}
