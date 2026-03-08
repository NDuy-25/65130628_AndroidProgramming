package com.duy.maytinh;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editA, editB, editResult;
    private Button btnPlus, btnMinus, btnMultiply, btnDivide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Xử lý Window Insets để không bị lẹm vào thanh hệ thống
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Ánh xạ các View từ XML
        initViews();

        // Thiết lập sự kiện cho các nút
        setupListeners();
    }

    private void initViews() {
        editA = findViewById(R.id.editTextNumber);
        editB = findViewById(R.id.editTextNumber2);
        editResult = findViewById(R.id.editTextNumber3);

        btnPlus = findViewById(R.id.button7);
        btnMinus = findViewById(R.id.button5);
        btnMultiply = findViewById(R.id.button6);
        btnDivide = findViewById(R.id.button8);
    }

    private void setupListeners() {
        btnPlus.setOnClickListener(v -> calculate('+'));
        btnMinus.setOnClickListener(v -> calculate('-'));
        btnMultiply.setOnClickListener(v -> calculate('*'));
        btnDivide.setOnClickListener(v -> calculate('/'));
    }

    private void calculate(char operator) {
        String inputA = editA.getText().toString().trim();
        String inputB = editB.getText().toString().trim();

        if (inputA.isEmpty() || inputB.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ số A và B", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double a = Double.parseDouble(inputA);
            double b = Double.parseDouble(inputB);
            double result = 0;

            switch (operator) {
                case '+':
                    result = a + b;
                    break;
                case '-':
                    result = a - b;
                    break;
                case '*':
                    result = a * b;
                    break;
                case '/':
                    if (b == 0) {
                        Toast.makeText(this, "Không thể chia cho 0!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    result = a / b;
                    break;
            }

            // Hiển thị kết quả (làm tròn nếu là số nguyên để đẹp hơn)
            if (result == (long) result) {
                editResult.setText(String.valueOf((long) result));
            } else {
                editResult.setText(String.valueOf(result));
            }

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Dữ liệu nhập vào không hợp lệ", Toast.LENGTH_SHORT).show();
        }
    }
}