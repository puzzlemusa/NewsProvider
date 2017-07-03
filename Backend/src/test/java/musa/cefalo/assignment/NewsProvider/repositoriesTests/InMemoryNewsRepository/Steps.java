package musa.cefalo.assignment.NewsProvider.repositoriesTests.InMemoryNewsRepository;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import musa.cefalo.assignment.NewsProvider.model.News;
import musa.cefalo.assignment.NewsProvider.repositories.InMemoryNewsRepositoryImpl;
import musa.cefalo.assignment.NewsProvider.repositories.NewsRepository;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ContextConfiguration(classes = {InMemoryNewRepositoryTestConfiguration.class})
public class Steps {

    @Autowired
    private HashMap<String, Object> testContext;

    private NewsRepository newsRepository;

    @Before
    public void Initialize()
    {
        newsRepository = new InMemoryNewsRepositoryImpl();
        testContext = new HashMap<>();
    }

    @Given("^an existing news$")
    public void anExistingNews(Map<String, String> newsMap) throws Throwable {
        News news = new News();
        news.setNewsId(Integer.parseInt(newsMap.get("newsId")));
        news.setTitle(newsMap.get("title"));
        news.setBody(newsMap.get("body"));
        news.setAuthor(newsMap.get("author"));
        news.setPublishDate(new SimpleDateFormat("yyyy-MM-dd").parse(newsMap.get("publishDate")));

        testContext.put("ExpectedNews", news);
        newsRepository.save(news);
    }

    @Given("^an existing list of news$")
    public void anExistingListOfNews(List<Map<String, String>> newsMapList) throws Throwable {
        ArrayList<News> result = new ArrayList<>();

        for(Map<String, String> newsMap: newsMapList){
            News news = new News();
            news.setNewsId(Integer.parseInt(newsMap.get("newsId")));
            news.setTitle(newsMap.get("title"));
            news.setBody(newsMap.get("body"));
            news.setAuthor(newsMap.get("author"));
            news.setPublishDate(new SimpleDateFormat("yyyy-MM-dd").parse(newsMap.get("publishDate")));

            result.add(news);
            newsRepository.save(news);
        }

        testContext.put("ExpectedNewsList", result);
    }

    @When("^a new News is saved$")
    public void postReqForCreatingNews(Map<String, String> newsMap) throws Exception{
        News news = new News();
        news.setNewsId(1);
        news.setTitle(newsMap.get("title"));
        news.setBody(newsMap.get("body"));
        news.setAuthor(newsMap.get("author"));
        news.setPublishDate(new SimpleDateFormat("yyyy-MM-dd").parse(newsMap.get("publishDate")));

        testContext.put("NewsCount", newsRepository.findAll().size());
        newsRepository.save(news);
    }

    @When("^finding a News with newsId (\\d+)$")
    public void findingANewsWithNewsId(int id) throws Throwable {
        testContext.put("SavedNews", newsRepository.findOne(id));
    }

    @When("^getting all News$")
    public void gettingAllNews() throws Throwable {
        testContext.put("SavedNewsList", newsRepository.findAll());
    }

    @Then("^news list should be updated with new News$")
    public void newsListShouldBeUpdatedWithNewNews() throws Throwable {
        int newsCount = (int) testContext.get("NewsCount");
        Assert.assertEquals(newsCount + 1, newsRepository.findAll().size());
    }

    @Then("^a News is returned with expected values$")
    public void newNewsCreatedWithProperValue() throws Exception {
        News savedNews = (News)testContext.get("SavedNews");
        News expectedNews = (News)testContext.get("ExpectedNews");

        Assert.assertEquals(expectedNews.getTitle(), savedNews.getTitle());
        Assert.assertEquals(expectedNews.getBody(), savedNews.getBody());
        Assert.assertEquals(expectedNews.getAuthor(), savedNews.getAuthor());
        Assert.assertEquals(expectedNews.getPublishDate(), savedNews.getPublishDate());
    }

    @Then("^proper News list is returned$")
    public void properNewsListIsReturned() throws Throwable {
        List<News> savedNewsList = (List<News>) testContext.get("SavedNewsList");
        List<News> expectedNewsList = (List<News>) testContext.get("ExpectedNewsList");

        Assert.assertEquals(expectedNewsList.size(), savedNewsList.size());
    }
}
