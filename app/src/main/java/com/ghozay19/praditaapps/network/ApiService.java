package com.ghozay19.praditaapps.network;

import com.ghozay19.praditaapps.model.ResponsModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

import static com.ghozay19.praditaapps.BuildConfig.DELETE_MAHASISWA;
import static com.ghozay19.praditaapps.BuildConfig.INSERT_MAHASISWA;
import static com.ghozay19.praditaapps.BuildConfig.READ_MAHASISWA;
import static com.ghozay19.praditaapps.BuildConfig.UPDATE_MAHASISWA;

public interface ApiService {

    //TODO untuk Dosen



    //Mahasiswa
    @FormUrlEncoded
    @POST(INSERT_MAHASISWA)
    Call<ResponsModel> send(@Field("mahasiswa_nim") String nim,
                            @Field("mahasiswa_nama") String nama,
                            @Field("mahasiswa_alamat") String alamat,
                            @Field("mahasiswa_notelp") String notelp);

    @GET(READ_MAHASISWA)
    Call<ResponsModel> getAllData();

    @FormUrlEncoded
    @POST(UPDATE_MAHASISWA)
    Call<ResponsModel> updateData(@Field("mahasiswa_id") String id,
                                  @Field("mahasiswa_nim") String nim,
                                  @Field("mahasiswa_nama") String nama,
                                  @Field("mahasiswa_alamat") String alamat,
                                  @Field("mahasiswa_notelp") String notelp);

    @FormUrlEncoded
    @POST(DELETE_MAHASISWA)
    Call<ResponsModel> deleteData(@Field("mahasiswa_id") String id);
}

