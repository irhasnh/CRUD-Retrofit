package com.ghozay19.praditaapps.admin.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ghozay19.praditaapps.R;
import com.ghozay19.praditaapps.admin.dosen.DetailDosen;
import com.ghozay19.praditaapps.admin.mahasiswa.DetailMahasiswaActivity;
import com.ghozay19.praditaapps.model.Dosen;
import com.ghozay19.praditaapps.model.Mahasiswa;

import java.util.List;

public class DosenAdapter extends RecyclerView.Adapter<DosenAdapter.ViewHolder> {

    private List<Dosen> mList;
    private Context ctx;


    public DosenAdapter(Context ctx, List<Dosen> mList) {
        this.ctx = ctx;
        this.mList = mList;
    }

    @Override
    public DosenAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_dosen, parent, false);

        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.tvNim.setText(mList.get(position).getDosenNid());
        holder.tvNama.setText(mList.get(position).getDosenNama());
        holder.tvMatkul.setText(mList.get(position).getDosenMatakuliah());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(holder.itemView.getContext(),
                        DetailDosen.class);
                i.putExtra("id", mList.get(position).getDosenId());
                i.putExtra("nid", mList.get(position).getDosenNid());
                i.putExtra("nama", mList.get(position).getDosenNama());
                i.putExtra("matakuliah", mList.get(position).getDosenMatakuliah());
                i.putExtra("no_telp", mList.get(position).getDosenNotelp());
                holder.itemView.getContext().startActivity(i);

            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvNim, tvNama, tvMatkul;

        public ViewHolder(View v) {
            super(v);

            tvMatkul = v.findViewById(R.id.tvMatkul);
            tvNim = v.findViewById(R.id.tvNim);
            tvNama = v.findViewById(R.id.tvNama);


        }
    }
}

