package com.ghozay19.praditaapps.main.user.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ghozay19.praditaapps.R;
import com.ghozay19.praditaapps.main.admin.dosen.DetailDosen;
import com.ghozay19.praditaapps.model.dosen.Dosen;
import com.ghozay19.praditaapps.model.jadwal.Jadwal;

import java.util.List;

public class JadwalAdapter extends RecyclerView.Adapter<JadwalAdapter.ViewHolder> {

    private List<Jadwal> mList;
    private Context ctx;


    public JadwalAdapter(Context ctx, List<Jadwal> mList) {
        this.ctx = ctx;
        this.mList = mList;
    }

    @Override
    public JadwalAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_jadwal, parent, false);

        JadwalAdapter.ViewHolder holder = new JadwalAdapter.ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(final JadwalAdapter.ViewHolder holder, final int position) {


        holder.tvMatkul.setText(mList.get(position).getJadwalMatakuliah());
        holder.tvDosen.setText(mList.get(position).getJadwalDosen());
        holder.tvRuangan.setText(mList.get(position).getJadwalRuangan());
        holder.tvWaktu.setText(mList.get(position).getJadwalWaktu());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvMatkul, tvDosen, tvRuangan, tvWaktu;

        public ViewHolder(View v) {
            super(v);

            tvDosen = v.findViewById(R.id.tvJadDosen);
            tvMatkul = v.findViewById(R.id.tvJadMatkul);
            tvRuangan = v.findViewById(R.id.tvJadRuangan);
            tvWaktu = v.findViewById(R.id.tvJadWaktu);


        }
    }
}

