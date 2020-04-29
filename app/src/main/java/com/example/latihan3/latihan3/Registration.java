package com.example.latihan3.latihan3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.latihan3.R;
import com.example.latihan3.model.UserModel;
import com.example.latihan3.utils.Preferences;

public class Registration extends AppCompatActivity {
    private TextView txtMasuk;
    private EditText edtUserName;
    private EditText edtPassWord;
    private EditText edtRePassWord;
    private EditText edtPhoneNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        declareView();

        txtMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validasiRegistration();
            }
        });

    }

    private void declareView() {
//        data merupakan variabel layout
        txtMasuk = findViewById(R.id.txt_reg_masuk);
        edtUserName = findViewById(R.id.edt_reg_username);
        edtPassWord = findViewById(R.id.edt_reg_password);
        edtRePassWord = findViewById(R.id.edt_reg_password_confirm);
        edtPhoneNumber = findViewById(R.id.edt_reg_phone);
    }

    private void validasiRegistration(){

        edtUserName.setError(null);
        edtPassWord.setError(null);
        edtRePassWord.setError(null);

        View fokus = null;
        boolean cancel = false;

//        dari variabel layout diambil datanya untuk dimasukkan kedalam variabel class.

        String userName = edtUserName.getText().toString();
        String password = edtPassWord.getText().toString();
        String rePassword = edtRePassWord.getText().toString();
        String phoneNumber = edtPhoneNumber.getText().toString();

//        cek username
        if (TextUtils.isEmpty(userName)){
            edtUserName.setError("Harus diisi");
            fokus = edtUserName;
            cancel = true;
        }else if(cekUser(userName)){
            edtUserName.setError("Username sudah terdaftar");
            fokus = edtUserName;
            cancel = true;
        }

//        cek password
        if (TextUtils.isEmpty(password)){
            edtPassWord.setError("Harus Diisi");
            fokus = edtPassWord;
            cancel = true;
        }else if (!cekPassword(password,rePassword)){
            edtPassWord.setError("Password yang dimasukkan tidak sesuai");
            fokus = edtPassWord;
            cancel = true;
        }


        if (cancel){
            fokus.requestFocus();
        }else{
// Deklarasi Model
            UserModel userModel = new UserModel();
            userModel.setUsername(userName);
            userModel.setPassword(password);
            userModel.setTelepon(phoneNumber);
            // Simpan data ke shared preferences
            Preferences.setUserPreferences(getBaseContext(),userModel);
            Preferences.setLoggedInStatus(getBaseContext(),true);
            //Pindah Halaman ke home
            startActivity(new Intent(getBaseContext(), Home.class));
            finish();
        }
//  CATATAN!
//        PELAJARI finish(), pelajari getBaseContext(), context
    }

    private boolean cekUser(String user){
        return user.equals(Preferences.getRegisteredUser(getBaseContext()));
    }

    private boolean cekPassword(String password, String repassword ){
        return password.equals(repassword);
    }



}
