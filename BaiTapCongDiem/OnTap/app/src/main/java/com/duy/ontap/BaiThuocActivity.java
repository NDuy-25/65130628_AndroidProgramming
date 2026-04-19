package com.duy.ontap;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BaiThuocActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai_thuoc);

        RecyclerView rvBaiThuoc = findViewById(R.id.rvBaiThuoc);
        Button btnBack = findViewById(R.id.btnBackHomeBaiThuoc);
        
        rvBaiThuoc.setLayoutManager(new LinearLayoutManager(this));

        List<BaiThuoc> dsBaiThuoc = new ArrayList<>();
        dsBaiThuoc.add(new BaiThuoc("Bài thuốc 1", "20 phút", "Mô tả bài thuốc 1"));
        dsBaiThuoc.add(new BaiThuoc("Bài thuốc 2", "30 phút", "Mô tả bài thuốc 2"));
        dsBaiThuoc.add(new BaiThuoc("Bài thuốc 3", "15 phút", "Mô tả bài thuốc 3"));
        dsBaiThuoc.add(new BaiThuoc("Bài thuốc 4", "45 phút", "Mô tả bài thuốc 4"));

        BaiThuocAdapter adapter = new BaiThuocAdapter(dsBaiThuoc, item -> {
            Toast.makeText(BaiThuocActivity.this, "Bạn đã chọn: " + item.getTen(), Toast.LENGTH_SHORT).show();
            
            Intent intent = new Intent(BaiThuocActivity.this, ChiTietBaiActivity.class);
            intent.putExtra("ten_bai", item.getTen());
            intent.putExtra("mo_ta", item.getMoTa());
            startActivity(intent);
        });

        rvBaiThuoc.setAdapter(adapter);
        
        btnBack.setOnClickListener(v -> finish());
    }
}