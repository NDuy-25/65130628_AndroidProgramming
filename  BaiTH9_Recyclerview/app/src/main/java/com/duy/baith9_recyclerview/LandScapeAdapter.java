package com.duy.baith9_recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class LandScapeAdapter extends RecyclerView.Adapter<LandScapeAdapter.ItemLandScapeViewHolder> {
    Context context;
    ArrayList<LandScape> data;

    public LandScapeAdapter(Context _context, ArrayList<LandScape> _data) {
        this.context = _context;
        this.data = _data;
    }

    @NonNull
    @Override
    public ItemLandScapeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater bom_layout = LayoutInflater.from(context);
        View viewItem = bom_layout.inflate(R.layout.item_land, parent, false);
        ItemLandScapeViewHolder viewHolder = new ItemLandScapeViewHolder(viewItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemLandScapeViewHolder holder, int position) {
        //Lấy đối tượng hiển thị
        LandScape landScapeHienThi = data.get(position);
        //Trích thông tin
        String caption = landScapeHienThi.getLandCaption();
        String tenAnh = landScapeHienThi.getLandImageFileName();
        //Đặt vào các trường thông tin của holder
        holder.textViewCaption.setText(caption);
        //đặt ảnh
        String packageName = holder.itemView.getContext().getPackageName();
        int imageId = holder.itemView.getResources().getIdentifier(tenAnh, "mipmap", packageName);
        holder.imageViewLandScape.setImageResource(imageId);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ItemLandScapeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textViewCaption;
        ImageView imageViewLandScape;

        public ItemLandScapeViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewCaption = itemView.findViewById(R.id.tvCaption);
            imageViewLandScape = itemView.findViewById(R.id.imgViewLand);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int viTriDuocClick = getAdapterPosition();
            LandScape ptDuocClick = data.get(viTriDuocClick);
            String ten = ptDuocClick.getLandCaption();
            String tenFile = ptDuocClick.getLandImageFileName();
            String chuoiThongBao = "Bạn vừa click vào: " + ten;
            Toast.makeText(v.getContext(), chuoiThongBao, Toast.LENGTH_SHORT).show();
        }
    }
}