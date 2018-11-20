package com.ghozay19.praditaapps.main.admin.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ghozay19.praditaapps.R;
import com.ghozay19.praditaapps.main.admin.matakuliah.DetailMatakuliah;
import com.ghozay19.praditaapps.model.matakuliah.Matakuliah;

import java.util.List;

public class MatakuliahAdapter extends RecyclerView.Adapter<MatakuliahAdapter.ViewHolder> {

   private List<Matakuliah> mList;
   private Context ctx;

   public MatakuliahAdapter(Context ctx, List<Matakuliah> mList){
       this.ctx = ctx;
       this.mList = mList;
   }


    @Override
    public MatakuliahAdapter.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType){

        View v = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.list_matakuliah,parent, false);

        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

       holder.tvKode.setText(mList.get(position).getMatakuliahKode());
       holder.tvNama.setText(mList.get(position).getMatakuliahNama());
       holder.tvDosen.setText(mList.get(position).getMatakuliahDosen());

        Log.d("leeeeh","ada isinya ga sih"+ mList.get(position).getMatakuliahNama());

       holder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {


               Intent i = new Intent(holder.itemView.getContext(),
                       DetailMatakuliah.class);
               i.putExtra("id", mList.get(position).getMatakuliahId());
               i.putExtra("nama", mList.get(position).getMatakuliahNama());
               i.putExtra("kode", mList.get(position).getMatakuliahKode());
               i.putExtra("jurusan", mList.get(position).getMatakuliahJurusan());
               i.putExtra("dosen", mList.get(position).getMatakuliahDosen());
               holder.itemView.getContext().startActivity(i);


           }
       });



    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

       public TextView tvKode, tvNama, tvDosen;

       public ViewHolder(View v){
           super(v);

           tvKode = v.findViewById(R.id.tvKode);
           tvNama = v.findViewById(R.id.tvNama);
           tvDosen = v.findViewById(R.id.tvDosen);

       }

    }
}
