package acceptance;

import org.junit.Test;
import util.page.CreateNewStoryPage;
import util.page.NavigateTo;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.notNull;

public class CreateNewStoryTests extends AcceptanceTestBase{
    
    @Test
    public void shouldAllowUserToEnterTitleAndEstimate(){
        CreateNewStoryPage page = NavigateTo.createStoryPage(driver);

        assertThat(page.titleField(), is(notNull()));
        assertThat(page.estimateField(), is(notNull()));
    }
}
