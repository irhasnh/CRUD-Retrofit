package com.ghozay19.praditaapps.main.user;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;

import com.ghozay19.praditaapps.R;
import com.ghozay19.praditaapps.utils.SharedPrefManager;
import com.ghozay19.praditaapps.main.user.fragment.AccountFragment;
import com.ghozay19.praditaapps.main.user.fragment.HomeFragment;
import com.ghozay19.praditaapps.main.user.fragment.JadwalFragment;

import butterknife.BindView;

public class UserActivity extends AppCompatActivity  implements BottomNavigationView.OnNavigationItemSelectedListener{

    @BindView(R.id.edt_nim_inputan)
    EditText edtNim;

    SharedPrefManager sharedPrefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

//        getSupportActionBar().hide();
        getSupportActionBar().setTitle("Pradita Mobile");

        sharedPrefManager = new SharedPrefManager(this);

        // kita set default nya Home Fragment
        loadFragment(new HomeFragment());
// inisialisasi BottomNavigaionView
        BottomNavigationView bottomNavigationView = findViewById(R.id.bn_main);
// beri listener pada saat item/menu bottomnavigation terpilih
        bottomNavigationView.setOnNavigationItemSelectedListener(this);



    }

    // method untuk load fragment yang sesuai
    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    // method listener untuk logika pemilihan
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.home_menu:
                fragment = new HomeFragment();
                break;
            case R.id.search_menu:
                fragment = new JadwalFragment();
                break;
            case R.id.account_menu:
                fragment = new AccountFragment();
                break;
        }
        return loadFragment(fragment);
    }

}
