package com.example.latihan3.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.latihan3.model.UserModel;
//import com.apps.rizkiadam.com.apps.rizkiadam.latihansharedpreferences.model.UserModel;

public class Preferences {
    private final static String PREF_SESSION = "com.example.latihan3.model.session";

    private final static String REGISTER_USERNAME = "REGISTER_USERNAME";
    private final static String REGISTER_PASSWORD = "REGISTER_PASSWORD";
    private final static String REGISTER_PHONE = "REGISTER_PHONE";
    private final static String LOGIN_STATUS = "LOGIN_STATUS";

    private Context context;
    public Preferences (Context context){
        this.context = context;
    }

    public static void setUserPreferences(Context context, UserModel userModel){
        SharedPreferences preferences = context.getSharedPreferences(PREF_SESSION, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putString(REGISTER_USERNAME, userModel.getUsername());
        editor.putString(REGISTER_PASSWORD, userModel.getPassword());
        editor.putString(REGISTER_PHONE, userModel.getTelepon());
        editor.apply();
    }

    public static String getRegisteredUser(Context context){
        SharedPreferences preferences = context.getSharedPreferences(PREF_SESSION, Context.MODE_PRIVATE);
        return preferences.getString(REGISTER_USERNAME, UtilStatic.DEFAULT_STRING);
    }

    public static String getRegisteredPassword(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(PREF_SESSION, Context.MODE_PRIVATE);
        return preferences.getString(REGISTER_PASSWORD, UtilStatic.DEFAULT_STRING);
    }

    public static String getRegisteredPhone(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(PREF_SESSION, Context.MODE_PRIVATE);
        return preferences.getString(REGISTER_PHONE, UtilStatic.DEFAULT_STRING);
    }



    public static void setLoggedInStatus(Context context, boolean statusLogin) {
//       membuka preference
        SharedPreferences preferences = context.getSharedPreferences(PREF_SESSION, Context.MODE_PRIVATE);

//        membuka editor
        SharedPreferences.Editor editor = preferences.edit();

//        menyimpat status login, dengan key LOGIN_STATUS dan berisi statusLogin yang didapat dari parameter
        editor.putBoolean(LOGIN_STATUS, statusLogin);
//        Kemudian di apply
        editor.apply();
    }

    public static boolean getLoggedInStatus(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(PREF_SESSION, Context.MODE_PRIVATE);

//        menurut pemahaman saya, jika LOGIN_STATUS berisi maka yang direturn adalah LOGIN_STATUS jika tidak maka yang direturn adalah DEFAULT_BOOLEAN
        return preferences.getBoolean(LOGIN_STATUS, UtilStatic.DEFAULT_BOOLEAN);
    }

    public static void setLogout(Context context){
        SharedPreferences preferences = context.getSharedPreferences(PREF_SESSION, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
//        menghapus login status
        editor.remove(LOGIN_STATUS);
        editor.apply();
    }






}
