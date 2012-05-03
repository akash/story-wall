package com.tutorial.resource;

import com.google.common.base.Optional;
import com.tutorial.core.Story;
import com.tutorial.view.StoriesView;
import net.vz.mongodb.jackson.DBCursor;
import net.vz.mongodb.jackson.JacksonDBCollection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class StoryResourceTests {

    @Mock private JacksonDBCollection<Story, String> storyCollection;
    private StoryResource resource;

    @Before
    public void setUp(){
        resource = new StoryResource(storyCollection);
    }

    @Test
    public void shouldPassAllStoriesToTemplate(){
        net.vz.mongodb.jackson.
        // Given
        // ARGH! you can't mock the JacksonDbCollection??
        JacksonDBCollection<Story, String> storyCollection = mock(JacksonDBCollection.class);
        List<Story> expectedBacklog = asList(mock(Story.class));
        DBCursor<Story> mockStoryCollection = mock(DBCursor.class);
        DBCursor<Story> backlogCollection = mock(DBCursor.class);
        given(storyCollection.find()).willReturn(mockStoryCollection);
        given(mockStoryCollection.in("state", Story.State.backlog)).willReturn(backlogCollection);
        given(backlogCollection.toArray()).willReturn(expectedBacklog);

        // When
        StoriesView view = resource.viewWall(Optional.<String>absent());

        // Then
        assertThat(view.getTemplateName(), is("/wall.ftl"));
        assertThat(view.getBacklogStories(), is(expectedBacklog));
    }
}
