package com.duy.ontap;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ChiTietBaiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_bai);

        TextView txtTen = findViewById(R.id.txtTenBaiChiTiet);
        TextView txtMoTa = findViewById(R.id.txtMoTaChiTiet);

        String ten = getIntent().getStringExtra("ten_bai");
        String moTa = getIntent().getStringExtra("mo_ta");

        if (ten != null) txtTen.setText(ten);
        if (moTa != null) txtMoTa.setText(moTa);
    }
}