package com.duy.tuychinhlv;

public class MonAn {
    private String tenMonAn;
    private double donGia;
    private String moTa;
    private int images;

    public MonAn(String tenMonAn, double donGia, String moTa, int images) {
        this.tenMonAn = tenMonAn;
        this.donGia = donGia;
        this.moTa = moTa;
        this.images = images;
    }
    // các getter và Setter

    public String getTenMonAn() {
        return tenMonAn;
    }

    public void setTenMonAn(String tenMonAn) {
        this.tenMonAn = tenMonAn;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }
}
