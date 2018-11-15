package com.ghozay19.praditaapps.main.admin.mahasiswa;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.ghozay19.praditaapps.R;
import com.ghozay19.praditaapps.main.admin.adapter.MahasiswaAdapter;
import com.ghozay19.praditaapps.model.Mahasiswa;
import com.ghozay19.praditaapps.model.ResponsMahasiswa;
import com.ghozay19.praditaapps.network.ConfigRetrofit;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReadMahasiswaActivity extends AppCompatActivity {

    @BindView(R.id.rv_mahasiswa)
    RecyclerView recyclerView;
    Context context;
    MahasiswaAdapter adapter;
    private List<Mahasiswa> mItems = new ArrayList<>();

    @OnClick(R.id.btnAdd)
    void Send(){
        Intent intent = new Intent(this,AddMahasiswaActivity.class);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mahasiswa);

        ButterKnife.bind(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        adapter = new MahasiswaAdapter(getApplicationContext(), mItems);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        ReadData();
    }

    private void ReadData() {
        final ProgressDialog dialog = ProgressDialog.show(this, "", "Fetching Data....", false);

        ConfigRetrofit.service.getAllData().enqueue(new Callback<ResponsMahasiswa>() {
            @Override
            public void onResponse(Call<ResponsMahasiswa> call, Response<ResponsMahasiswa> response) {
                dialog.dismiss();

                mItems = response.body().getResult();
                Log.d("Read Data","Hasilnya adalah -> " + response.body().getKode());
                  
                recyclerView.setAdapter(new MahasiswaAdapter(getApplicationContext(),mItems));
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<ResponsMahasiswa> call, Throwable t) {
                dialog.dismiss();

                Log.d("Read Data Error ","Karena -> "+t.getMessage());
                Toast.makeText(ReadMahasiswaActivity.this, " Koneksi EROR",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
