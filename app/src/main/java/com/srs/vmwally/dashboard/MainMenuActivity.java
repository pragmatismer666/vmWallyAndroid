package com.srs.vmwally.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.srs.vmwally.Common;
import com.srs.vmwally.R;

public class MainMenuActivity extends AppCompatActivity {

    Button pinSettingBtn;
    Button openExistWalletBtn;
    Button paidNewWalletBtn;
    Button loadWalletBtn;

    Button exitBtn;
    TextView closeTv;

    ListView walletsLv;
    private boolean openExistWalletFlag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

//        if ( !Common.authFlag ) {
//            startActivity(new Intent(MainMenuActivity.this, PinSetActivity.class));
//            finish();
//        }
        exitBtn = findViewById(R.id.exitBtn);
        exitBtn.setOnClickListener(v->{
            finish();
        });
        closeTv = findViewById(R.id.closeBtn);
        closeTv.setOnClickListener(v->{
            finish();
        });

        pinSettingBtn = findViewById(R.id.settingPinBtn);
        if ( Common.pinSetFlag ) {
            pinSettingBtn.setText(R.string.changePin);
        } else {
            pinSettingBtn.setText(R.string.setupPin);
        }
        pinSettingBtn.setOnClickListener(v->{
            startActivity(new Intent(MainMenuActivity.this, PinSetActivity.class));
        });

        openExistWalletBtn = findViewById(R.id.openExistWallet);
        if ( Common.pinSetFlag ) {
            openExistWalletBtn.setEnabled(true);
            openExistWalletBtn.setTextColor(getColor(R.color.buttonColor));
        } else {
            openExistWalletBtn.setEnabled(false);
            openExistWalletBtn.setTextColor(getColor(R.color.disabledButtonColor));
        }

        walletsLv = findViewById(R.id.existWallets);
        openExistWalletBtn.setOnClickListener(v->{
            if ( openExistWalletFlag ) {

            }
        });

        paidNewWalletBtn = findViewById(R.id.paidNewWallet);
        if ( Common.pinSetFlag ) {
            paidNewWalletBtn.setEnabled(true);
            paidNewWalletBtn.setTextColor(getColor(R.color.buttonColor));
        } else {
            paidNewWalletBtn.setEnabled(false);
            paidNewWalletBtn.setTextColor(getColor(R.color.disabledButtonColor));
        }
        loadWalletBtn = findViewById(R.id.loadWalletFromTestStore);
        if ( Common.pinSetFlag ) {
            loadWalletBtn.setEnabled(true);
            loadWalletBtn.setTextColor(getColor(R.color.buttonColor));
        } else {
            loadWalletBtn.setEnabled(false);
            loadWalletBtn.setTextColor(getColor(R.color.disabledButtonColor));
        }

    }
}