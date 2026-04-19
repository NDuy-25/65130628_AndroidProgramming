package com.duy.ontap;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BaiThuocAdapter extends RecyclerView.Adapter<BaiThuocAdapter.ViewHolder> {

    private List<BaiThuoc> dsBaiThuoc;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(BaiThuoc item);
    }

    public BaiThuocAdapter(List<BaiThuoc> dsBaiThuoc, OnItemClickListener listener) {
        this.dsBaiThuoc = dsBaiThuoc;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bai_thuoc, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BaiThuoc item = dsBaiThuoc.get(position);
        holder.txtTen.setText(item.getTen());
        holder.txtThoiGian.setText("Thời gian: " + item.getThoiGian());
        holder.itemView.setOnClickListener(v -> listener.onItemClick(item));
    }

    @Override
    public int getItemCount() {
        return dsBaiThuoc.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTen, txtThoiGian;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTen = itemView.findViewById(R.id.txtTenBaiThuoc);
            txtThoiGian = itemView.findViewById(R.id.txtThoiGian);
        }
    }
}