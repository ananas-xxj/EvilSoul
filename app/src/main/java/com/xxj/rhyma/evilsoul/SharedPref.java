package com.xxj.rhyma.evilsoul;

import android.content.Context;
import android.content.SharedPreferences;

import de.robv.android.xposed.XSharedPreferences;

import static android.content.Context.MODE_WORLD_READABLE;

public class SharedPref {
	private Context shareContext;
    private SharedPreferences mySharedPref;
    private static XSharedPreferences myXsharedPref;
    
    public SharedPref(Context appContext) {
    	shareContext = appContext;
    	mySharedPref = shareContext.getSharedPreferences("evil", MODE_WORLD_READABLE);
    }
    
    public void setSharedPref(String key, String value) {
    	try {
    		mySharedPref.edit().putString(key, value).commit();
        } catch (Exception e) {
        	System.out.println("setSharedPref ERROR: " + e.getMessage());
        }
    }
    public void setintSharedPref(String key, int value) {
        try {
            mySharedPref.edit().putInt(key, value).commit();
        } catch (Exception e) {
            System.out.println("setintSharedPref ERROR: " + e.getMessage());
        }
    }

    public void setfloatharedPref(String key, float value) {
        try {
            mySharedPref.edit().putFloat(key, value).commit();
        } catch (Exception e) {
            System.out.println("setintSharedPref ERROR: " + e.getMessage());
        }
    }

    public static XSharedPreferences getMyXSharedPref() {
        if (myXsharedPref != null) {
        	myXsharedPref.reload();
            return myXsharedPref;
        }
        myXsharedPref = new XSharedPreferences("com.xxj.rhyma.evilsoul", "evil");
        return myXsharedPref;
    }
    
    public static String getXValue(String key) {
    	String value = "";
    	try {
    		value = getMyXSharedPref().getString(key, null);
    	} catch (Exception e) {
        	System.out.println("getSharedPref ERROR: " + e.getMessage());
        }
    	return value;
    }
    public static int getintXValue(String key) {
        int value = 0;
        try {
            value = getMyXSharedPref().getInt(key, 0);
        } catch (Exception e) {
            System.out.println("getSharedPref ERROR: " + e.getMessage());
        }
        return value;
    }

    public static float getfloatXValue(String key) {
        float value = 0;
        try {
            value = getMyXSharedPref().getFloat(key, 0);
        } catch (Exception e) {
            System.out.println("getSharedPref ERROR: " + e.getMessage());
        }
        return value;
    }

    public static boolean diceCheat() {
        return getMyXSharedPref().getBoolean("dice_cheat", true);
    }

    public static String diceNum() {
        return getMyXSharedPref().getString("dice_num", "dice_3");
    }

    public static boolean moraCheat() {
        return getMyXSharedPref().getBoolean("mora_cheat", true);
    }

    public static String moraNum() {
        return getMyXSharedPref().getString("mora_num", "finger_stone");
    }
}
