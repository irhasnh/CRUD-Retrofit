package com.ghozay19.praditaapps.model.dosen;

import com.google.gson.annotations.SerializedName;

public class Dosen {

	@SerializedName("dosen_id")
	private String dosenId;

	@SerializedName("dosen_notelp")
	private String dosenNotelp;

	@SerializedName("dosen_nid")
	private String dosenNid;

	@SerializedName("dosen_nama")
	private String dosenNama;

	@SerializedName("dosen_matakuliah")
	private String dosenMatakuliah;

	public void setDosenId(String dosenId){
		this.dosenId = dosenId;
	}

	public String getDosenId(){
		return dosenId;
	}

	public void setDosenNotelp(String dosenNotelp){
		this.dosenNotelp = dosenNotelp;
	}

	public String getDosenNotelp(){
		return dosenNotelp;
	}

	public void setDosenNid(String dosenNid){
		this.dosenNid = dosenNid;
	}

	public String getDosenNid(){
		return dosenNid;
	}

	public void setDosenNama(String dosenNama){
		this.dosenNama = dosenNama;
	}

	public String getDosenNama(){
		return dosenNama;
	}

	public void setDosenMatakuliah(String dosenMatakuliah){
		this.dosenMatakuliah = dosenMatakuliah;
	}

	public String getDosenMatakuliah(){
		return dosenMatakuliah;
	}

	@Override
 	public String toString(){
		return 
			"Dosen{" +
			"dosen_id = '" + dosenId + '\'' + 
			",dosen_notelp = '" + dosenNotelp + '\'' + 
			",dosen_nid = '" + dosenNid + '\'' + 
			",dosen_nama = '" + dosenNama + '\'' + 
			",dosen_matakuliah = '" + dosenMatakuliah + '\'' + 
			"}";
		}
}