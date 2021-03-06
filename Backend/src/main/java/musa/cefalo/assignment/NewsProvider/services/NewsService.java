package musa.cefalo.assignment.NewsProvider.services;

import musa.cefalo.assignment.NewsProvider.model.News;

import java.util.List;

/**
 * Service interface for providing news.
 */
public interface NewsService {
    News save(News news);
    News findOne(int id);
    List<News> findAll();
}
