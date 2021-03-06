
package com.luckynineapps.danakilat.models.pinjaman;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@SuppressWarnings("unused")
public class Pinjaman implements Serializable {

    @SerializedName("bank")
    private String mBank;
    @SerializedName("bunga")
    private String mBunga;
    @SerializedName("deskripsi_panjang")
    private String mDeskripsiPanjang;
    @SerializedName("deskripsi_singkat")
    private String mDeskripsiSingkat;
    @SerializedName("dokumen")
    private String mDokumen;
    @SerializedName("domisili_peminjam")
    private String mDomisiliPeminjam;
    @SerializedName("id")
    private String mId;
    @SerializedName("image")
    private String mImage;
    @SerializedName("lain_lain")
    private String mLainLain;
    @SerializedName("limit_pinjaman")
    private String mLimitPinjaman;
    @SerializedName("link_aplikasi")
    private String mLinkAplikasi;
    @SerializedName("max_keterlambatan")
    private String mMaxKeterlambatan;
    @SerializedName("nama_pinjaman")
    private String mNamaPinjaman;
    @SerializedName("nominal_pinjaman")
    private String mNominalPinjaman;
    @SerializedName("penghasilan_minimum")
    private String mPenghasilanMinimum;
    @SerializedName("tenor_pinjaman")
    private String mTenorPinjaman;
    @SerializedName("umur_peminjam")
    private String mUmurPeminjam;
    @SerializedName("waktu_persetujuan")
    private String mWaktuPersetujuan;
    @SerializedName("warga_negara")
    private String mWargaNegara;

    public String getBank() {
        return mBank;
    }

    public void setBank(String bank) {
        mBank = bank;
    }

    public String getBunga() {
        return mBunga;
    }

    public void setBunga(String bunga) {
        mBunga = bunga;
    }

    public String getDeskripsiPanjang() {
        return mDeskripsiPanjang;
    }

    public void setDeskripsiPanjang(String deskripsiPanjang) {
        mDeskripsiPanjang = deskripsiPanjang;
    }

    public String getDeskripsiSingkat() {
        return mDeskripsiSingkat;
    }

    public void setDeskripsiSingkat(String deskripsiSingkat) {
        mDeskripsiSingkat = deskripsiSingkat;
    }

    public String getDokumen() {
        return mDokumen;
    }

    public void setDokumen(String dokumen) {
        mDokumen = dokumen;
    }

    public String getDomisiliPeminjam() {
        return mDomisiliPeminjam;
    }

    public void setDomisiliPeminjam(String domisiliPeminjam) {
        mDomisiliPeminjam = domisiliPeminjam;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getImage() {
        return mImage;
    }

    public void setImage(String image) {
        mImage = image;
    }

    public String getLainLain() {
        return mLainLain;
    }

    public void setLainLain(String lainLain) {
        mLainLain = lainLain;
    }

    public String getLimitPinjaman() {
        return mLimitPinjaman;
    }

    public void setLimitPinjaman(String limitPinjaman) {
        mLimitPinjaman = limitPinjaman;
    }

    public String getLinkAplikasi() {
        return mLinkAplikasi;
    }

    public void setLinkAplikasi(String linkAplikasi) {
        mLinkAplikasi = linkAplikasi;
    }

    public String getMaxKeterlambatan() {
        return mMaxKeterlambatan;
    }

    public void setMaxKeterlambatan(String maxKeterlambatan) {
        mMaxKeterlambatan = maxKeterlambatan;
    }

    public String getNamaPinjaman() {
        return mNamaPinjaman;
    }

    public void setNamaPinjaman(String namaPinjaman) {
        mNamaPinjaman = namaPinjaman;
    }

    public String getNominalPinjaman() {
        return mNominalPinjaman;
    }

    public void setNominalPinjaman(String nominalPinjaman) {
        mNominalPinjaman = nominalPinjaman;
    }

    public String getPenghasilanMinimum() {
        return mPenghasilanMinimum;
    }

    public void setPenghasilanMinimum(String penghasilanMinimum) {
        mPenghasilanMinimum = penghasilanMinimum;
    }

    public String getTenorPinjaman() {
        return mTenorPinjaman;
    }

    public void setTenorPinjaman(String tenorPinjaman) {
        mTenorPinjaman = tenorPinjaman;
    }

    public String getUmurPeminjam() {
        return mUmurPeminjam;
    }

    public void setUmurPeminjam(String umurPeminjam) {
        mUmurPeminjam = umurPeminjam;
    }

    public String getWaktuPersetujuan() {
        return mWaktuPersetujuan;
    }

    public void setWaktuPersetujuan(String waktuPersetujuan) {
        mWaktuPersetujuan = waktuPersetujuan;
    }

    public String getWargaNegara() {
        return mWargaNegara;
    }

    public void setWargaNegara(String wargaNegara) {
        mWargaNegara = wargaNegara;
    }

}
