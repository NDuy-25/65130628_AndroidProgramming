package com.thigk2.NguyenDucDuy65130628;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class ChucNang2Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chuc_nang2);

        ListView lvCaKhuc = findViewById(R.id.lvCaKhuc);
        Button btnQuayLai = findViewById(R.id.btnQuayLai);

        ArrayList<String> dsCaKhuc = new ArrayList<>();
        dsCaKhuc.add("1. Tiến Quân Ca");
        dsCaKhuc.add("2. Diệt Phát Xít");
        dsCaKhuc.add("3. Giải Phóng Miền Nam");
        dsCaKhuc.add("4. Trường Sơn Đông Trường Sơn Tây");
        dsCaKhuc.add("5. Như Có Bác Trong Ngày Đại Thắng");
        dsCaKhuc.add("6. Nguyễn Đức Duy");
        dsCaKhuc.add("7. Bác Đang Cùng Chúng Cháu Hành Quân");
        dsCaKhuc.add("8. Chào Em Cô Gái Lam Hồng");
        dsCaKhuc.add("9. Hành Quân Xa");
        dsCaKhuc.add("10. Vì Nhân Dân Quên Mình");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dsCaKhuc);
        lvCaKhuc.setAdapter(adapter);

        btnQuayLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
