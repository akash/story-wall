package unit.com.tutorial.core;

import com.google.common.base.Optional;
import com.tutorial.core.Saying;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SayingTests {

    @Test
    public void shouldApplySayingWithProvidedName(){
        Saying saying = new Saying("hello %s", "en");
        assertThat(saying.apply(Optional.of("London")), is("hello London"));
    }

    @Test
    public void shouldApplySayingWithDefaultNameWhenNoneProvided(){
        Saying saying = new Saying("hello %s", "en");
        assertThat(saying.apply(Optional.<String>absent()), is("hello Stranger"));
    }

}
