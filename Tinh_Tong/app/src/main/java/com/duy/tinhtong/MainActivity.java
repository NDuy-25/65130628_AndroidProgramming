package com.duy.tinhtong;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edtA, edtB, edtKQ;
    Button btnTinhTong;

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

        edtA = findViewById(R.id.nhapA);
        edtB = findViewById(R.id.nhapB);
        edtKQ = findViewById(R.id.editTextNumber3);
        btnTinhTong = findViewById(R.id.KQ);

        btnTinhTong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tinhTong();
            }
        });
    }

    private void tinhTong() {
        String strA = edtA.getText().toString();
        String strB = edtB.getText().toString();

        if (!strA.isEmpty() && !strB.isEmpty()) {
            double a = Double.parseDouble(strA);
            double b = Double.parseDouble(strB);
            double tong = a + b;
            edtKQ.setText(String.valueOf(tong));
        }
    }
}