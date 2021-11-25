package com.pbo.entity;

public class Siswa {
    private String nama;
    private String nis;
    private String kelas;
    private String alamat;

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    @Override
    public String toString() {
        return "Siswa{" +
                "nama='" + nama + '\'' +
                ", nis='" + nis + '\'' +
                ", kelas='" + kelas + '\'' +
                ", alamat='" + alamat + '\'' +
                ", id=" + id +
                '}';
    }
}
