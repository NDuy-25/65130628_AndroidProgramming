package com.duy.tuychinhlv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MonAnAdapter extends BaseAdapter {
    //

    private ArrayList<MonAn> dsMonAn;
    private LayoutInflater layoutInflater;
    private Context context;


    public MonAnAdapter( Context _context, ArrayList<MonAn> dsMonAn) {
        this.dsMonAn = dsMonAn;
        this.context = _context;
        this.layoutInflater = LayoutInflater.from(_context);

    }

    @Override
    public int getCount() {
        return dsMonAn.size();
    }

    @Override
    public Object getItem(int i) {
        return dsMonAn.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
       // view của item hiện hành
        View viewhienhanh = view;
        // Kiểm tra
        if (viewhienhanh == null) {
            viewhienhanh = layoutInflater.inflate(R.layout.item_monan, null);
        }
        //Lấy dữ liệu
        MonAn monAnHienTai = dsMonAn.get(i);
        // gán lên các điều khiển
        // Tìm điều kiện
        TextView textView_TenMon = (TextView) viewhienhanh.findViewById(R.id.tvTenMonAn);
        TextView textView_DonGia = (TextView) viewhienhanh.findViewById(R.id.tvDonGia);
        TextView textView_Mota = (TextView) viewhienhanh.findViewById(R.id.tvMota);
        ImageView imageView_Anh = (ImageView) viewhienhanh.findViewById(R.id.imAnhDaiDien);
        //Set lên
        textView_TenMon.setText(monAnHienTai.getTenMonAn());
        textView_DonGia.setText(String.valueOf(monAnHienTai.getDonGia() ));
        textView_Mota.setText(monAnHienTai.getMoTa());
        imageView_Anh.setImageResource(monAnHienTai.getImages());

        return viewhienhanh;


    }
}
