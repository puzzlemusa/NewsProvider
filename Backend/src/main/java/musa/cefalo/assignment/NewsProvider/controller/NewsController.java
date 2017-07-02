package musa.cefalo.assignment.NewsProvider.controller;


import musa.cefalo.assignment.NewsProvider.model.News;
import musa.cefalo.assignment.NewsProvider.services.NewsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * News controller.
 */
@RestController
@RequestMapping("/news")
public class NewsController {
    private NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @CrossOrigin(origins = "*", allowedHeaders = {"if-none-match"})
    @RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, method = RequestMethod.GET)
    public ResponseEntity<List<News>> getAllNews(){
        List<News> newsList = this.newsService.findAll();
        return new ResponseEntity<>(newsList, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*", allowedHeaders = {"if-none-match"})
    @RequestMapping(value = "/{id}")
    public ResponseEntity<News> getNews(@PathVariable("id") int id){
        News news = this.newsService.findOne(id);
        return new ResponseEntity<>(news, HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<News> createNews(@RequestBody News news) {
        News newNews = this.newsService.save(news);
        return new ResponseEntity<>(newNews, HttpStatus.CREATED);
    }
}
