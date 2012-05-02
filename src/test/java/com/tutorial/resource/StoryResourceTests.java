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
        // Given
        List<Story> expectedStories = asList(mock(Story.class));
        DBCursor<Story> mockCursor = mock(DBCursor.class);
        given(storyCollection.find()).willReturn(mockCursor);
        given(mockCursor.toArray()).willReturn(expectedStories);

        // When
        StoriesView view = resource.viewWall(Optional.<String>absent());

        // Then
        assertThat(view.getTemplateName(), is("wall.ftl"));
        assertThat(view.getStories(), is(expectedStories));
    }
}
