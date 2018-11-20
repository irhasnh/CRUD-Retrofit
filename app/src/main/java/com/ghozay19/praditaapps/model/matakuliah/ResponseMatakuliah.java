package com.ghozay19.praditaapps.model.matakuliah;

import java.util.List;

public class ResponseMatakuliah {

	String kode, pesan;
	List<Matakuliah> result;

	public List<Matakuliah> getResult() {
		return result;
	}

	public void setResult(List<Matakuliah> result) {
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
