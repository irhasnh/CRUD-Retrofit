package com.ghozay19.praditaapps.model.jadwal;

import com.google.gson.annotations.SerializedName;


public class Jadwal {

	@SerializedName("jadwal_ruangan")
	private String jadwalRuangan;

	@SerializedName("jadwal_id")
	private String jadwalId;

	@SerializedName("jadwal_waktu")
	private String jadwalWaktu;

	@SerializedName("jadwal_matakuliah")
	private String jadwalMatakuliah;

	@SerializedName("jadwal_dosen")
	private String jadwalDosen;

	public void setJadwalRuangan(String jadwalRuangan){
		this.jadwalRuangan = jadwalRuangan;
	}

	public String getJadwalRuangan(){
		return jadwalRuangan;
	}

	public void setJadwalId(String jadwalId){
		this.jadwalId = jadwalId;
	}

	public String getJadwalId(){
		return jadwalId;
	}

	public void setJadwalWaktu(String jadwalWaktu){
		this.jadwalWaktu = jadwalWaktu;
	}

	public String getJadwalWaktu(){
		return jadwalWaktu;
	}

	public void setJadwalMatakuliah(String jadwalMatakuliah){
		this.jadwalMatakuliah = jadwalMatakuliah;
	}

	public String getJadwalMatakuliah(){
		return jadwalMatakuliah;
	}

	public void setJadwalDosen(String jadwalDosen){
		this.jadwalDosen = jadwalDosen;
	}

	public String getJadwalDosen(){
		return jadwalDosen;
	}

	@Override
 	public String toString(){
		return 
			"Jadwal{" +
			"jadwal_ruangan = '" + jadwalRuangan + '\'' + 
			",jadwal_id = '" + jadwalId + '\'' + 
			",jadwal_waktu = '" + jadwalWaktu + '\'' + 
			",jadwal_matakuliah = '" + jadwalMatakuliah + '\'' + 
			",jadwal_dosen = '" + jadwalDosen + '\'' + 
			"}";
		}
}