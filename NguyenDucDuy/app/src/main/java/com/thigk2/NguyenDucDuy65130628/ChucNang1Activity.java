package com.thigk2.NguyenDucDuy65130628;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ChucNang1Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chuc_nang1);

        EditText edtSoTien = findViewById(R.id.edtSoTien);
        EditText edtTiGia = findViewById(R.id.edtTiGia);
        Button btnDoiTien = findViewById(R.id.btnDoiTien);
        TextView tvKetQua = findViewById(R.id.tvKetQua);

        btnDoiTien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strSoTien = edtSoTien.getText().toString();
                String strTiGia = edtTiGia.getText().toString();

                if (!strSoTien.isEmpty() && !strTiGia.isEmpty()) {
                    double soTien = Double.parseDouble(strSoTien);
                    double tiGia = Double.parseDouble(strTiGia);
                    double ketQua = soTien / tiGia;
                    tvKetQua.setText("Kết quả: " + String.format("%.2f", ketQua) + " USD");
                }
            }
        });
    }
}
