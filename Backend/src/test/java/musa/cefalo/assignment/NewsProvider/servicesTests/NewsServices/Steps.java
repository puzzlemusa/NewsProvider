package musa.cefalo.assignment.NewsProvider.servicesTests.NewsServices;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import musa.cefalo.assignment.NewsProvider.exceptions.ResourceNotFoundException;
import musa.cefalo.assignment.NewsProvider.repositories.NewsRepository;
import musa.cefalo.assignment.NewsProvider.services.NewsService;
import musa.cefalo.assignment.NewsProvider.services.NewsServiceImpl;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.HashMap;

import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {NewsServiceTestConfiguration.class})
public class Steps {

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private HashMap<String, Object> testContext;

    private NewsService newsService;

    @Before
    public void Initialize()
    {
        testContext = new HashMap<>();
        newsService = new NewsServiceImpl(newsRepository);
    }

    @Given("^news with id ([0-9]+) doesn't exist$")
    public void givenNonExistingNews(int id) throws Exception
    {
        when(newsRepository.findOne(id)).thenReturn(null);
    }

    @When("^a GET request is received for news with newsId ([0-9]+)$")
    public void getRequestReceived(int id) throws Exception
    {
        try{
            newsService.findOne(id);
        }catch (ResourceNotFoundException e){
            testContext.put("ExpectedException", e);
        }
    }

    @Then("^null is returned$")
    public void nullIsReturned() throws Throwable {
        ResourceNotFoundException expectedException = (ResourceNotFoundException) testContext.get("ExpectedException");
        Assert.assertNotNull(expectedException);
    }
}
