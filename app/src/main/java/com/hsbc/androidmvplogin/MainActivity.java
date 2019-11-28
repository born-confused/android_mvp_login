package com.hsbc.androidmvplogin;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hsbc.androidmvplogin.Model.User;
import com.hsbc.androidmvplogin.Presenter.IPresenter;
import com.hsbc.androidmvplogin.Presenter.LoginPresenter;
import com.hsbc.androidmvplogin.View.IView;

public class MainActivity extends Activity implements IView {

    @BindView(R.id.edt_email)
    private EditText etdEmail;
    @BindView(R.id.edt_password)
    private EditText etdPassword;
    @BindView(R.id.btn_login)
    private Button btnLogin;

    IPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        loginPresenter = new LoginPresenter(this);
        etdEmail = findViewById(R.id.edt_email);
        etdPassword = findViewById(R.id.edt_password);
        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etdEmail.getText().toString().trim();
                String password = etdPassword.getText().toString().trim();
                User user = new User(email, password);

                if(loginPresenter.isValidEmail(email))
                    loginPresenter.onLogin(user);
                else
                    etdEmail.setError("Email is incorrect");
            }
        });
    }

    @Override
    public void onLoginResult(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
