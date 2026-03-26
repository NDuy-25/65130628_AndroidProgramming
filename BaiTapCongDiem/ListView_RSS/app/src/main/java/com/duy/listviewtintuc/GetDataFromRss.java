package com.duy.listviewtintuc;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class GetDataFromRss {

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                URL url = new URL("https://vnexpress.net/rss/giao-duc.rss");
                InputStream inputStream = url.openStream();

                XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                XmlPullParser parser = factory.newPullParser();
                parser.setInput(inputStream, null);

                boolean isInsideItem = false;
                int eventType = parser.getEventType();

                while (eventType != XmlPullParser.END_DOCUMENT) {
                    if (eventType == XmlPullParser.START_TAG) {
                        String tagName = parser.getName();

                        if (tagName.equalsIgnoreCase("item")) {
                            isInsideItem = true;
                            System.out.println("\n------------------------------");
                        } else if (isInsideItem) {
                            if (tagName.equalsIgnoreCase("title")) {
                                System.out.println("Tiêu đề: " + parser.nextText());
                            } else if (tagName.equalsIgnoreCase("link")) {
                                System.out.println("Link: " + parser.nextText());
                            } else if (tagName.equalsIgnoreCase("pubDate")) {
                                System.out.println("Ngày đăng: " + parser.nextText());
                            } else if (tagName.equalsIgnoreCase("description")) {
                                String desc = parser.nextText();

                                // Tìm vị trí của src="
                                String imgUrl = "";
                                if (desc.contains("src=\"")) {
                                    int start = desc.indexOf("src=\"") + 5;
                                    int end = desc.indexOf("\"", start);
                                    if (end > start) {
                                        imgUrl = desc.substring(start, end);
                                        int vitriDauHoi = imgUrl.indexOf("?");
                                        if (vitriDauHoi > 0)
                                            imgUrl = imgUrl.substring(0, vitriDauHoi);
                                    }
                                }

                                // Lấy phần text sau thẻ </br>
                                String summary = "";
                                if (desc.contains("</br>")) {
                                    summary = desc.substring(desc.lastIndexOf("</br>") + 5).trim();
                                } else {
                                    summary = desc;
                                }

                                System.out.println("Ảnh minh họa: " + imgUrl);
                                System.out.println("Tóm tắt: " + summary);
                            }
                        }
                    } else if (eventType == XmlPullParser.END_TAG) {
                        if (parser.getName().equalsIgnoreCase("item")) {
                            isInsideItem = false;
                        }
                    }
                    eventType = parser.next();
                }
                inputStream.close();
            } catch (XmlPullParserException | IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
