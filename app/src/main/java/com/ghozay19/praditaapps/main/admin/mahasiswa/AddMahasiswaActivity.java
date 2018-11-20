package com.ghozay19.praditaapps.main.admin.mahasiswa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.ghozay19.praditaapps.main.admin.HomeActivity;
import com.ghozay19.praditaapps.R;
import com.ghozay19.praditaapps.model.mahasiswa.ResponsMahasiswa;
import com.ghozay19.praditaapps.network.ConfigRetrofit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddMahasiswaActivity extends AppCompatActivity {


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


        ConfigRetrofit.service.send(nim, nama, alamat, notelp).enqueue(new Callback<ResponsMahasiswa>() {
            @Override
            public void onResponse(Call<ResponsMahasiswa> call, Response<ResponsMahasiswa> response) {
                String kode = response.body().getKode();


                Log.d("Add Data","Hasilnya adalah -> " + response.body().getPesan());

                if (kode.equals("1")) {
                    Toast.makeText(AddMahasiswaActivity.this, getString(R.string.suksessimpan), Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(AddMahasiswaActivity.this, getString(R.string.gagalsimpan), Toast.LENGTH_SHORT).show();

                }

                Intent intent = new Intent(AddMahasiswaActivity.this,HomeActivity.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<ResponsMahasiswa> call, Throwable t) {
                Log.d("Server Error", t.getMessage());
            }
        });

    }

}
