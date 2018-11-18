package com.ghozay19.praditaapps.main.user.fragment;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ghozay19.praditaapps.R;
import com.ghozay19.praditaapps.main.admin.adapter.MahasiswaAdapter;
import com.ghozay19.praditaapps.main.admin.mahasiswa.ReadMahasiswaActivity;
import com.ghozay19.praditaapps.main.user.adapter.JadwalAdapter;
import com.ghozay19.praditaapps.model.jadwal.Jadwal;
import com.ghozay19.praditaapps.model.jadwal.ResponseJadwal;
import com.ghozay19.praditaapps.model.mahasiswa.ResponsMahasiswa;
import com.ghozay19.praditaapps.network.ConfigRetrofit;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class JadwalFragment extends Fragment {


    public JadwalFragment() {
        // Required empty public constructor
    }


    JadwalAdapter adapter;
    Context context;
    RecyclerView recyclerView;
    private List<Jadwal> mItems = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View  view =  inflater.inflate(R.layout.fragment_jadwal, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_jadwal);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        adapter = new JadwalAdapter(getActivity(), mItems);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        readAllJadwal();;
        
        return view;
    }

    private void readAllJadwal() {

        final ProgressDialog dialog = ProgressDialog.show(context, "", "Fetching Data....", false);

        ConfigRetrofit.service.getAllJadwal().enqueue(new Callback<ResponseJadwal>() {
            @Override
            public void onResponse(Call<ResponseJadwal> call, Response<ResponseJadwal> response) {
                dialog.dismiss();

                mItems = response.body().getResult();
                Log.d("Read Data","Hasilnya adalah -> " + response.body().getKode());

                recyclerView.setAdapter(new JadwalAdapter(getContext(),mItems));
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<ResponseJadwal> call, Throwable t) {
                dialog.dismiss();

                Log.d("Read Data Error ","Karena -> "+t.getMessage());
                Toast.makeText(getContext(), " Koneksi EROR",Toast.LENGTH_SHORT).show();
            }
        });

    }
}