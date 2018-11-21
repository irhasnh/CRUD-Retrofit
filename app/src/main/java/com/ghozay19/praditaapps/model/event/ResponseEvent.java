package com.ghozay19.praditaapps.model.event;

import com.ghozay19.praditaapps.model.jadwal.Jadwal;

import java.util.List;


public class ResponseEvent{
	String kode, pesan;
	List<Event> result;

	public List<Event> getResult() {
		return result;
	}

	public void setResult(List<Event> result) {
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