package com.ghozay19.praditaapps.model;

import java.util.List;


public class ResponsMahasiswa {

    String kode, pesan;
    List<Mahasiswa> result;

    public List<Mahasiswa> getResult() {
        return result;
    }

    public void setResult(List<Mahasiswa> result) {
        this.result = result;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }
}
