import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StoryWallTests {

    @Test
    public void shouldShowColumns(){
        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080/stories");

        List<WebElement> columns = driver.findElements(By.className("wall-column"));
        assertThat(columns.size(), is(3));
        assertThat(columns.get(0).findElement(By.tagName("h2")).getText(), is("Backlog"));
        assertThat(columns.get(1).findElement(By.tagName("h2")).getText(), is("In Progress"));
        assertThat(columns.get(2).findElement(By.tagName("h2")).getText(), is("Done"));
    }
}
