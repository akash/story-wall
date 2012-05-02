package unit.com.tutorial;

import com.tutorial.HelloWorldConfiguration;
import com.tutorial.HelloWorldService;
import com.tutorial.MongoManaged;
import com.yammer.dropwizard.config.Environment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class HelloWorldServiceTests {
    @Mock private Environment environment;

    @Test
    public void shouldConfigureEnvironment() throws Exception {
        new HelloWorldService().initialize(new HelloWorldConfiguration(), environment);

        verify(environment).manage(any(MongoManaged.class));
        verify(environment, times(2)).addResource(any());
    }
}