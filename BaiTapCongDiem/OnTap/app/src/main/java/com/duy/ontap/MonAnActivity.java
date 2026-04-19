package com.duy.ontap;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MonAnActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mon_an);

        ListView lvMonAn = findViewById(R.id.lvMonAn);
        Button btnBack = findViewById(R.id.btnBackHomeMonAn);

        ArrayList<String> dsMonAn = new ArrayList<>();
        dsMonAn.add("Phở Bò");
        dsMonAn.add("Bún Chả");
        dsMonAn.add("Bánh Mì");
        dsMonAn.add("Gỏi Cuốn");
        dsMonAn.add("Cơm Tấm");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dsMonAn);
        lvMonAn.setAdapter(adapter);

        lvMonAn.setOnItemClickListener((parent, view, position, id) -> {
            String selectedItem = dsMonAn.get(position);
            Toast.makeText(MonAnActivity.this, "Bạn đã chọn: " + selectedItem, Toast.LENGTH_SHORT).show();
            
            Intent intent = new Intent(MonAnActivity.this, ChitietMonActivity.class);
            intent.putExtra("ten_mon", selectedItem);
            startActivity(intent);
        });

        btnBack.setOnClickListener(v -> finish());
    }
}