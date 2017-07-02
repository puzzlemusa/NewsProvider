package musa.cefalo.assignment.NewsProvider.servicesTests.NewsServices;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/musa/cefalo/assignment/NewsProvider/servicesTests/NewsServices/feature.feature",
        plugin = {"pretty", "html:CucumberReports/NewsService"})
public class NewsServiceTests {
}
