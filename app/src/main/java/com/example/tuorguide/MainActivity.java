package com.example.tuorguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String emailPattern="[a-zA-Z0-9._-]+@[a-zA-Z]+\\.+[a-z]{2,}";
    private EditText txtEmail;
    private EditText txtPassword;
    private Button btnLogin;
    private TextView txtValidate;
    private TextView txtValidate1;
    private Boolean isValidEmail=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtPassword=(EditText) findViewById(R.id.txtPassword);
        txtValidate=(TextView) findViewById(R.id.txtValidate);
        btnLogin=findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //alert
                String email= txtEmail.getText().toString().trim();
                String password= txtPassword.getText().toString().trim();
                //Toast.makeText(getApplicationContext(),"You press Login Button "+email+password, Toast.LENGTH_LONG).show();
                //Navigation next Screen
                Intent intent =new Intent(MainActivity.this,home.class);
                intent.putExtra("email",txtEmail.getText().toString().trim());
                startActivity(intent);
            }
        });
        //validation
        txtEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            txtValidate.setText("");
            String email =txtEmail.getText().toString().trim();
            isValidEmail =(email.matches(emailPattern)&& charSequence.length()>1);
            if(!isValidEmail){
                txtValidate.setText("Định dạng email sai");
            }
            }



            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


    }
}