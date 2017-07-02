package musa.cefalo.assignment.NewsProvider.controllersTests.NewsController;

import musa.cefalo.assignment.NewsProvider.controller.NewsController;
import musa.cefalo.assignment.NewsProvider.services.NewsService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.annotation.Bean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashMap;
import java.util.Locale;

public class NewsControllerTestConfiguration {
    @Mock
    NewsService newsService;

    @InjectMocks
    NewsController newsController;

    MockMvc mockMvc;

    HashMap<String, Object> testContext;

    public NewsControllerTestConfiguration() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders
                .standaloneSetup(newsController).build();
        this.testContext = new HashMap<>();
        Locale.setDefault(Locale.US);
    }

    @Bean
    public NewsService getNewsService(){return this.newsService;}

    @Bean
    public MockMvc getMockMvc() {
        return this.mockMvc;
    }

    @Bean
    public HashMap<String, Object> getTestContext()
    {
        return this.testContext;
    }
}
