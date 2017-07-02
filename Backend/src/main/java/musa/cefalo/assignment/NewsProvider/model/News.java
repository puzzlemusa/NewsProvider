package musa.cefalo.assignment.NewsProvider.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * News Model.
 */

public class News {
    private int newsId;
    private String title;
    private String body;
    private String author;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date publishDate;

    public int getNewsId() {return newsId;}

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getAuthor() {
        return author;
    }

    public void setNewsId(int newsId){
        this.newsId = newsId;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }
}
