package com.duy.ontap;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnBMI = findViewById(R.id.btnBMI);
        Button btnMonAn = findViewById(R.id.btnMonAn);
        Button btnBaiThuoc = findViewById(R.id.btnBaiThuoc);
        Button btnGioiThieu = findViewById(R.id.btnGioiThieu);

        btnBMI.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, BMIActivity.class);
            startActivity(intent);
        });

        btnMonAn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MonAnActivity.class);
            startActivity(intent);
        });

        btnBaiThuoc.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, BaiThuocActivity.class);
            startActivity(intent);
        });

        btnGioiThieu.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, GioiThieuActivity.class);
            startActivity(intent);
        });
    }
}