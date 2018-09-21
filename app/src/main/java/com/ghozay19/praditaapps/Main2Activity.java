package com.ghozay19.praditaapps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main2Activity extends AppCompatActivity {

    @OnClick(R.id.btnReadMahasiswa)
    void Read(){
        Intent intent = new Intent(this,ReadMahasiswaActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.btnAddMahasiswa)
    void Send(){
        Intent intent = new Intent(this,AddMahasiswaActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ButterKnife.bind(this);

    }
}
