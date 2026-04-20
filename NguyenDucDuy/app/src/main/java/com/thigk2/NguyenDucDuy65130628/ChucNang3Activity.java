package com.thigk2.NguyenDucDuy65130628;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class ChucNang3Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chuc_nang3);

        ListView lvDanhNhan = findViewById(R.id.lvDanhNhan);
        Button btnQuayLai = findViewById(R.id.btnQuayLai);

        ArrayList<DanhNhan> dsDanhNhan = new ArrayList<>();
        dsDanhNhan.add(new DanhNhan("Võ Nguyên Giáp", "Quảng Bình", R.drawable._506309_hinh_anh_dai_tuong_vo_nguyen_giap_3));
        dsDanhNhan.add(new DanhNhan("Trần Hưng Đạo", "Nam Định", R.drawable._22505631081866ecc6o16102014095340));
        dsDanhNhan.add(new DanhNhan("Quang Trung", "Bình Định", R.drawable.tranh_ve_vua_quang_trung_13_jpg));
        dsDanhNhan.add(new DanhNhan("Lê Lợi", "Thanh Hóa", R.drawable.le));
        dsDanhNhan.add(new DanhNhan("Ngô Quyền", "Hà Tây", R.drawable.tlx14));

        DanhNhanAdapter adapter = new DanhNhanAdapter(this, dsDanhNhan);
        lvDanhNhan.setAdapter(adapter);

        btnQuayLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
