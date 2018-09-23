package com.reactsoft.safer.ui.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.reactsoft.safer.R;
import com.reactsoft.safer.ui.main.MainNavigateActivity;
import com.reactsoft.safer.base.BaseActivity;


public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button button = (Button)findViewById(R.id.redirectMain);
        Button buttonRegister = (Button)findViewById(R.id.notHaveAccount); //change la name for redirectRegister

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MainNavigateActivity.class);
                startActivity(i);
            }
        });

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), RegisterActivity.class);
                startActivity(i);
            }
        });
    }
}
