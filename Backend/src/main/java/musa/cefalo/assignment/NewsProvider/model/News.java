package musa.cefalo.assignment.NewsProvider.model;

/**
 * News Model.
 */

public class News {
    private int id;
    private String title;
    private String body;
    private String author;


    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getAuthor() {
        return author;
    }

    public void setId(int id){
        this.id = id;
    }
}
