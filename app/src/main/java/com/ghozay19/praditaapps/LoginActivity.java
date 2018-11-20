package com.ghozay19.praditaapps;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dd.processbutton.iml.ActionProcessButton;
import com.ghozay19.praditaapps.network.ConfigRetrofit;
import com.ghozay19.praditaapps.userVersion2.MainActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity  {

    @BindView(R.id.etEmail)
    EditText etEmail;
    @BindView(R.id.etPassword)
    EditText etPassword;

    ProgressDialog loading;

    @BindView(R.id.btnLogin)
    ActionProcessButton btnLogin;
    Context mContext;

    SharedPrefManager sharedPrefManager;

    //ActionProcessButton btnLogin;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        ButterKnife.bind(this);
        mContext = this;
        sharedPrefManager = new SharedPrefManager(this);

        etEmail.setOnTouchListener(new View.OnTouchListener(){
            public boolean onTouch(View view, MotionEvent motionEvent) {
                // your code here...
                btnLogin.setProgress(0);
                getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
                return false;
            }
        });

        etPassword.setOnTouchListener(new View.OnTouchListener(){
            public boolean onTouch(View view, MotionEvent motionEvent) {
                // your code here...
                btnLogin.setProgress(0);
                etPassword.setText("");
                getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
                return false;
            }
        });

        btnLogin.setMode(ActionProcessButton.Mode.PROGRESS);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnLogin.setProgress(50);
                btnLogin.setEnabled(false);
                requestLogin();
            }
        });


        // Code berikut berfungsi untuk mengecek session, Jika session true ( sudah login )
        // maka langsung memulai MainActivity.
        if (sharedPrefManager.getSPSudahLogin()) {
            startActivity(new Intent(LoginActivity.this, MainActivity.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
            finish();
        }
    }

    private void requestLogin() {

        ConfigRetrofit.service.loginRequest(etEmail.getText().toString(), etPassword.getText().toString())
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()) {
                            //loading.dismiss();
                            try {


                                JSONObject jsonRESULTS = new JSONObject(response.body().string());
                                if (jsonRESULTS.getString("error").equals("false")) {

                                    // Jika login berhasil maka data nama yang ada di response API
                                    // akan diparsing ke activity selanjutnya.

                                    Toast.makeText(mContext, "BERHASIL LOGIN", Toast.LENGTH_SHORT).show();
                                    String nim = jsonRESULTS.getJSONObject("user").getString("nim");
                                    String nama = jsonRESULTS.getJSONObject("user").getString("nama");
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_NIM, nim);
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_NAMA, nama);
                                    // Shared Pref ini berfungsi untuk menjadi trigger session login

                                    sharedPrefManager.saveSPBoolean(SharedPrefManager.SP_SUDAH_LOGIN, true);
                                    startActivity(new Intent(mContext, MainActivity.class)
                                            .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                                    finish();
                                    btnLogin.setProgress(100);
                                } else {

                                    // Jika login gagal
                                    String error_message = jsonRESULTS.getString("error_msg");
                                    Toast.makeText(mContext, error_message, Toast.LENGTH_SHORT).show();
                                    btnLogin.setProgress(-1);
                                    btnLogin.setEnabled(true);
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {

                            //loading.dismiss();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.v("debug", "onFailure: ERROR > " + t.toString());
                        //loading.dismiss();
                    }
                });
    }


}


