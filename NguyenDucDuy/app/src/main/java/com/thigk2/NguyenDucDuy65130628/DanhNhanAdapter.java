package com.thigk2.NguyenDucDuy65130628;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class DanhNhanAdapter extends BaseAdapter {
    private Context context;
    private List<DanhNhan> danhSach;

    public DanhNhanAdapter(Context context, List<DanhNhan> danhSach) {
        this.context = context;
        this.danhSach = danhSach;
    }

    @Override
    public int getCount() { return danhSach.size(); }

    @Override
    public Object getItem(int position) { return danhSach.get(position); }

    @Override
    public long getItemId(int position) { return position; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_danh_nhan, parent, false);
        }

        DanhNhan dn = danhSach.get(position);
        ImageView img = convertView.findViewById(R.id.imgDanhNhan);
        TextView tvTen = convertView.findViewById(R.id.tvTenDanhNhan);
        TextView tvQue = convertView.findViewById(R.id.tvQueQuan);

        img.setImageResource(dn.getHinhAnh());
        tvTen.setText(dn.getTen());
        tvQue.setText(dn.getQueQuan());

        return convertView;
    }
}
