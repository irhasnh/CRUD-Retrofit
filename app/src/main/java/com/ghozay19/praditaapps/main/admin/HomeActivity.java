package com.ghozay19.praditaapps.main.admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ghozay19.praditaapps.R;
import com.ghozay19.praditaapps.main.admin.dosen.DosenActivity;
import com.ghozay19.praditaapps.main.admin.mahasiswa.ReadMahasiswaActivity;
import com.ghozay19.praditaapps.main.admin.matakuliah.MatakuliahActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends AppCompatActivity {

    @OnClick(R.id.btnReadMahasiswa)
    void Read(){
        Intent intent = new Intent(this,ReadMahasiswaActivity.class);
        startActivity(intent);
    }


    @OnClick(R.id.btnreadDosen)
    void ReadDosen(){
        Intent intent = new Intent(this,DosenActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.btnreadMatakuliah)
    void ReadMatakuliah(){
        Intent intent = new Intent(this,MatakuliahActivity.class);
        startActivity(intent);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ButterKnife.bind(this);

    }
}
