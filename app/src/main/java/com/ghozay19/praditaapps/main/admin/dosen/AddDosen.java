package com.ghozay19.praditaapps.main.admin.dosen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.ghozay19.praditaapps.R;
import com.ghozay19.praditaapps.model.ResponseDosen;
import com.ghozay19.praditaapps.network.ConfigRetrofit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddDosen extends AppCompatActivity {



    @BindView(R.id.edt_nid_inputan)
    EditText edtNid;
    @BindView(R.id.edt_nama_inputan)
    EditText edtNama;
    @BindView(R.id.edt_matakuliah_inputan)
    EditText edtMatakuliah;
    @BindView(R.id.edt_notelp_inputan)
    EditText edtNoTelp;

    String nid, nama, matakuliah, notelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dosen);
        ButterKnife.bind(this);


    }

    @OnClick(R.id.btnSave)
    void SimpanData() {

        nid = edtNid.getText().toString().trim();
        nama = edtNama.getText().toString().trim();
        matakuliah = edtMatakuliah.getText().toString().trim();
        notelp = edtNoTelp.getText().toString().trim();


        ConfigRetrofit.service.insertdosen(nid, nama, matakuliah, notelp).enqueue(new Callback<ResponseDosen>() {
            @Override
            public void onResponse(Call<ResponseDosen> call, Response<ResponseDosen> response) {
                String kode = response.body().getKode();


                Log.d("Add Data","input dosen  -> " + response.body().getPesan());

                if (kode.equals("1")) {
                    Toast.makeText(AddDosen.this, getString(R.string.suksessimpan), Toast.LENGTH_SHORT).show();


                } else {
                    Toast.makeText(AddDosen.this, getString(R.string.gagalsimpan), Toast.LENGTH_SHORT).show();

                }

                Intent intent = new Intent(AddDosen.this,DosenActivity.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<ResponseDosen> call, Throwable t) {
                Log.d("Server Error", t.getMessage());
            }
        });

    }

}
