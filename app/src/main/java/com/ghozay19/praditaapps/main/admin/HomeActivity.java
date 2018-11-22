package com.ghozay19.praditaapps.main.admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.ghozay19.praditaapps.LoginActivity;
import com.ghozay19.praditaapps.R;
import com.ghozay19.praditaapps.utils.SharedPrefManager;
import com.ghozay19.praditaapps.main.admin.dosen.DosenActivity;
import com.ghozay19.praditaapps.main.admin.mahasiswa.ReadMahasiswaActivity;
import com.ghozay19.praditaapps.main.admin.matakuliah.MatakuliahActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends AppCompatActivity {

    @OnClick(R.id.btnReadMahasiswa)
    void Read() {
        Intent intent = new Intent(this, ReadMahasiswaActivity.class);
        startActivity(intent);
    }


    @OnClick(R.id.btnReadDosen)
    void ReadDosen() {
        Intent intent = new Intent(this, DosenActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.btnReadMatakuliah)
    void ReadMatakuliah() {
        Intent intent = new Intent(this, MatakuliahActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.btnLogout)
    void Logout() {
        sharedPrefManager.saveSPBoolean(SharedPrefManager.SP_SUDAH_LOGIN, false);
        startActivity(new Intent(this, LoginActivity.class)
                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));

        finish();
    }

    @OnClick(R.id.btnInfo)
    void Info(){
        Intent intent = new Intent(this,AboutActivity.class);
        startActivity(intent);
    }

    @BindView(R.id.imageView)
    ImageView images;

    SharedPrefManager sharedPrefManager;
    String image = "https://studn.id/assets/images/campus/logo/PraditaInstitute_f917e993f3599d8174ce6008da4b3a1b.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        ButterKnife.bind(this);

        sharedPrefManager = new SharedPrefManager(this);

        Glide.with(this)
                .load(image)
                .into(images);
    }
}
