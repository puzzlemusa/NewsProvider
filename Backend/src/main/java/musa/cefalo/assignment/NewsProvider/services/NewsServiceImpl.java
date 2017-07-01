package musa.cefalo.assignment.NewsProvider.services;

import musa.cefalo.assignment.NewsProvider.exceptions.ResourceNotFoundException;
import musa.cefalo.assignment.NewsProvider.model.News;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of new service.
 */
@Service
public class NewsServiceImpl implements NewsService {

    private List<News> newsList;

    public NewsServiceImpl() {
        this.newsList = new ArrayList<>();
    }

    @Override
    public News save(News news) {
        news.setId(this.newsList.size() + 1);
        newsList.add(news);
        return news;
    }

    @Override
    public News findOne(int id) {
        if(id > newsList.size() || id <= 0)
            throw new ResourceNotFoundException("No such news");

        return newsList.get(id - 1);
    }

    @Override
    public List<News> findAll() {
        return newsList;
    }
}