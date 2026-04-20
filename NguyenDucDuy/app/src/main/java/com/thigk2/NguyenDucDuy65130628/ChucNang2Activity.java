package com.thigk2.NguyenDucDuy65130628;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class ChucNang2Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chuc_nang2);

        ListView lvCaKhuc = findViewById(R.id.lvCaKhuc);

        ArrayList<String> dsCaKhuc = new ArrayList<>();
        dsCaKhuc.add("Tiến Quân Ca");
        dsCaKhuc.add("Diệt Phát Xít");
        dsCaKhuc.add("Giải Phóng Miền Nam");
        dsCaKhuc.add("Trường Sơn Đông Trường Sơn Tây");
        dsCaKhuc.add("Nguyễn Đức Duy (65130628)"); // Ca khúc đặc biệt
        dsCaKhuc.add("Như Có Bác Trong Ngày Đại Thắng");
        dsCaKhuc.add("Bác Đang Cùng Chúng Cháu Hành Quân");
        dsCaKhuc.add("Chào Em Cô Gái Lam Hồng");
        dsCaKhuc.add("Hành Quân Xa");
        dsCaKhuc.add("Vì Nhân Dân Quên Mình");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dsCaKhuc);
        lvCaKhuc.setAdapter(adapter);
    }
}
