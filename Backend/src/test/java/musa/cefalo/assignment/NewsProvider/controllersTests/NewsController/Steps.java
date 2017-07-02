package musa.cefalo.assignment.NewsProvider.controllersTests.NewsController;

import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import musa.cefalo.assignment.NewsProvider.model.News;
import musa.cefalo.assignment.NewsProvider.services.NewsService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ContextConfiguration(classes = {NewsControllerTestConfiguration.class})
public class Steps {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private HashMap<String, Object> testContext;

    @Autowired
    NewsService newsService;

    @Before
    public void Initialize()
    {
        reset(newsService);
        reset(testContext);
    }

    @Given("^an existing news$")
    public void anExistingNews(Map<String, String> newsMap) throws Throwable {
        News news = new News();
        news.setNewsId(1);
        news.setTitle(newsMap.get("title"));
        news.setBody(newsMap.get("body"));
        news.setAuthor(newsMap.get("author"));
        news.setPublishDate(new SimpleDateFormat("yyyy-MM-dd").parse(newsMap.get("publishDate")));

        testContext.put("ExpectedNews", news);
        when(newsService.findOne(news.getNewsId())).thenReturn(news);
    }

    @Given("^an existing list of news$")
    public void anExistingListOfNews(List<Map<String, String>> newsMapList) throws Throwable {
        ArrayList<News> result = new ArrayList<>();

        int i = 1;
        for(Map<String, String> newsMap: newsMapList){
            News news = new News();
            news.setNewsId(i++);
            news.setTitle(newsMap.get("title"));
            news.setBody(newsMap.get("body"));
            news.setAuthor(newsMap.get("author"));
            news.setPublishDate(new SimpleDateFormat("yyyy-MM-dd").parse(newsMap.get("publishDate")));

            result.add(news);
        }

        testContext.put("ExpectedNewsList", result);
        when(newsService.findAll()).thenReturn(result);
    }

    @When("^a GET request is received on (.+)$")
    public void GetRequestReceived(String path) throws Exception
    {
        testContext.put("ResultActions", mockMvc.perform(get(path)));
    }

    @When("^a POST request is received to create a news$")
    public void postReqForCreatingNews(Map<String, String> newsMap) throws Exception{
        News news = new News();
        news.setNewsId(1);
        news.setTitle(newsMap.get("title"));
        news.setBody(newsMap.get("body"));
        news.setAuthor(newsMap.get("author"));
        news.setPublishDate(new SimpleDateFormat("yyyy-MM-dd").parse(newsMap.get("publishDate")));

        testContext.put("ExpectedNews", news);

        ArgumentCaptor<News> savedNews = ArgumentCaptor.forClass(News.class);
        when(newsService.save(savedNews.capture())).thenReturn(news);
        testContext.put("SavedNews", savedNews);

        ObjectMapper objectMapper = new ObjectMapper();

        testContext.put("ResultActions",
                mockMvc.perform(post("/news.json")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(news))));
    }

    @Then("^a new news is created with expected values$")
    public void newNewsCreatedWithProperValue() throws Exception {
        News savedNews = ((ArgumentCaptor<News>)testContext.get("SavedNews")).getValue();
        News expectedNews = (News)testContext.get("ExpectedNews");

        Assert.assertEquals(expectedNews.getTitle(), savedNews.getTitle());
        Assert.assertEquals(expectedNews.getBody(), savedNews.getBody());
        Assert.assertEquals(expectedNews.getAuthor(), savedNews.getAuthor());
    }

    @Then("^the news is returned")
    public void RecordingIsReturned() throws Exception
    {
        ((ResultActions)testContext.get("ResultActions")).andDo(result -> {
            News expectedNews = (News)testContext.get("ExpectedNews");
            String contentAsString = result.getResponse().getContentAsString();
            JSONObject jsonObject = new JSONObject(contentAsString);
            Assert.assertEquals(expectedNews.getTitle(), jsonObject.get("title"));
            Assert.assertEquals(expectedNews.getBody(), jsonObject.get("body"));
            Assert.assertEquals(expectedNews.getAuthor(), jsonObject.get("author"));
        });
    }

    @Then("^the news list is returned$")
    public void theNewsListIsReturned() throws Throwable {
        ((ResultActions)testContext.get("ResultActions")).andDo(result -> {
            News expectedNews = (News)testContext.get("ExpectedNews");
            String contentAsString = result.getResponse().getContentAsString();
            JSONArray jsonArray = new JSONArray(contentAsString);
            Assert.assertNotNull(jsonArray);
        });
    }
}
