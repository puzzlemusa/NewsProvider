package musa.cefalo.assignment.NewsProvider.repositoriesTests.InMemoryNewsRepository;

import org.springframework.context.annotation.Bean;

import java.util.HashMap;

public class InMemoryNewRepositoryTestConfiguration {

    HashMap<String, Object> testContext;

    public InMemoryNewRepositoryTestConfiguration() {
        this.testContext = new HashMap<>();
    }

    @Bean
    public HashMap<String, Object> getTestContext()
    {
        return this.testContext;
    }
}
