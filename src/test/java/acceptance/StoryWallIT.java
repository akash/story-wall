package acceptance;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import util.page.NavigateTo;
import util.page.StoryWallPage;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StoryWallIT extends AcceptanceTestBase {

    @Test
    public void shouldShowColumns() throws Exception {
        StoryWallPage page = NavigateTo.storyWallPage(driver);

        List<WebElement> columns = page.getSwimlanes();
        assertThat(columns.size(), is(3));
        assertThat(columns.get(0).findElement(By.tagName("h2")).getText(), is("Backlog"));
        assertThat(columns.get(1).findElement(By.tagName("h2")).getText(), is("In Progress"));
        assertThat(columns.get(2).findElement(By.tagName("h2")).getText(), is("Done"));
    }

}
