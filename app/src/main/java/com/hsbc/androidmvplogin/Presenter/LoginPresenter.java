package com.hsbc.androidmvplogin.Presenter;

import android.util.Patterns;

import org.jetbrains.annotations.NotNull;

import com.hsbc.androidmvplogin.Model.IUser;
import com.hsbc.androidmvplogin.View.IView;

public class LoginPresenter implements IPresenter {

    private IView loginView;

    @Override
    public boolean isValidEmail(String email) {
        if(Patterns.EMAIL_ADDRESS.matcher(email).matches())
            return true;
        return false;
    }

    public LoginPresenter(IView loginView){
        this.loginView = loginView;
    }

    @Override
    public void onLogin(@NotNull IUser user) {
        if (user.isValidData()) {
            loginView.onLoginResult("Login Success");
        } else {
            loginView.onLoginResult("Login Failed");
        }
    }
}
