package com.ghozay19.praditaapps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.ghozay19.praditaapps.model.Mahasiswa;
import com.ghozay19.praditaapps.model.ResponsModel;
import com.ghozay19.praditaapps.network.ConfigRetrofit;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddMahasiswaActivity extends AppCompatActivity {

    private List<Mahasiswa> mItems = new ArrayList<>();

    @BindView(R.id.edt_nim_inputan)
    EditText edtNim;
    @BindView(R.id.edt_nama_inputan)
    EditText edtNama;
    @BindView(R.id.edt_alamat_inputan)
    EditText edtAlamat;
    @BindView(R.id.edt_notelp_inputan)
    EditText edtNoTelp;

    String nim, nama, alamat, notelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_mahasiswa);
        ButterKnife.bind(this);


    }

    @OnClick(R.id.btnSave)
    void SimpanData() {

        nim = edtNim.getText().toString().trim();
        nama = edtNama.getText().toString().trim();
        alamat = edtAlamat.getText().toString().trim();
        notelp = edtNoTelp.getText().toString().trim();


        ConfigRetrofit.service.send(nim, nama, alamat, notelp).enqueue(new Callback<ResponsModel>() {
            @Override
            public void onResponse(Call<ResponsModel> call, Response<ResponsModel> response) {
                String kode = response.body().getKode();


                Log.d("Add Data","Hasilnya adalah -> " + response.body().getPesan());

                if (kode.equals("1")) {
                    Toast.makeText(AddMahasiswaActivity.this, "Data berhasil disimpan", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(AddMahasiswaActivity.this, "Data Error tidak berhasil disimpan", Toast.LENGTH_SHORT).show();

                }

                Intent intent = new Intent(AddMahasiswaActivity.this,Main2Activity.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<ResponsModel> call, Throwable t) {
                Log.d("Server Error", t.getMessage());
            }
        });

    }

}
