package com.duy.a12coffee;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.Fragment;

public class HeaderFragment extends Fragment {

    public HeaderFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_header, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView btnMenu = view.findViewById(R.id.btnMenu);
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(v);
            }
        });
    }

    private void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(requireContext(), view);
        popupMenu.getMenuInflater().inflate(R.menu.header_menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                MainActivity mainActivity = (MainActivity) getActivity();
                if (mainActivity == null) return false;

                int id = item.getItemId();
                if (id == R.id.nav_home) {
                    mainActivity.replaceFragment(new HomeFragment());
                    return true;
                } else if (id == R.id.nav_menu) {
                    mainActivity.replaceFragment(new CoffeeMenuFragment());
                    return true;
                } else if (id == R.id.nav_intro) {
                    // Thêm dòng này để chuyển đến Giới Thiệu
                    mainActivity.replaceFragment(new GioiThieuFragment());
                    return true;
                } else if (id == R.id.nav_contact) {
                    // Nếu bạn có ContactFragment thì thêm ở đây
                    return true;
                }
                return false;
            }
        });

        popupMenu.show();
    }
}