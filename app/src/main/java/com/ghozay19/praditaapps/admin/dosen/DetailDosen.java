package com.ghozay19.praditaapps.admin.dosen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.ghozay19.praditaapps.HomeActivity;
import com.ghozay19.praditaapps.R;
import com.ghozay19.praditaapps.admin.mahasiswa.DetailMahasiswaActivity;
import com.ghozay19.praditaapps.model.ResponsMahasiswa;
import com.ghozay19.praditaapps.model.ResponseDosen;
import com.ghozay19.praditaapps.network.ConfigRetrofit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailDosen extends AppCompatActivity {


    @BindView(R.id.edtNID)
    EditText edtNid;
    @BindView(R.id.edtNama)
    EditText edtNama;
    @BindView(R.id.edtMatakuliah)
    EditText edtMatakuliah;
    @BindView(R.id.edtNoTelp)
    EditText edtNoTelp;


    String id, nid, nama, matakuliah, notelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_dosen);

        ButterKnife.bind(this);

        id = getIntent().getStringExtra("id");
        String nid = getIntent().getStringExtra("nid");
        String nama = getIntent().getStringExtra("nama");
        String matakuliah = getIntent().getStringExtra("matakuliah");
        String notelp = getIntent().getStringExtra("no_telp");

        edtNid.setText(nid);
        edtNama.setText(nama);
        edtMatakuliah.setText(matakuliah);
        edtNoTelp.setText(notelp);

    }

    @OnClick(R.id.btnUpdate)
    void Update() {


        nid = edtNid.getText().toString().trim();
        nama = edtNama.getText().toString().trim();
        matakuliah = edtMatakuliah.getText().toString().trim();
        notelp = edtNoTelp.getText().toString().trim();

        ConfigRetrofit.service.updateDosen(id, nid, nama, matakuliah, notelp).enqueue(new Callback<ResponseDosen>() {
            @Override
            public void onResponse(Call<ResponseDosen> call, Response<ResponseDosen> response) {

                String kode = response.body().getKode();

                Log.d("Update Data","Hasilnya adalah -> " + response.body().getKode());

                if (kode.equals("1")) {
                    Toast.makeText(DetailDosen.this, getString(R.string.datasuksesperbarui), Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(DetailDosen.this, getString(R.string.dataerorperbarui), Toast.LENGTH_SHORT).show();

                }

                Intent intent = new Intent(DetailDosen.this, DosenActivity.class);
                startActivity(intent);
            }


            @Override
            public void onFailure (Call <ResponseDosen> call, Throwable t){
                Log.d("Server Error", t.getMessage());

            }
        });

    }


    @OnClick(R.id.btnDelete)
    void Delete(){

        ConfigRetrofit.service.deteleDosen(id).enqueue(new Callback<ResponseDosen>() {
            @Override
            public void onResponse(Call<ResponseDosen> call, Response<ResponseDosen> response) {
                String kode = response.body().getKode();
                Log.d("Delete Data","Hasilnya adalah -> " + response.body().getKode());
                if (kode.equals("1")){
                    Log.d("idnya","adalah"+id);
                    Toast.makeText(DetailDosen.this, getString(R.string.sukseshapus), Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(DetailDosen.this, getString(R.string.gagaldihapus), Toast.LENGTH_SHORT).show();

                }

                Intent intent = new Intent(DetailDosen.this,DosenActivity.class);
                startActivity(intent);
            }


            @Override
            public void onFailure(Call<ResponseDosen> call, Throwable t) {
                Log.d("Server Error", t.getMessage());
            }
        });


    }

}
