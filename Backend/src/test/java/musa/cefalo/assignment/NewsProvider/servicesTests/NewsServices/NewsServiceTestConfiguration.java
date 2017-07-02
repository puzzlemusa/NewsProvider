package musa.cefalo.assignment.NewsProvider.servicesTests.NewsServices;

import musa.cefalo.assignment.NewsProvider.repositories.InMemoryNewsRepository;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;

public class NewsServiceTestConfiguration {

    @Mock
    InMemoryNewsRepository inMemoryNewsRepository;

    HashMap<String, Object> testContext;

    public NewsServiceTestConfiguration() {
        MockitoAnnotations.initMocks(this);
        this.testContext = new HashMap<>();
    }

    @Bean
    public HashMap<String, Object> getTestContext()
    {
        return this.testContext;
    }

    @Bean InMemoryNewsRepository getInMemoryNewsRepository() {return this.inMemoryNewsRepository;}
}
