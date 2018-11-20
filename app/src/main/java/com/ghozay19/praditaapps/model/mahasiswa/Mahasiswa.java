package com.ghozay19.praditaapps.model.mahasiswa;

import com.google.gson.annotations.SerializedName;


public class Mahasiswa{

	@SerializedName("mahasiswa_alamat")
	private String mahasiswaAlamat;

	@SerializedName("mahasiswa_notelp")
	private String mahasiswaNotelp;

	@SerializedName("mahasiswa_nama")
	private String mahasiswaNama;

	@SerializedName("mahasiswa_id")
	private String mahasiswaId;

	@SerializedName("mahasiswa_nim")
	private String mahasiswaNim;

	public void setMahasiswaAlamat(String mahasiswaAlamat){
		this.mahasiswaAlamat = mahasiswaAlamat;
	}

	public String getMahasiswaAlamat(){
		return mahasiswaAlamat;
	}

	public void setMahasiswaNotelp(String mahasiswaNotelp){
		this.mahasiswaNotelp = mahasiswaNotelp;
	}

	public String getMahasiswaNotelp(){
		return mahasiswaNotelp;
	}

	public void setMahasiswaNama(String mahasiswaNama){
		this.mahasiswaNama = mahasiswaNama;
	}

	public String getMahasiswaNama(){
		return mahasiswaNama;
	}

	public void setMahasiswaId(String mahasiswaId){
		this.mahasiswaId = mahasiswaId;
	}

	public String getMahasiswaId(){
		return mahasiswaId;
	}

	public void setMahasiswaNim(String mahasiswaNim){
		this.mahasiswaNim = mahasiswaNim;
	}

	public String getMahasiswaNim(){
		return mahasiswaNim;
	}

	@Override
 	public String toString(){
		return 
			"Mahasiswa{" + 
			"mahasiswa_alamat = '" + mahasiswaAlamat + '\'' + 
			",mahasiswa_notelp = '" + mahasiswaNotelp + '\'' + 
			",mahasiswa_nama = '" + mahasiswaNama + '\'' + 
			",mahasiswa_id = '" + mahasiswaId + '\'' + 
			",mahasiswa_nim = '" + mahasiswaNim + '\'' + 
			"}";
		}
}