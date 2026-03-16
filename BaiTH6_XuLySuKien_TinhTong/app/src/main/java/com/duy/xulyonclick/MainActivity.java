package com.duy.xulyonclick;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Gắn Layout tương đương với file JAVA này
        setContentView(R.layout.activity_main);
    }

    public void XuLyCong(View view) {
        // Tìm tham chiếu đến điều khiển trên tập XML, mapping sang java file
        EditText editTextSoA = findViewById(R.id.edtA);
        EditText editTextSoB = findViewById(R.id.edtB);
        EditText editTextKQ = findViewById(R.id.edtKQ);

        // lấy dữ liệu về ở đk số a
        String strA = editTextSoA.getText().toString();
        // lấy dữ liệu về ở đk số b
        String strB = editTextSoB.getText().toString();

        // Kiểm tra dữ liệu trống để tránh lỗi NumberFormatException
        if (strA.isEmpty() || strB.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đủ số a và b", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            // Chuyển dữ liệu sang dạng số
            int so_A = Integer.parseInt(strA);
            int so_B = Integer.parseInt(strB);

            // Tính toán theo yêu cầu
            int tong = so_A + so_B;

            // Hiển thị kết quả

            editTextKQ.setText(String.valueOf(tong));

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Dữ liệu nhập vào không hợp lệ", Toast.LENGTH_SHORT).show();
        }
    }
}