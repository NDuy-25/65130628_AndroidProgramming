package com.duy.danhsachtinh;

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

        // Xử lý Window Insets để nội dung không bị đè bởi thanh hệ thống
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Hiển thị dữ liệu lên listview
        // B1: Chuẩn bị dữ liệu
        ArrayList<String> danhSachTinh = new ArrayList<>();
        danhSachTinh.add("Hà Nội");
        danhSachTinh.add("Hồ Chí Minh");
        danhSachTinh.add("Đà Nẵng");
        danhSachTinh.add("Hải Phòng");
        danhSachTinh.add("Cần Thơ");
        danhSachTinh.add("An Giang");
        danhSachTinh.add("Bà Rịa - Vũng Tàu");
        danhSachTinh.add("Bạc Liêu");
        danhSachTinh.add("Bắc Kạn");
        danhSachTinh.add("Bắc Giang");
        danhSachTinh.add("Bắc Ninh");
        danhSachTinh.add("Bến Tre");
        danhSachTinh.add("Bình Dương");
        danhSachTinh.add("Bình Định");
        danhSachTinh.add("Bình Phước");
        danhSachTinh.add("Bình Thuận");
        danhSachTinh.add("Cà Mau");
        // Thêm một số tỉnh khác để listview dài hơn và thấy rõ thanh cuộn
        danhSachTinh.add("Cao Bằng");
        danhSachTinh.add("Đắk Lắk");
        danhSachTinh.add("Đắk Nông");
        danhSachTinh.add("Điện Biên");
        danhSachTinh.add("Đồng Nai");
        danhSachTinh.add("Gia Lai");
        danhSachTinh.add("Hà Giang");

        // B2. Tạo adapter
        ArrayAdapter<String> adapterTinh = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                danhSachTinh);

        // B3. Gắn vào ListView
        ListView lvDanhSachTinh = findViewById(R.id.lvdsTinh);
        lvDanhSachTinh.setAdapter(adapterTinh);
    }
}
