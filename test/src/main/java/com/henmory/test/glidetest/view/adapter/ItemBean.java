package com.henmory.test.glidetest.view.adapter;

/**
 * author: henmory
 * time:  4/16/18
 * function:
 * description:
 */
public class ItemBean {

    private String url;
    private String title;
    private String author;
    private String publisher;
    private String date;
    private String descrption;

    public ItemBean() {
    }

    public ItemBean(String url, String title, String author, String publisher, String date, String descrption) {
        this.url = url;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.date = date;
        this.descrption = descrption;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescrption() {
        return descrption;
    }

    public void setDescrption(String descrption) {
        this.descrption = descrption;
    }
}
