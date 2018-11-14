package com.ghozay19.praditaapps.admin.mahasiswa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.ghozay19.praditaapps.HomeActivity;
import com.ghozay19.praditaapps.R;
import com.ghozay19.praditaapps.model.ResponsMahasiswa;
import com.ghozay19.praditaapps.network.ConfigRetrofit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailMahasiswaActivity extends AppCompatActivity {


    @BindView(R.id.edtNim)
    EditText edtNim;
    @BindView(R.id.edtNama)
    EditText edtNama;
    @BindView(R.id.edtAlamat)
    EditText edtAlamat;
    @BindView(R.id.edtNoTelp)
    EditText edtNoTelp;


    String id, nim, nama, alamat, notelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delete);

        ButterKnife.bind(this);

        id = getIntent().getStringExtra("id");
        String nim = getIntent().getStringExtra("nim");
        String nama = getIntent().getStringExtra("nama");
        String alamat = getIntent().getStringExtra("alamat");
        String notelp = getIntent().getStringExtra("no_telp");

        edtNim.setText(nim);
        edtNama.setText(nama);
        edtAlamat.setText(alamat);
        edtNoTelp.setText(notelp);

    }

    @OnClick(R.id.btnUpdate)
    void Update() {


        nim = edtNim.getText().toString().trim();
        nama = edtNama.getText().toString().trim();
        alamat = edtAlamat.getText().toString().trim();
        notelp = edtNoTelp.getText().toString().trim();

        ConfigRetrofit.service.updateData(id, nim, nama, alamat, notelp).enqueue(new Callback<ResponsMahasiswa>() {
            @Override
            public void onResponse(Call<ResponsMahasiswa> call, Response<ResponsMahasiswa> response) {

                String kode = response.body().getKode();

                Log.d("Update Data","Hasilnya adalah -> " + response.body().getKode());

                if (kode.equals("1")) {
                    Toast.makeText(DetailMahasiswaActivity.this, getString(R.string.datasuksesperbarui), Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(DetailMahasiswaActivity.this, getString(R.string.dataerorperbarui), Toast.LENGTH_SHORT).show();

                }

                Intent intent = new Intent(DetailMahasiswaActivity.this, HomeActivity.class);
                startActivity(intent);
            }


        @Override
        public void onFailure (Call <ResponsMahasiswa> call, Throwable t){
            Log.d("Server Error", t.getMessage());

        }
    });

}


    @OnClick(R.id.btnDelete)
    void Delete(){

        ConfigRetrofit.service.deleteData(id).enqueue(new Callback<ResponsMahasiswa>() {
            @Override
            public void onResponse(Call<ResponsMahasiswa> call, Response<ResponsMahasiswa> response) {
                String kode = response.body().getKode();
                Log.d("Delete Data","Hasilnya adalah -> " + response.body().getKode());
                if (kode.equals("1")){
                    Log.d("idnya","adalah"+id);
                    Toast.makeText(DetailMahasiswaActivity.this, getString(R.string.sukseshapus), Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(DetailMahasiswaActivity.this, getString(R.string.gagaldihapus), Toast.LENGTH_SHORT).show();

                }

                Intent intent = new Intent(DetailMahasiswaActivity.this,HomeActivity.class);
                startActivity(intent);
                }


            @Override
            public void onFailure(Call<ResponsMahasiswa> call, Throwable t) {
                Log.d("Server Error", t.getMessage());
            }
        });


    }

}
