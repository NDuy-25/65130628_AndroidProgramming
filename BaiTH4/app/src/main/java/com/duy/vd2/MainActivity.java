package com.duy.vd2;

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
    EditText editTextSo1;
    EditText editTextSo2;
    EditText editTextKQ;
    Button nutCong, nutTru, nutNhan, nutChia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        TimDieuKien();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    void TimDieuKien(){
        editTextSo1 = (EditText)findViewById(R.id.edtSo1);
        editTextSo2 = (EditText)findViewById(R.id.edtSo2);
        editTextKQ = (EditText)findViewById(R.id.edtKetQua);
        nutCong =(Button) findViewById(R.id.btnCong);
        nutTru =(Button) findViewById(R.id.btnTru);
        nutNhan =(Button) findViewById(R.id.btnNhan);
        nutChia =(Button) findViewById(R.id.btnChia);
    }
    public void XuLyCong (View v){
        String soThu1= editTextSo1.getText().toString();
        String soThu2= editTextSo2.getText().toString();
        float soA = Float.parseFloat(soThu1);
        float soB = Float.parseFloat(soThu2);
        float Tong = soA + soB;
        String chuoiKQ = String.valueOf(Tong);
        editTextKQ.setText(chuoiKQ);
    }
    public void XuLyTru (View v){
        String soThu1= editTextSo1.getText().toString();
        String soThu2= editTextSo2.getText().toString();
        float soA = Float.parseFloat(soThu1);
        float soB = Float.parseFloat(soThu2);
        float Hieu = soA - soB;
        String chuoiKQ = String.valueOf(Hieu);
        editTextKQ.setText(chuoiKQ);
    }
    public void XuLyNhan (View v){
        String soThu1= editTextSo1.getText().toString();
        String soThu2= editTextSo2.getText().toString();
        float soA = Float.parseFloat(soThu1);
        float soB = Float.parseFloat(soThu2);
        float Tich = soA * soB;
        String chuoiKQ = String.valueOf(Tich);
        editTextKQ.setText(chuoiKQ);
    }
    public void XuLyChia (View v){
        String soThu1= editTextSo1.getText().toString();
        String soThu2= editTextSo2.getText().toString();
        float soA = Float.parseFloat(soThu1);
        float soB = Float.parseFloat(soThu2);
        float Thuong = soA / soB;
        String chuoiKQ = String.valueOf(Thuong);
        editTextKQ.setText(chuoiKQ);
    }
}
