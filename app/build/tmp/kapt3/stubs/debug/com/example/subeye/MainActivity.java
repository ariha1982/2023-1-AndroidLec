package com.example.subeye;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010:\u001a\u00020;H\u0002J\b\u0010<\u001a\u00020;H\u0002J\u0012\u0010=\u001a\u00020;2\b\u0010>\u001a\u0004\u0018\u00010?H\u0014J\u0012\u0010@\u001a\u00020A2\b\u0010B\u001a\u0004\u0018\u00010CH\u0016J\b\u0010D\u001a\u00020;H\u0014J\u0010\u0010E\u001a\u00020;2\u0006\u0010F\u001a\u00020GH\u0016J\u0010\u0010H\u001a\u00020A2\u0006\u0010I\u001a\u00020\u0005H\u0016J\b\u0010J\u001a\u00020;H\u0014J\b\u0010K\u001a\u00020;H\u0014J\u0010\u0010L\u001a\u00020;2\u0006\u0010M\u001a\u00020\u001dH\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010\'R\u001a\u0010(\u001a\u00020)X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020/X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0011\u00104\u001a\u000205\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006N"}, d2 = {"Lcom/example/subeye/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/speech/tts/TextToSpeech$OnInitListener;", "()V", "authMenuItem", "Landroid/view/MenuItem;", "getAuthMenuItem", "()Landroid/view/MenuItem;", "setAuthMenuItem", "(Landroid/view/MenuItem;)V", "binding", "Lcom/example/subeye/databinding/ActivityMainBinding;", "getBinding", "()Lcom/example/subeye/databinding/ActivityMainBinding;", "setBinding", "(Lcom/example/subeye/databinding/ActivityMainBinding;)V", "landmarkFragment", "Lcom/example/subeye/LandmarkFragment;", "getLandmarkFragment", "()Lcom/example/subeye/LandmarkFragment;", "setLandmarkFragment", "(Lcom/example/subeye/LandmarkFragment;)V", "memoFragment", "Lcom/example/subeye/MemoFragment;", "getMemoFragment", "()Lcom/example/subeye/MemoFragment;", "setMemoFragment", "(Lcom/example/subeye/MemoFragment;)V", "mode", "", "getMode", "()Ljava/lang/String;", "setMode", "(Ljava/lang/String;)V", "routeFragment", "Lcom/example/subeye/RouteFragment;", "getRouteFragment", "()Lcom/example/subeye/RouteFragment;", "setRouteFragment", "(Lcom/example/subeye/RouteFragment;)V", "settingsFragment", "Lcom/example/subeye/SettingsFragment;", "getSettingsFragment", "()Lcom/example/subeye/SettingsFragment;", "setSettingsFragment", "(Lcom/example/subeye/SettingsFragment;)V", "sharedPreferences", "Landroid/content/SharedPreferences;", "getSharedPreferences", "()Landroid/content/SharedPreferences;", "setSharedPreferences", "(Landroid/content/SharedPreferences;)V", "sharedPreferencesListener", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "getSharedPreferencesListener", "()Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "tts", "Landroid/speech/tts/TextToSpeech;", "applyTextColor", "", "applyThemeColor", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "", "menu", "Landroid/view/Menu;", "onDestroy", "onInit", "status", "", "onOptionsItemSelected", "item", "onResume", "onStart", "speakOut", "text", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity implements android.speech.tts.TextToSpeech.OnInitListener {
    public com.example.subeye.databinding.ActivityMainBinding binding;
    public com.example.subeye.RouteFragment routeFragment;
    public com.example.subeye.MemoFragment memoFragment;
    public com.example.subeye.LandmarkFragment landmarkFragment;
    public com.example.subeye.SettingsFragment settingsFragment;
    public android.content.SharedPreferences sharedPreferences;
    @org.jetbrains.annotations.NotNull
    private java.lang.String mode = "route";
    private android.speech.tts.TextToSpeech tts;
    @org.jetbrains.annotations.Nullable
    private android.view.MenuItem authMenuItem;
    @org.jetbrains.annotations.NotNull
    private final android.content.SharedPreferences.OnSharedPreferenceChangeListener sharedPreferencesListener = null;
    
    public MainActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.subeye.databinding.ActivityMainBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull
    com.example.subeye.databinding.ActivityMainBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.subeye.RouteFragment getRouteFragment() {
        return null;
    }
    
    public final void setRouteFragment(@org.jetbrains.annotations.NotNull
    com.example.subeye.RouteFragment p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.subeye.MemoFragment getMemoFragment() {
        return null;
    }
    
    public final void setMemoFragment(@org.jetbrains.annotations.NotNull
    com.example.subeye.MemoFragment p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.subeye.LandmarkFragment getLandmarkFragment() {
        return null;
    }
    
    public final void setLandmarkFragment(@org.jetbrains.annotations.NotNull
    com.example.subeye.LandmarkFragment p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.subeye.SettingsFragment getSettingsFragment() {
        return null;
    }
    
    public final void setSettingsFragment(@org.jetbrains.annotations.NotNull
    com.example.subeye.SettingsFragment p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.content.SharedPreferences getSharedPreferences() {
        return null;
    }
    
    public final void setSharedPreferences(@org.jetbrains.annotations.NotNull
    android.content.SharedPreferences p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getMode() {
        return null;
    }
    
    public final void setMode(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.view.MenuItem getAuthMenuItem() {
        return null;
    }
    
    public final void setAuthMenuItem(@org.jetbrains.annotations.Nullable
    android.view.MenuItem p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.content.SharedPreferences.OnSharedPreferenceChangeListener getSharedPreferencesListener() {
        return null;
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    public void onInit(int status) {
    }
    
    @java.lang.Override
    public boolean onCreateOptionsMenu(@org.jetbrains.annotations.Nullable
    android.view.Menu menu) {
        return false;
    }
    
    @java.lang.Override
    protected void onStart() {
    }
    
    @java.lang.Override
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull
    android.view.MenuItem item) {
        return false;
    }
    
    @java.lang.Override
    protected void onResume() {
    }
    
    private final void speakOut(java.lang.String text) {
    }
    
    @java.lang.Override
    protected void onDestroy() {
    }
    
    private final void applyThemeColor() {
    }
    
    private final void applyTextColor() {
    }
}