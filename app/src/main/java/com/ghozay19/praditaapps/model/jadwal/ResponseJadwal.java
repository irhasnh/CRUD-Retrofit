package com.ghozay19.praditaapps.model.jadwal;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class ResponseJadwal{



		String kode, pesan;
		List<Jadwal> result;

		public List<Jadwal> getResult() {
			return result;
		}

		public void setResult(List<Jadwal> result) {
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