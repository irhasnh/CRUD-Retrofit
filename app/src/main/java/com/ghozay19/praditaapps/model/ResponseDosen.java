package com.ghozay19.praditaapps.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class ResponseDosen{


	String kode, pesan;
	List<Dosen> result;

	public List<Dosen> getResult() {
		return result;
	}

	public void setResult(List<Dosen> result) {
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
