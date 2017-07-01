package musa.cefalo.assignment.NewsProvider.model;

/**
 * News Model.
 */

public class News {
    private int newsId;
    private String title;
    private String body;
    private String author;

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
}
