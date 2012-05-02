package page;

import org.openqa.selenium.WebDriver;

public class NavigateTo {
    public static StoryWallPage storyWallPage(WebDriver driver) {
        driver.get("http://localhost:8080/stories");
        return new StoryWallPage(driver);
    }
}
