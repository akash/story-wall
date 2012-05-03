package acceptance;

import org.junit.Test;
import util.page.CreateNewStoryPage;
import util.page.NavigateTo;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.notNull;

public class CreateNewStoryTests extends AcceptanceTestBase{
    
    @Test
    public void shouldAllowUserToEnterTitleAndEstimate(){
        CreateNewStoryPage page = NavigateTo.createStoryPage(driver);

        assertThat(page.titleField(), is(not(nullValue())));
        assertThat(page.titleField().getAttribute("title"), is(notNull()));
        assertThat(page.estimateField(), is(not(nullValue())));
        assertThat(page.estimateField().getAttribute("estimate"), is(notNull()));
    }
}
