package com.duy.tuychinhlv;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;
import android.view.View;
import android.widget.AdapterView;

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
        // Tìm ListView
        ListView lvdsMonAn = (ListView) findViewById(R.id.lvdsMon);

        // Cb dữ liệu
        ArrayList<MonAn> dsMon = new ArrayList<MonAn>();
        MonAn m1 = new MonAn("Bạc Xĩu", 45.000,"Nếu Phin Sữa Đá dành cho các bạn đam mê vị đậm đà, thì Bạc Xỉu Đá là một sự lựa chọn", R.drawable.bacxiu);
        MonAn m2 = new MonAn("Trà Sen Vàng", 65000,"Hương vị tự nhiên, thơm ngon của Trà Việt với phong cách hiện đại tại Highlands Coffee sẽ giúp bạn gợi mở vị giác của bản thân và tận hưởng một cảm giác thật khoan khoái, tươi mới.", R.drawable.trasenvang);
        MonAn m3 = new MonAn("Trà Củ Năng", 65.000,"Hương vị tự nhiên, thơm ngon của Trà Việt với phong cách hiện đại tại Highlands Coffee sẽ giúp bạn gợi mở vị giác của bản thân và tận hưởng một cảm giác thật khoan khoái, tươi mới.",R.drawable.tracunang);
        MonAn m4 = new MonAn("Freeze MatCha", 69.000,"Freeze Trà Xanh thơm ngon, mát lạnh, chinh phục bất cứ ai!",R.drawable.matcha);
        dsMon.add(m1);
        dsMon.add(m2);
        dsMon.add(m3);
        dsMon.add(m4);
        //
        MonAnAdapter adapter = new MonAnAdapter(this, dsMon);
        lvdsMonAn.setAdapter(adapter);
        // Bắt xử lý sự kiện
        lvdsMonAn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            // Lấy phần tử được chọn
                MonAn monAn = dsMon.get(i);
                Toast.makeText(MainActivity.this, monAn.getTenMonAn(), Toast.LENGTH_SHORT).show();
            
            }
        });
    }
}