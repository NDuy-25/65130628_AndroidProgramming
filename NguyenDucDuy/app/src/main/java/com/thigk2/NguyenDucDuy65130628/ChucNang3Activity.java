package com.thigk2.NguyenDucDuy65130628;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class ChucNang3Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chuc_nang3);

        ListView lvDanhNhan = findViewById(R.id.lvDanhNhan);

        ArrayList<DanhNhan> dsDanhNhan = new ArrayList<>();
        dsDanhNhan.add(new DanhNhan("Võ Nguyên Giáp", "Quảng Bình", R.mipmap.ic_launcher));
        dsDanhNhan.add(new DanhNhan("Trần Hưng Đạo", "Nam Định", R.mipmap.ic_launcher));
        dsDanhNhan.add(new DanhNhan("Quang Trung", "Bình Định", R.mipmap.ic_launcher));
        dsDanhNhan.add(new DanhNhan("Lê Lợi", "Thanh Hóa", R.mipmap.ic_launcher));
        dsDanhNhan.add(new DanhNhan("Ngô Quyền", "Hà Tây", R.mipmap.ic_launcher));

        DanhNhanAdapter adapter = new DanhNhanAdapter(this, dsDanhNhan);
        lvDanhNhan.setAdapter(adapter);
    }
}
