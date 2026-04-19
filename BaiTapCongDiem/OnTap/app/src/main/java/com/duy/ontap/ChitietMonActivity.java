package com.duy.ontap;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ChitietMonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitiet_mon);

        TextView txtTenMon = findViewById(R.id.txtTenMon);
        
        String tenMon = getIntent().getStringExtra("ten_mon");
        if (tenMon != null) {
            txtTenMon.setText(tenMon);
        }
    }
}