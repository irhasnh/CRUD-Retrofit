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

public class UpdateDeleteActivity extends AppCompatActivity {


    private List<Mahasiswa> mItems = new ArrayList<>();

    @BindView(R.id.edt_nim_inputan)
    EditText edtNim;
    @BindView(R.id.edt_nama_inputan)
    EditText edtNama;
    @BindView(R.id.edt_alamat_inputan)
    EditText edtAlamat;
    @BindView(R.id.edt_notelp_inputan)
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

        ConfigRetrofit.service.updateData(id, nim, nama, alamat, notelp).enqueue(new Callback<ResponsModel>() {
            @Override
            public void onResponse(Call<ResponsModel> call, Response<ResponsModel> response) {

                String kode = response.body().getKode();

                Log.d("Update Data","Hasilnya adalah -> " + response.body().getKode());

                if (kode.equals("1")) {
                    Toast.makeText(UpdateDeleteActivity.this, "Data berhasil diperbaharui", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(UpdateDeleteActivity.this, "Data Error tidak berhasil diperbaharui", Toast.LENGTH_SHORT).show();

                }

                Intent intent = new Intent(UpdateDeleteActivity.this, Main2Activity.class);
                startActivity(intent);
            }


        @Override
        public void onFailure (Call < ResponsModel > call, Throwable t){
            Log.d("Server Error", t.getMessage());

        }
    });

}


    @OnClick(R.id.btnDelete)
    void Delete(){

        ConfigRetrofit.service.deleteData(id).enqueue(new Callback<ResponsModel>() {
            @Override
            public void onResponse(Call<ResponsModel> call, Response<ResponsModel> response) {
                String kode = response.body().getKode();
                Log.d("Delete Data","Hasilnya adalah -> " + response.body().getKode());
                if (kode.equals("1")){
                    Log.d("idnya","adalah"+id);
                    Toast.makeText(UpdateDeleteActivity.this, "Data berhasil dihapus", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(UpdateDeleteActivity.this, "Data Error tidak berhasil dihapus", Toast.LENGTH_SHORT).show();

                }

                Intent intent = new Intent(UpdateDeleteActivity.this,Main2Activity.class);
                startActivity(intent);
                }


            @Override
            public void onFailure(Call<ResponsModel> call, Throwable t) {
                Log.d("Server Error", t.getMessage());
            }
        });


    }

}
