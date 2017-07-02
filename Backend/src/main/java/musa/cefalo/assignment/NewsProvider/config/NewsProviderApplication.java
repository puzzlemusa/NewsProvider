package musa.cefalo.assignment.NewsProvider.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"musa.cefalo.assignment.NewsProvider.controller", "musa.cefalo.assignment.NewsProvider.config",	"musa.cefalo.assignment.NewsProvider.services",	"musa.cefalo.assignment.NewsProvider.repositories"})
public class NewsProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsProviderApplication.class, args);
	}
}
