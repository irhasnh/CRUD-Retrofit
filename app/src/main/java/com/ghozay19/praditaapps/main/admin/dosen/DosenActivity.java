package com.ghozay19.praditaapps.main.admin.dosen;

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
import com.ghozay19.praditaapps.main.admin.adapter.DosenAdapter;
import com.ghozay19.praditaapps.model.dosen.Dosen;
import com.ghozay19.praditaapps.model.dosen.ResponseDosen;
import com.ghozay19.praditaapps.network.ConfigRetrofit;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DosenActivity extends AppCompatActivity {


    @BindView(R.id.rv_mahasiswa)
    RecyclerView recyclerView;
    Context context;
    DosenAdapter adapter;
    private List<Dosen> mItems = new ArrayList<>();


    //TODO ganti ke Add DOSEN
    @OnClick(R.id.btnAdd)
    void Send(){
        Intent intent = new Intent(this,AddDosen.class);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dosen);

        ButterKnife.bind(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        adapter = new DosenAdapter(getApplicationContext(), mItems);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        ReadData();
    }

    private void ReadData() {
        final ProgressDialog dialog = ProgressDialog.show(this, "", "Fetching Data....", false);

        ConfigRetrofit.service.getAllDosen().enqueue(new Callback<ResponseDosen>() {
            @Override
            public void onResponse(Call<ResponseDosen> call, Response<ResponseDosen> response) {
                dialog.dismiss();

                mItems = response.body().getResult();
                Log.d("Read Data","Hasilnya adalah -> " + response.body().getKode());

                recyclerView.setAdapter(new DosenAdapter(getApplicationContext(),mItems));
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<ResponseDosen> call, Throwable t) {
                dialog.dismiss();

                Log.d("Read Data Error ","Karena -> "+t.getMessage());
                Toast.makeText(DosenActivity.this, " Koneksi EROR",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
