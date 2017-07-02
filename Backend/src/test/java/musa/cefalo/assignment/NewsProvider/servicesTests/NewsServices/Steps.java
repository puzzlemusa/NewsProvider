package musa.cefalo.assignment.NewsProvider.servicesTests.NewsServices;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import musa.cefalo.assignment.NewsProvider.model.News;
import musa.cefalo.assignment.NewsProvider.repositories.InMemoryNewsRepository;
import org.junit.Assert;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.HashMap;

import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {NewsServiceTestConfiguration.class})
public class Steps {

    @Autowired
    private InMemoryNewsRepository inMemoryNewsRepository;

    @Autowired
    private HashMap<String, Object> testContext;

    @Before
    public void Initialize()
    {
        reset(testContext);
    }

    @Given("^news with id ([0-9]+) doesn't exist$")
    public void givenNonExistingNews(int id) throws Exception
    {
        when(inMemoryNewsRepository.findOne(id)).thenReturn(null);
    }

    @When("^a GET request is received for news with newsId ([0-9]+)$")
    public void getRequestReceived(int id) throws Exception
    {
        testContext.put("ExpectedNews", inMemoryNewsRepository.findOne(id));
    }

    @Then("^null is returned$")
    public void nullIsReturned() throws Throwable {
        News expectedNews = (News) testContext.get("ExpectedNews");
        Assert.assertNull(expectedNews);
    }
}
