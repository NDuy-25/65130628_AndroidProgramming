package com.duy.listviewtintuc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class NewsAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<NewsItem> newsList;

    public NewsAdapter(Context context, int layout, List<NewsItem> newsList) {
        this.context = context;
        this.layout = layout;
        this.newsList = newsList;
    }

    @Override
    public int getCount() {
        return newsList.size();
    }

    @Override
    public Object getItem(int position) {
        return newsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder {
        TextView txtTitle, txtPubDate, txtSummary;
        ImageView imgNews;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            holder.txtTitle = convertView.findViewById(R.id.txtTitle);
            holder.txtPubDate = convertView.findViewById(R.id.txtPubDate);
            holder.txtSummary = convertView.findViewById(R.id.txtSummary);
            holder.imgNews = convertView.findViewById(R.id.imgNews);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        NewsItem news = newsList.get(position);
        holder.txtTitle.setText(news.getTitle());
        holder.txtPubDate.setText(news.getPubDate());
        holder.txtSummary.setText(news.getSummary());

        if (news.getImgUrl() != null && !news.getImgUrl().isEmpty()) {
            Glide.with(context).load(news.getImgUrl()).into(holder.imgNews);
        } else {
            holder.imgNews.setImageResource(R.mipmap.ic_launcher);
        }

        return convertView;
    }
}
