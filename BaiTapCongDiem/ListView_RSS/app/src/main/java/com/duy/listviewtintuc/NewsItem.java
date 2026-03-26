package com.duy.listviewtintuc;

public class NewsItem {
    private String title;
    private String link;
    private String pubDate;
    private String imgUrl;
    private String summary;

    public NewsItem(String title, String link, String pubDate, String imgUrl, String summary) {
        this.title = title;
        this.link = link;
        this.pubDate = pubDate;
        this.imgUrl = imgUrl;
        this.summary = summary;
    }

    public String getTitle() { return title; }
    public String getLink() { return link; }
    public String getPubDate() { return pubDate; }
    public String getImgUrl() { return imgUrl; }
    public String getSummary() { return summary; }
}
