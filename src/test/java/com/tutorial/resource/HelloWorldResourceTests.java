package com.tutorial.resource;

import com.google.common.base.Optional;
import com.tutorial.core.Saying;
import com.tutorial.repository.SayingRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.Status.OK;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class HelloWorldResourceTests {

    @Mock private SayingRepository sayingCollection;
    private HelloWorldResource resource;

    @Before
    public void setUp(){
        resource = new HelloWorldResource(sayingCollection);
    }

    @Test
    public void shouldPassAllStoriesToTemplate(){
        // Given
        given(sayingCollection.findByLanguage("fr")).willReturn(new Saying("hello %s", "fr"));

        // When
        Response response = resource.sayHello(Optional.<String>absent(), Optional.of("fr"));

        // Then
        assertThat(response.getStatus(), is(OK.getStatusCode()));
//        assertThat(response.getEntity().toString(), is("hello Stranger"));
    }
}
