package com.duy.listview1;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Hiển thị dữ liệu lên listview
        //B1+: Cần có dữ liệu
        ArrayList<String> dsMon; //Khai báo
        dsMon = new ArrayList<String>(); // tạo thể hiện xụ thể
        // thêm dữ liệu vào dsMon
        dsMon.add("Cà phê");
        dsMon.add("Trà sữa");
        dsMon.add("Bánh ngọt");
        dsMon.add("Bánh mì");
        dsMon.add("Bánh quy");
        dsMon.add("Bánh bông lan");
        dsMon.add("Bánh phở");
        dsMon.add("Bánh canh");
        dsMon.add("Bánh cuốn");
        dsMon.add("Bánh giò");
        // B2. Tạo adapter
        ArrayAdapter<String> adapterMon;
        adapterMon = new ArrayAdapter<String>(this,
                                                            android.R.layout.simple_list_item_1,
                                                            dsMon);
        //B3. Gắn vào điều khiển hiển thị ListView
        //Tìm
        ListView lvDanhSachMonAn = findViewById(R.id.lvDanhSachMon);
        // Gắn
        lvDanhSachMonAn.setAdapter(adapterMon);
        // 3.3 Lắng nghe và sử lý sự kiện ng dùng tương tác
    }
}