package com.ghozay19.praditaapps.model;

import com.google.gson.annotations.SerializedName;


public class Matakuliah {

	@SerializedName("matakuliah_kode")
	private String matakuliahKode;

	@SerializedName("matakuliah_dosen")
	private String matakuliahDosen;

	@SerializedName("matakuliah_jurusan")
	private String matakuliahJurusan;

	@SerializedName("matakuliah_id")
	private String matakuliahId;

	@SerializedName("matakuliah_nama")
	private String matakuliahNama;

	public void setMatakuliahKode(String matakuliahKode){
		this.matakuliahKode = matakuliahKode;
	}

	public String getMatakuliahKode(){
		return matakuliahKode;
	}

	public void setMatakuliahDosen(String matakuliahDosen){
		this.matakuliahDosen = matakuliahDosen;
	}

	public String getMatakuliahDosen(){
		return matakuliahDosen;
	}

	public void setMatakuliahJurusan(String matakuliahJurusan){
		this.matakuliahJurusan = matakuliahJurusan;
	}

	public String getMatakuliahJurusan(){
		return matakuliahJurusan;
	}

	public void setMatakuliahId(String matakuliahId){
		this.matakuliahId = matakuliahId;
	}

	public String getMatakuliahId(){
		return matakuliahId;
	}

	public void setMatakuliahNama(String matakuliahNama){
		this.matakuliahNama = matakuliahNama;
	}

	public String getMatakuliahNama(){
		return matakuliahNama;
	}

	@Override
 	public String toString(){
		return 
			"Matakuliah{" +
			"matakuliah_kode = '" + matakuliahKode + '\'' + 
			",matakuliah_dosen = '" + matakuliahDosen + '\'' + 
			",matakuliah_jurusan = '" + matakuliahJurusan + '\'' + 
			",matakuliah_id = '" + matakuliahId + '\'' + 
			",matakuliah_nama = '" + matakuliahNama + '\'' + 
			"}";
		}
}