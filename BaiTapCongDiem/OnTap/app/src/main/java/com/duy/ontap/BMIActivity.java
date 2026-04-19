package com.duy.ontap;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BMIActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        EditText edtHeight = findViewById(R.id.edtHeight);
        EditText edtWeight = findViewById(R.id.edtWeight);
        Button btnCalculate = findViewById(R.id.btnCalculate);
        TextView txtResult = findViewById(R.id.txtResult);
        Button btnBackHome = findViewById(R.id.btnBackHome);

        btnCalculate.setOnClickListener(v -> {
            String heightStr = edtHeight.getText().toString();
            String weightStr = edtWeight.getText().toString();

            if (!heightStr.isEmpty() && !weightStr.isEmpty()) {
                float height = Float.parseFloat(heightStr) / 100;
                float weight = Float.parseFloat(weightStr);
                float bmi = weight / (height * height);

                String category;
                if (bmi < 18.5) category = "Gầy";
                else if (bmi < 24.9) category = "Bình thường";
                else if (bmi < 29.9) category = "Tiền béo phì";
                else category = "Béo phì";

                String result = String.format("BMI: %.2f\nPhân loại: %s", bmi, category);
                txtResult.setText(result);
                Toast.makeText(this, result, Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            }
        });

        btnBackHome.setOnClickListener(v -> {
            finish();
        });
    }
}