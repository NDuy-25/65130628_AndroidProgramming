package com.thigk2.NguyenDucDuy65130628;

public class DanhNhan {
    private String ten;
    private String queQuan;
    private int hinhAnh;

    public DanhNhan(String ten, String queQuan, int hinhAnh) {
        this.ten = ten;
        this.queQuan = queQuan;
        this.hinhAnh = hinhAnh;
    }

    public String getTen() { return ten; }
    public String getQueQuan() { return queQuan; }
    public int getHinhAnh() { return hinhAnh; }
}
