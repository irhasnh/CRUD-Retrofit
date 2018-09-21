package com.ghozay19.praditaapps.network;

import com.ghozay19.praditaapps.model.ResponsModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    @FormUrlEncoded
    @POST("insert.php")
    Call<ResponsModel> send(@Field("mahasiswa_nim") String nim,
                            @Field("mahasiswa_nama") String nama,
                            @Field("mahasiswa_alamat") String alamat,
                            @Field("mahasiswa_notelp") String notelp);

    @GET("read.php")
    Call<ResponsModel> getAllData();

    @FormUrlEncoded
    @POST("update.php")
    Call<ResponsModel> updateData(@Field("mahasiswa_id") String id,
                                  @Field("mahasiswa_nim") String nim,
                                  @Field("mahasiswa_nama") String nama,
                                  @Field("mahasiswa_alamat") String alamat,
                                  @Field("mahasiswa_notelp") String notelp);

    @FormUrlEncoded
    @POST("delete.php")
    Call<ResponsModel> deleteData(@Field("mahasiswa_id") String id);
}

