package com.srs.vmwally.dashboard;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.nightonke.blurlockview.BlurLockView;
import com.nightonke.blurlockview.Directions.HideType;
import com.nightonke.blurlockview.Eases.EaseType;
import com.nightonke.blurlockview.Password;
import com.srs.vmwally.Common;
import com.srs.vmwally.R;

public class PinScreenActivity extends AppCompatActivity implements View.OnClickListener
        , BlurLockView.OnPasswordInputListener, BlurLockView.OnLeftButtonClickListener
{

    private BlurLockView blurLockView;
    private ImageView imageView;

    private void checkPinCodeExist() {
        SharedPreferences pinPref = getApplicationContext().getSharedPreferences("pinSet", 0);
        String pinCode = pinPref.getString("pinCode","");
        if ( pinCode.equals("") ) {
            Toast.makeText(this, getString(R.string.noPinCode), Toast.LENGTH_LONG).show();
            // blurLockView.hide( 100, HideType.FROM_TOP_TO_BOTTOM, EaseType.Linear);
            Common.pinSetFlag = false;
            startActivity(new Intent(PinScreenActivity.this, MainMenuActivity.class));
            finish();
        } else {
            Common.pinCode = pinCode;
        }
    }

    @SuppressLint({"SetTextI18n", "ResourceType"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin_screen);

        checkPinCodeExist();
        imageView = findViewById(R.id.image_1);
        blurLockView = findViewById(R.id.pinSetView);
        blurLockView.setBlurredView(imageView);
        blurLockView.setCorrectPassword(Common.pinCode);
        blurLockView.setTitle(getString(R.string.pintitle));
        blurLockView.setTypeface(Typeface.DEFAULT);
        blurLockView.setType(Password.NUMBER, false);
        blurLockView.setOnLeftButtonClickListener(this);
        blurLockView.setOnPasswordInputListener(this);
        imageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void correct(String inputPassword) {
        Toast.makeText(this, getString(R.string.password_correct), Toast.LENGTH_LONG).show();
        // blurLockView.hide( 500, HideType.FROM_TOP_TO_BOTTOM, EaseType.Linear);
        Common.authFlag = true;
        startActivity(new Intent(PinScreenActivity.this, MainMenuActivity.class));
        finish();
    }

    @Override
    public void incorrect(String inputPassword) {
        Toast.makeText(this, getString(R.string.password_correct), Toast.LENGTH_LONG).show();
    }

    @Override
    public void input(String inputPassword) {

    }

    @Override
    public void onClick() {

    }

}