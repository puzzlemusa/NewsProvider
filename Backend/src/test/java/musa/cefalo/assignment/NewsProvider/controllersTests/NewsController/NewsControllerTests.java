package musa.cefalo.assignment.NewsProvider.controllersTests.NewsController;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/musa/cefalo/assignment/NewsProvider/controllersTests/NewsController/feature.feature",
        plugin = {"pretty", "html:CucumberReports/NewsController"})
public class NewsControllerTests {
}
