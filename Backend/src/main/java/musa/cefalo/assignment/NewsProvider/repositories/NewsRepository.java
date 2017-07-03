package musa.cefalo.assignment.NewsProvider.repositories;

import musa.cefalo.assignment.NewsProvider.model.News;

import java.util.List;

/**
 * Interface for news repository.
 */
public interface NewsRepository {
    News save(News news);
    News findOne(int id);
    List<News> findAll();
}
