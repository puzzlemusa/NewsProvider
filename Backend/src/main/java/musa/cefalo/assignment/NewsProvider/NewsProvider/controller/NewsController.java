package musa.cefalo.assignment.NewsProvider.NewsProvider.controller;


import musa.cefalo.assignment.NewsProvider.NewsProvider.model.News;
import musa.cefalo.assignment.NewsProvider.NewsProvider.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * News controller.
 */
@RestController
public class NewsController {

    private NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @RequestMapping(value = "/news", method = RequestMethod.GET)
    public ResponseEntity<List<News>> getAllNews(){
        List<News> newsList = this.newsService.findAll();
        return new ResponseEntity<>(newsList, HttpStatus.OK);
    }

    @RequestMapping(value = "/news/{id}")
    public ResponseEntity<News> getNews(@PathVariable("id") int id){
        News news = this.newsService.findOne(id);
        return new ResponseEntity<>(news, HttpStatus.OK);
    }

    @RequestMapping(value = "/news", method = RequestMethod.POST)
    public ResponseEntity<News> createNews(@RequestBody News news) {
        News newNews = this.newsService.save(news);
        return new ResponseEntity<>(newNews, HttpStatus.CREATED);
    }
}
