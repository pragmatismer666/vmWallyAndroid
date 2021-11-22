package com.srs.vmwally.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.nightonke.blurlockview.BlurLockView;
import com.nightonke.blurlockview.Directions.HideType;
import com.nightonke.blurlockview.Eases.EaseType;
import com.nightonke.blurlockview.Password;
import com.srs.vmwally.Common;
import com.srs.vmwally.R;


public class PinSetActivity extends AppCompatActivity implements View.OnClickListener
        , BlurLockView.OnPasswordInputListener,  BlurLockView.OnLeftButtonClickListener{

    BlurLockView pinSetView;
    private ImageView imageView;

    private String updatedPassword = "";
    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin_set);

        pinSetView = findViewById(R.id.pinSetView);
        imageView = findViewById(R.id.image_2);
        pinSetView.setBlurredView(imageView);
        String basePassword = "0000";
        pinSetView.setCorrectPassword(basePassword);
        if (Common.pinCode.equals("")){
            pinSetView.setTitle(getString(R.string.setupPinCode));
        } else {
            pinSetView.setTitle(getString(R.string.changePinCode));
        }
        pinSetView.setTypeface(Typeface.DEFAULT);
        pinSetView.setType(Password.NUMBER, false);
        pinSetView.setOnLeftButtonClickListener(this);
        pinSetView.setOnPasswordInputListener(this);
        imageView.setOnClickListener(this);

    }

    @Override
    public void correct(String inputPassword) {
        checkPassword(inputPassword);
    }

    @Override
    public void incorrect(String inputPassword) {
        checkPassword(inputPassword);
    }

    private void checkPassword(String inputPassword) {
        if ( updatedPassword.equals("") ) {
            updatedPassword = inputPassword;
            pinSetView.removeStack();
            Toast.makeText(this, getString(R.string.pleaseConfirm), Toast.LENGTH_SHORT).show();
        } else {
            if ( updatedPassword.equals(inputPassword) ) {
                Toast.makeText(this, getString(R.string.pinCodeConfirmed), Toast.LENGTH_SHORT).show();
                Common.pinCode = inputPassword;
                Common.pinSetFlag = true;
                Common.authFlag = true;
                SharedPreferences pinPref = getApplicationContext().getSharedPreferences("pinSet", 0);
                SharedPreferences.Editor editor = pinPref.edit();
                editor.putString("pinCode", Common.pinCode);
                editor.apply();
                startActivity(new Intent(PinSetActivity.this, MainMenuActivity.class));
                finish();
            } else {
                Toast.makeText(this, getString(R.string.reInputNewPinCode), Toast.LENGTH_SHORT).show();
                pinSetView.removeStack();
                updatedPassword = "";
            }
        }
    }

    @Override
    public void input(String inputPassword) {

    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onClick() {

    }
}