package musa.cefalo.assignment.NewsProvider.servicesTests.NewsServices;

import musa.cefalo.assignment.NewsProvider.repositories.NewsRepository;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;

public class NewsServiceTestConfiguration {

    @Mock
    NewsRepository newsRepository;

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

    @Bean
    NewsRepository getNewsRepository() {return this.newsRepository;}
}
