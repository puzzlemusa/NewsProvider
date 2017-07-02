package musa.cefalo.assignment.NewsProvider.repositories;

import musa.cefalo.assignment.NewsProvider.model.News;

import java.util.List;

/**
 * Interface for inmemory news service.
 */
public interface InMemoryNewsRepository {
    public News save(News news);
    public News findOne(int id);
    public List<News> findAll();
}
