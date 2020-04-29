package com.example.latihan3.latihan3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.latihan3.R;
import com.example.latihan3.utils.Preferences;

public class Home extends AppCompatActivity {

    private TextView txtLogout;
    private TextView txtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        declareView();
        txtLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Clear Set Preferences
                Preferences.setLogout(getBaseContext());

                //Pindah Halaman ke Login
                startActivity(new Intent(getBaseContext(), Login.class));
                finish();
            }
        });
    }



    private void declareView() {
        txtLogout = findViewById(R.id.txt_logout);
        txtName = findViewById(R.id.textView4);

        txtName.setText(Preferences.getRegisteredUser(getBaseContext()));
    }
}
