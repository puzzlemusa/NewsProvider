package musa.cefalo.assignment.NewsProvider.services;

import musa.cefalo.assignment.NewsProvider.exceptions.ResourceNotFoundException;
import musa.cefalo.assignment.NewsProvider.model.News;
import musa.cefalo.assignment.NewsProvider.repositories.NewsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of new service.
 */
@Service
public class NewsServiceImpl implements NewsService {

    private NewsRepository newsService;

    public NewsServiceImpl(NewsRepository newsRepository) {
        this.newsService = newsRepository;
    }

    @Override
    public News save(News news) {
        return this.newsService.save(news);
    }

    @Override
    public News findOne(int id) {
        News news = this.newsService.findOne(id);
        if(news == null)
            throw new ResourceNotFoundException("No such news");

        return news;
    }

    @Override
    public List<News> findAll() {
        return this.newsService.findAll();
    }
}
