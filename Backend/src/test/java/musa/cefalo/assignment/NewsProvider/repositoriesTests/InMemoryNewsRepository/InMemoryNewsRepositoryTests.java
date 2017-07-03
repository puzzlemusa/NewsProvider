package musa.cefalo.assignment.NewsProvider.repositoriesTests.InMemoryNewsRepository;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/musa/cefalo/assignment/NewsProvider/repositoriesTests/InMemoryNewsRepository/feature.feature",
        plugin = {"pretty", "html:CucumberReports/InMemoryNewsRepository"})
public class InMemoryNewsRepositoryTests {
}
