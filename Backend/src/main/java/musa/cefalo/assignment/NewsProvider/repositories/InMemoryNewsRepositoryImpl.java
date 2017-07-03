package musa.cefalo.assignment.NewsProvider.repositories;

import musa.cefalo.assignment.NewsProvider.model.News;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of NewsRepository.
 */
@Repository
public class InMemoryNewsRepositoryImpl implements NewsRepository {
    private List<News> newsList;

    public InMemoryNewsRepositoryImpl() {
        this.newsList = new ArrayList<>();
    }

    @Override
    public News save(News news) {
        news.setNewsId(this.newsList.size() + 1);
        newsList.add(news);
        return news;
    }

    @Override
    public News findOne(int id) {
        if(id > newsList.size() || id <= 0)
            return null;

        return newsList.get(id - 1);
    }

    @Override
    public List<News> findAll() {
        return newsList;
    }
}
