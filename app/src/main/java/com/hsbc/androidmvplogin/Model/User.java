package com.hsbc.androidmvplogin.Model;

import android.text.TextUtils;
import android.util.Patterns;

public class User implements IUser {

    private String email, password;

    public User(String email, String password){
        this.email = email;
        this.password = password;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isValidData() {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches()
                && getPassword().length() > 6;
    }
}
