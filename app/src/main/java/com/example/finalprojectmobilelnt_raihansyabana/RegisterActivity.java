package com.example.finalprojectmobilelnt_raihansyabana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalprojectmobilelnt_raihansyabana.ui.login.LoginActivity;

public class RegisterActivity extends AppCompatActivity {

    EditText TxEmail, TxPassword, TxIdBimbel, TxConPassword, TxName;
    Button BtnLogin;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        dbHelper = new DBHelper(context:this);

        TxIdBimbel = (EditText) findViewById(R.id.txId_BimbelReg);
        TxEmail = (EditText) findViewById(R.id.txEmailReg);
        TxName = (EditText) findViewById(R.id.txNameReg);
        TxPassword = (EditText) findViewById(R.id.txPasswordReg);
        TxConPassword = (EditText) findViewById(R.id.txConPasswordReg);

        TextView tvRegiser = (TextView)findViewById(R.id.tvRegister);

        tvRegister.setText(fromHtml ("Back to" + "</font><font color='#3b5998'>Login</font>"));

        tvRegiser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(packageContext: RegisterActivity.this, LoginActivity.class));
            }
        });

        BtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idBimbel = TxIdBimbel.getText().toString().trim();
                String email = TxEmail.getText().toString().trim();
                String name = TxName.getText().toString().trim();
                String password = TxPassword.getText().toString().trim();
                String conpassword = TxConPassword.getText().toString().trim();

                ContentValues values = new ContentValues();
                if (!password.equals(ConPassword)) {
                    Toast.makeText(context:RegisterActivity.this, text: "Password not match", Toast.LENGTH_SHORT).show();
                }else if (password.equals("")) || username.equals("")){
                    Toast.makeText(context:RegisterActivity.this, text: "Username or Password cannot be empty", Toast.LENGTH_SHORT).show();
                }else {
                    values.put(DBHelper.rov_username, username);
                    values.put(DBHelper.rov_password, password);
                    dbHelper.insertData(values);

                    Toast.makeText( context: RegisterActivity.this, text: "Register Successful", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });

    }
    public static Spanned fromHtml(String html) {
        Spanned result;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            result = Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY);
        } else {
            result = Html.fromHtml(html);
        }
        return result;
    }
}