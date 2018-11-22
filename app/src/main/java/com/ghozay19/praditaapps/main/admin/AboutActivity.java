package com.ghozay19.praditaapps.main.admin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.ghozay19.praditaapps.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AboutActivity extends AppCompatActivity {



    String image = "https://studn.id/assets/images/campus/logo/PraditaInstitute_f917e993f3599d8174ce6008da4b3a1b.png";

ImageView images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

         images = findViewById(R.id.cImageView);

        getSupportActionBar().setTitle("About Apps");

        Glide.with(this)
                .load(image)
                .into(images);

        ButterKnife.bind(this);
    }
}
