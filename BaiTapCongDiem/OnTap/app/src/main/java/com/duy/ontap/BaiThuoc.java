package com.duy.ontap;

public class BaiThuoc {
    private String ten;
    private String thoiGian;
    private String moTa;

    public BaiThuoc(String ten, String thoiGian, String moTa) {
        this.ten = ten;
        this.thoiGian = thoiGian;
        this.moTa = moTa;
    }

    public String getTen() { return ten; }
    public String getThoiGian() { return thoiGian; }
    public String getMoTa() { return moTa; }
}