package com.xxj.rhyma.evilsoul;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import java.util.prefs.Preferences;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

/**
 * Created by ASUS User on 2018/7/9.
 */

public class RandomGame implements IXposedHookLoadPackage {
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {
        if (TextUtils.equals(loadPackageParam.packageName, Constant.packageName)) {
            findAndHookMethod("cn.soulapp.android.im.utils.aj", loadPackageParam.classLoader, "c", String.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    super.beforeHookedMethod(param);
                    if (SharedPref.moraCheat()) {
                        param.args[0] = SharedPref.moraNum();
                    }
                 }

                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    super.afterHookedMethod(param);
                }
            });
            findAndHookMethod("cn.soulapp.android.im.utils.aj", loadPackageParam.classLoader, "b", String.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    super.beforeHookedMethod(param);
                    XposedBridge.log("evil"+SharedPref.diceCheat());
                    if (SharedPref.diceCheat()) {
                        param.args[0] = SharedPref.diceNum();
                        XposedBridge.log("evil"+SharedPref.diceNum());
                    }
                }

                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    super.afterHookedMethod(param);
                }
            });
        }
    }
}
