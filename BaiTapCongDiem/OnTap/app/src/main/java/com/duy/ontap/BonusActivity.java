package com.duy.ontap;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BonusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bonus);

        EditText edtSoA = findViewById(R.id.edtSoA);
        EditText edtSoB = findViewById(R.id.edtSoB);
        Button btnTinhTong = findViewById(R.id.btnTinhTong);
        TextView txtKetQua = findViewById(R.id.txtKetQuaTong);

        btnTinhTong.setOnClickListener(v -> {
            String sA = edtSoA.getText().toString();
            String sB = edtSoB.getText().toString();

            if (!sA.isEmpty() && !sB.isEmpty()) {
                try {
                    double a = Double.parseDouble(sA);
                    double b = Double.parseDouble(sB);
                    double tong = a + b;
                    txtKetQua.setText("Kết quả: " + tong);
                } catch (NumberFormatException e) {
                    Toast.makeText(this, "Vui lòng nhập số hợp lệ", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Vui lòng nhập đầy đủ hai số", Toast.LENGTH_SHORT).show();
            }
        });
    }
}