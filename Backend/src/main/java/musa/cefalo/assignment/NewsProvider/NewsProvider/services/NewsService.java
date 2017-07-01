package musa.cefalo.assignment.NewsProvider.NewsProvider.services;

import musa.cefalo.assignment.NewsProvider.NewsProvider.model.News;

import java.util.List;

/**
 * Service interface for providing news.
 */
public interface NewsService {
    public News save(News news);
    public News findOne(int id);
    public List<News> findAll();
}
