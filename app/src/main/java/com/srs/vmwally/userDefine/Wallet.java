package com.srs.vmwally.userDefine;

import android.view.View;

public class Wallet {

    String user_id;
    String public_key_id;
    String public_key;
    String private_key;
    String email;
    String tel;
    String first_name;
    String last_name;
    String title_before;
    String title_after;


    public Wallet(String user_id, String public_key_id, String public_key, String private_key, String email, String tel, String first_name, String last_name, String title_before, String title_after) {
        this.user_id = user_id;
        this.public_key_id = public_key_id;
        this.public_key = public_key;
        this.private_key = private_key;
        this.email = email;
        this.tel = tel;
        this.first_name = first_name;
        this.last_name = last_name;
        this.title_before = title_before;
        this.title_after = title_after;
    }

    public Wallet() {
    }

    public String getUserId() {
        return user_id;
    }

    public void setUserId(String user_id) {
        this.user_id = user_id;
    }

    public String getPublicKeyId() {
        return public_key_id;
    }

    public void setPublicKeyId(String public_key_id) {
        this.public_key_id = public_key_id;
    }

    public String getPublicKey() {
        return public_key;
    }

    public void setPublicKey(String public_key) {
        this.public_key = public_key;
    }

    public String getPrivateKey() {
        return private_key;
    }

    public void setPrivateKey(String private_key) {
        this.private_key = private_key;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public String getTitleAfter() {
        return title_after;
    }

    public void setTitleAfter(String title_after) {
        this.title_after = title_after;
    }

    public String getTitleBefore() {
        return title_before;
    }

    public void setTitleBefore(String title_before) {
        this.title_before = title_before;
    }

}
