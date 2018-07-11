package com.xxj.rhyma.evilsoul;

import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;

import static android.content.Context.MODE_WORLD_READABLE;

/**
 * Created by ASUS User on 2018/7/10.
 */

public class SettingsFragment extends PreferenceFragment{

    private QRCodeDialog dialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getPreferenceManager().setSharedPreferencesMode(MODE_WORLD_READABLE);
        getPreferenceManager().setSharedPreferencesName("evil");
        addPreferencesFromResource(R.xml.pref_setting);

        Preference donateAlipay = findPreference("donate_alipay");
        donateAlipay.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference pref) {
                try {
                    if (dialog==null) {
                        dialog = new QRCodeDialog(getActivity());
                        if (!dialog.isShowing()) {
                            dialog.show();
                        }
                        dialog.alipay();
                    }else{
                        if (!dialog.isShowing()) {
                            dialog.show();
                        }
                        dialog.alipay();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                return true;
            }
        });

        Preference donateWechat = findPreference("donate_wechat");
        donateWechat.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference pref) {
                try {
                    if (dialog==null) {
                        dialog = new QRCodeDialog(getActivity());
                        if (!dialog.isShowing()) {
                            dialog.show();
                        }
                        dialog.wechat();
                    }else{
                        if (!dialog.isShowing()) {
                            dialog.show();
                        }
                        dialog.wechat();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                return true;
            }
        });


    }
}
