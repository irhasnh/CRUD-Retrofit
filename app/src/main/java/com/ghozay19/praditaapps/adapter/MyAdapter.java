package com.ghozay19.praditaapps.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ghozay19.praditaapps.UpdateDeleteActivity;
import com.ghozay19.praditaapps.model.Mahasiswa;
import com.ghozay19.praditaapps.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<Mahasiswa> mList;
    private Context ctx;


    public MyAdapter(Context ctx, List<Mahasiswa> mList) {
        this.ctx = ctx;
        this.mList = mList;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_mahasiswa, parent, false);

        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.tvNim.setText(mList.get(position).getMahasiswaNim());
        holder.tvNama.setText(mList.get(position).getMahasiswaNama());
        holder.tvAlamat.setText(mList.get(position).getMahasiswaAlamat());
        holder.tvNoTelp.setText(mList.get(position).getMahasiswaNotelp());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(holder.itemView.getContext(),
                        UpdateDeleteActivity.class);
                i.putExtra("id", mList.get(position).getMahasiswaId());
                i.putExtra("nim", mList.get(position).getMahasiswaNim());
                i.putExtra("nama", mList.get(position).getMahasiswaNama());
                i.putExtra("alamat", mList.get(position).getMahasiswaAlamat());
                i.putExtra("no_telp", mList.get(position).getMahasiswaNotelp());
                holder.itemView.getContext().startActivity(i);

            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvNim, tvNama, tvAlamat, tvNoTelp;

        public ViewHolder(View v) {
            super(v);

            tvNim = v.findViewById(R.id.txt_nim);
            tvNama = v.findViewById(R.id.txt_nama);
            tvAlamat = v.findViewById(R.id.txt_alamat);
            tvNoTelp = v.findViewById(R.id.txt_notelp);

        }
    }
}

