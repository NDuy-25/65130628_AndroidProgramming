package com.duy.listviewtintuc;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lvNews;
    private NewsAdapter adapter;
    private List<NewsItem> newsItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvNews = findViewById(R.id.lvNews);
        newsItemList = new ArrayList<>();
        adapter = new NewsAdapter(this, R.layout.news_item, newsItemList);
        lvNews.setAdapter(adapter);

        // Xử lý sự kiện khi click vào một dòng trong ListView
        lvNews.setOnItemClickListener((parent, view, position, id) -> {
            NewsItem selectedItem = newsItemList.get(position);
            String url = selectedItem.getLink();
            
            // Mở link bằng trình duyệt
            if (url != null && !url.isEmpty()) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });

        fetchRssData("https://vnexpress.net/rss/giao-duc.rss");
    }

    private void fetchRssData(String urlString) {
        new Thread(() -> {
            List<NewsItem> items = new ArrayList<>();
            try {
                URL url = new URL(urlString);
                InputStream inputStream = url.openStream();

                XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                XmlPullParser parser = factory.newPullParser();
                parser.setInput(inputStream, null);

                int eventType = parser.getEventType();
                boolean isInsideItem = false;
                String title = "", link = "", pubDate = "", imgUrl = "", summary = "";

                while (eventType != XmlPullParser.END_DOCUMENT) {
                    if (eventType == XmlPullParser.START_TAG) {
                        String tagName = parser.getName();
                        if (tagName.equalsIgnoreCase("item")) {
                            isInsideItem = true;
                        } else if (isInsideItem) {
                            if (tagName.equalsIgnoreCase("title")) {
                                title = parser.nextText();
                            } else if (tagName.equalsIgnoreCase("link")) {
                                link = parser.nextText();
                            } else if (tagName.equalsIgnoreCase("pubDate")) {
                                pubDate = parser.nextText();
                            } else if (tagName.equalsIgnoreCase("description")) {
                                String desc = parser.nextText();
                                // Trích xuất link ảnh từ description (VNExpress RSS thường để ảnh trong thẻ img)
                                if (desc.contains("src=\"")) {
                                    int start = desc.indexOf("src=\"") + 5;
                                    int end = desc.indexOf("\"", start);
                                    if (end > start) {
                                        imgUrl = desc.substring(start, end);
                                        // Xóa các tham số query nếu có để lấy ảnh gốc
                                        int queryIndex = imgUrl.indexOf("?");
                                        if (queryIndex > 0) imgUrl = imgUrl.substring(0, queryIndex);
                                    }
                                }
                                // Trích xuất tóm tắt nội dung sau thẻ </br>
                                if (desc.contains("</br>")) {
                                    summary = desc.substring(desc.lastIndexOf("</br>") + 5).trim();
                                } else {
                                    summary = desc;
                                }
                            }
                        }
                    } else if (eventType == XmlPullParser.END_TAG) {
                        if (parser.getName().equalsIgnoreCase("item")) {
                            items.add(new NewsItem(title, link, pubDate, imgUrl, summary));
                            isInsideItem = false;
                            // Reset các biến cho item tiếp theo
                            title = ""; link = ""; pubDate = ""; imgUrl = ""; summary = "";
                        }
                    }
                    eventType = parser.next();
                }
                inputStream.close();

                // Cập nhật giao diện trên UI Thread
                new Handler(Looper.getMainLooper()).post(() -> {
                    newsItemList.clear();
                    newsItemList.addAll(items);
                    adapter.notifyDataSetChanged();
                });

            } catch (XmlPullParserException | IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
