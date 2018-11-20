package com.ghozay19.praditaapps.main.admin.matakuliah;

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
import com.ghozay19.praditaapps.main.admin.adapter.MatakuliahAdapter;
import com.ghozay19.praditaapps.model.matakuliah.Matakuliah;
import com.ghozay19.praditaapps.model.matakuliah.ResponseMatakuliah;
import com.ghozay19.praditaapps.network.ConfigRetrofit;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MatakuliahActivity extends AppCompatActivity {


    @BindView(R.id.rv_mahasiswa)
    RecyclerView recyclerView;

    Context context;

    MatakuliahAdapter adapter;

    private List<Matakuliah> mItems = new ArrayList<>();


    @OnClick(R.id.btnAdd)
    void Send(){
        Intent intent = new Intent(this, AddMatakuliahActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matakuliah);

        ButterKnife.bind(this);


        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        adapter = new MatakuliahAdapter(getApplicationContext(), mItems);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        ReadData();
    }

    private void ReadData() {
        final ProgressDialog dialog = ProgressDialog.show(this, "", "Fetching Data....", false);

        ConfigRetrofit.service.getAllMatakuliah().enqueue(new Callback<ResponseMatakuliah>() {
            @Override
            public void onResponse(Call<ResponseMatakuliah> call, Response<ResponseMatakuliah> response) {
                dialog.dismiss();

                mItems  = response.body().getResult();
                Log.d("Read Data","Hasilnya adalah -> " + response.body().getKode());

                recyclerView.setAdapter(new MatakuliahAdapter(getApplicationContext(),mItems));
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<ResponseMatakuliah> call, Throwable t) {
                dialog.dismiss();

                Log.d("Read Data Error ","Karena -> "+t.getMessage());
                Toast.makeText(MatakuliahActivity.this, " Koneksi EROR",Toast.LENGTH_SHORT).show();
            }
        });

    }
}

