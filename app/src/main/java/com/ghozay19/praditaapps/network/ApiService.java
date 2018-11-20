package com.ghozay19.praditaapps.network;

import com.ghozay19.praditaapps.model.jadwal.ResponseJadwal;
import com.ghozay19.praditaapps.model.mahasiswa.ResponsMahasiswa;
import com.ghozay19.praditaapps.model.dosen.ResponseDosen;
import com.ghozay19.praditaapps.model.matakuliah.ResponseMatakuliah;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

import static com.ghozay19.praditaapps.BuildConfig.DELETE_DOSEN;
import static com.ghozay19.praditaapps.BuildConfig.DELETE_MAHASISWA;
import static com.ghozay19.praditaapps.BuildConfig.DELETE_MATAKULIAH;
import static com.ghozay19.praditaapps.BuildConfig.INSERT_DOSEN;
import static com.ghozay19.praditaapps.BuildConfig.INSERT_MAHASISWA;
import static com.ghozay19.praditaapps.BuildConfig.INSERT_MATAKULIAH;
import static com.ghozay19.praditaapps.BuildConfig.LOGIN_USER;
import static com.ghozay19.praditaapps.BuildConfig.READ_DOSEN;
import static com.ghozay19.praditaapps.BuildConfig.READ_JADWAL;
import static com.ghozay19.praditaapps.BuildConfig.READ_MAHASISWA;
import static com.ghozay19.praditaapps.BuildConfig.READ_MATAKULIAH;
import static com.ghozay19.praditaapps.BuildConfig.UPDATE_DOSEN;
import static com.ghozay19.praditaapps.BuildConfig.UPDATE_MAHASISWA;
import static com.ghozay19.praditaapps.BuildConfig.UPDATE_MATAKULIAH;

public interface ApiService {


    /*
    * Login User
     */

    @FormUrlEncoded
    @POST(LOGIN_USER)
    Call<ResponseBody> loginRequest(@Field("email") String email,
                                    @Field("encrypted_password") String encrypted_password);


    /**
     * Jadwal
     **/

    @GET(READ_JADWAL)
    Call<ResponseJadwal> getAllJadwal();

    /**
     * Matakuliah
     **/

    @FormUrlEncoded
    @POST(INSERT_MATAKULIAH)
    Call<ResponseMatakuliah> insertMatakuliah(@Field("matakuliah_kode") String kode,
                                              @Field("matakuliah_nama") String nama,
                                              @Field("matakuliah_jurusan") String jurusan,
                                              @Field("matakuliah_dosen") String dosen);

    @GET(READ_MATAKULIAH)
    Call<ResponseMatakuliah> getAllMatakuliah();

    @FormUrlEncoded
    @POST(UPDATE_MATAKULIAH)
    Call<ResponseMatakuliah> updateMatakuliah(@Field("matakuliah_id") String id,
                                              @Field("matakuliah_kode") String kode,
                                              @Field("matakuliah_nama") String nama,
                                              @Field("matakuliah_jurusan") String jurusan,
                                              @Field("matakuliah_dosen") String dosen);


    @FormUrlEncoded
    @POST(DELETE_MATAKULIAH)
    Call<ResponseMatakuliah> deteleMatakuliah(@Field("dosen_nid") String id);


    /**
     * DOSEN
     **/

    @FormUrlEncoded
    @POST(INSERT_DOSEN)
    Call<ResponseDosen> insertdosen(@Field("dosen_nid") String nid,
                                    @Field("dosen_nama") String nama,
                                    @Field("dosen_matakuliah") String matakuliah,
                                    @Field("dosen_notelp") String notelp);

    @GET(READ_DOSEN)
    Call<ResponseDosen> getAllDosen();

    @FormUrlEncoded
    @POST(UPDATE_DOSEN)
    Call<ResponseDosen> updateDosen(@Field("dosen_id") String id,
                                    @Field("dosen_nid") String nid,
                                    @Field("dosen_nama") String nama,
                                    @Field("dosen_matakuliah") String matakuliah,
                                    @Field("dosen_notelp") String notelp);

    @FormUrlEncoded
    @POST(DELETE_DOSEN)
    Call<ResponseDosen> deteleDosen(@Field("dosen_nid") String id);

    /**
     * Mahasiswa
     **/

    @FormUrlEncoded
    @POST(INSERT_MAHASISWA)
    Call<ResponsMahasiswa> send(@Field("mahasiswa_nim") String nim,
                                @Field("mahasiswa_nama") String nama,
                                @Field("mahasiswa_alamat") String alamat,
                                @Field("mahasiswa_notelp") String notelp);

    @GET(READ_MAHASISWA)
    Call<ResponsMahasiswa> getAllData();

    @FormUrlEncoded
    @POST(UPDATE_MAHASISWA)
    Call<ResponsMahasiswa> updateData(@Field("mahasiswa_id") String id,
                                      @Field("mahasiswa_nim") String nim,
                                      @Field("mahasiswa_nama") String nama,
                                      @Field("mahasiswa_alamat") String alamat,
                                      @Field("mahasiswa_notelp") String notelp);

    @FormUrlEncoded
    @POST(DELETE_MAHASISWA)
    Call<ResponsMahasiswa> deleteData(@Field("mahasiswa_id") String id);


}

