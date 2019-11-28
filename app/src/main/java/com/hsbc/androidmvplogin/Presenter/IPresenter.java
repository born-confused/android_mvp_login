package com.hsbc.androidmvplogin.Presenter;

import com.hsbc.androidmvplogin.Model.IUser;

public interface IPresenter {
    void onLogin(IUser user);
    boolean isValidEmail(String email);
}
