package com.igk.retrofitjava;

public class Articles {
    public String title;
    public String description;
    public String content;
    public String url;
    public String urlToImage;

    public Articles(String title, String description, String content,String urlToImage) {
        this.title = title;
        this.description = description;
        this.content = content;
        this.urlToImage = urlToImage;
    }

}
