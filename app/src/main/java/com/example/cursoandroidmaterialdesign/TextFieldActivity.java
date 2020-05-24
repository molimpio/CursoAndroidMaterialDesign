package com.example.cursoandroidmaterialdesign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

public class TextFieldActivity extends AppCompatActivity {

    // https://material.io/develop/android/components/text-fields/
    // https://github.com/material-components/material-components-android/blob/master/docs/getting-started.md

    private Button btnLogin;

    private AppCompatEditText etNome;
    private AppCompatEditText etEmail;
    private AppCompatEditText etSenha;

    private TextInputLayout txtNome;
    private TextInputLayout txtEmail;
    private TextInputLayout txtSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_field);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateForm();
            }
        });

        etNome = findViewById(R.id.et_nome);
        etEmail = findViewById(R.id.et_email);
        etSenha = findViewById(R.id.et_senha);

        txtNome = findViewById(R.id.txt_nome);
        txtEmail = findViewById(R.id.txt_email);
        txtSenha = findViewById(R.id.txt_senha);

        etNome.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String nome = etNome.getText().toString();


                if (nome.length() < 4) {
                    txtNome.setHelperText("Mínimo 4 caracteres");
                    txtNome.setEndIconDrawable(R.drawable.ic_error_black_24dp);
                    txtNome.setErrorEnabled(true);
                    txtNome.setError("Nome incorreto");
                } else {
                    txtNome.setEndIconDrawable(R.drawable.ic_check_circle_black_24dp);
                    txtNome.setErrorEnabled(false);
                    txtNome.setHelperText("OK");
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void validateForm() {
        if (etEmail.getText().toString().isEmpty()) {
            txtEmail.setErrorEnabled(true);
            txtEmail.setError("Preencha corretamente seu email");
        } else {
            txtEmail.setErrorEnabled(false);
        }

        if (etSenha.getText().toString().isEmpty()) {
            txtSenha.setErrorEnabled(true);
            txtSenha.setError("Preencha corretamente sua senha");
        } else {
            txtSenha.setErrorEnabled(true);
        }
    }
}
