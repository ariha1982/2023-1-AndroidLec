package com.example.subeye;

import java.lang.System;

/**
 * A simple [Fragment] subclass.
 * Use the [LandmarkFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\n\u0018\u0000 =2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001=B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006J\b\u0010\u0016\u001a\u00020\u0014H\u0016J\u0012\u0010\u0017\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\u00142\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J&\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010#\u001a\u00020\u0014H\u0016J\b\u0010$\u001a\u00020\u0014H\u0016J\u0010\u0010%\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\'H\u0016J\u001a\u0010(\u001a\u00020\u00142\u0006\u0010)\u001a\u00020\'2\b\u0010*\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010+\u001a\u00020\u00142\u0006\u0010,\u001a\u00020\'H\u0016J\u0012\u0010-\u001a\u00020\u00142\b\u0010.\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010/\u001a\u00020\u00142\b\u0010*\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u00100\u001a\u00020\u00142\b\u00101\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u00102\u001a\u00020\u00142\u0006\u00103\u001a\u000204H\u0016J\u001a\u00105\u001a\u00020\u00142\u0006\u00106\u001a\u00020\u001e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u00107\u001a\u00020\u00142\b\u00108\u001a\u0004\u0018\u00010\fH\u0002J\b\u00109\u001a\u00020\u0014H\u0002J\u0010\u0010:\u001a\u00020\u00142\u0006\u0010;\u001a\u00020\fH\u0002J\b\u0010<\u001a\u00020\u0014H\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006>"}, d2 = {"Lcom/example/subeye/LandmarkFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/speech/RecognitionListener;", "Landroid/speech/tts/TextToSpeech$OnInitListener;", "()V", "binding", "Lcom/example/subeye/databinding/FragmentLandmarkBinding;", "getBinding", "()Lcom/example/subeye/databinding/FragmentLandmarkBinding;", "setBinding", "(Lcom/example/subeye/databinding/FragmentLandmarkBinding;)V", "param1", "", "param2", "speechRecognizer", "Landroid/speech/SpeechRecognizer;", "sttResult", "tts", "Landroid/speech/tts/TextToSpeech;", "changeVisibility", "", "mode", "onBeginningOfSpeech", "onBufferReceived", "buffer", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onEndOfSpeech", "onError", "error", "", "onEvent", "eventType", "params", "onInit", "status", "onPartialResults", "partialResults", "onReadyForSpeech", "onResults", "results", "onRmsChanged", "rmsdB", "", "onViewCreated", "view", "performNetworkRequest", "searchSt", "requestRecordAudioPermission", "speakOut", "text", "startSpeechToText", "Companion", "app_debug"})
public final class LandmarkFragment extends androidx.fragment.app.Fragment implements android.speech.RecognitionListener, android.speech.tts.TextToSpeech.OnInitListener {
    private java.lang.String param1;
    private java.lang.String param2;
    private java.lang.String sttResult = "";
    private android.speech.tts.TextToSpeech tts;
    private android.speech.SpeechRecognizer speechRecognizer;
    public com.example.subeye.databinding.FragmentLandmarkBinding binding;
    @org.jetbrains.annotations.NotNull
    public static final com.example.subeye.LandmarkFragment.Companion Companion = null;
    
    public LandmarkFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.subeye.databinding.FragmentLandmarkBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull
    com.example.subeye.databinding.FragmentLandmarkBinding p0) {
    }
    
    @java.lang.Override
    public void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    public final void changeVisibility(@org.jetbrains.annotations.NotNull
    java.lang.String mode, @org.jetbrains.annotations.NotNull
    com.example.subeye.databinding.FragmentLandmarkBinding binding) {
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    public void onInit(int status) {
    }
    
    private final void speakOut(java.lang.String text) {
    }
    
    @java.lang.Override
    public void onDestroy() {
    }
    
    private final void requestRecordAudioPermission() {
    }
    
    private final void startSpeechToText() {
    }
    
    @java.lang.Override
    public void onResults(@org.jetbrains.annotations.Nullable
    android.os.Bundle results) {
    }
    
    private final void performNetworkRequest(java.lang.String searchSt) {
    }
    
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LandmarkFragment.
     */
    @org.jetbrains.annotations.NotNull
    @kotlin.jvm.JvmStatic
    public static final com.example.subeye.LandmarkFragment newInstance(@org.jetbrains.annotations.NotNull
    java.lang.String param1, @org.jetbrains.annotations.NotNull
    java.lang.String param2) {
        return null;
    }
    
    @java.lang.Override
    public void onBeginningOfSpeech() {
    }
    
    @java.lang.Override
    public void onReadyForSpeech(@org.jetbrains.annotations.Nullable
    android.os.Bundle params) {
    }
    
    @java.lang.Override
    public void onBufferReceived(@org.jetbrains.annotations.Nullable
    byte[] buffer) {
    }
    
    @java.lang.Override
    public void onEndOfSpeech() {
    }
    
    @java.lang.Override
    public void onError(int error) {
    }
    
    @java.lang.Override
    public void onEvent(int eventType, @org.jetbrains.annotations.Nullable
    android.os.Bundle params) {
    }
    
    @java.lang.Override
    public void onPartialResults(@org.jetbrains.annotations.Nullable
    android.os.Bundle partialResults) {
    }
    
    @java.lang.Override
    public void onRmsChanged(float rmsdB) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007\u00a8\u0006\b"}, d2 = {"Lcom/example/subeye/LandmarkFragment$Companion;", "", "()V", "newInstance", "Lcom/example/subeye/LandmarkFragment;", "param1", "", "param2", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LandmarkFragment.
         */
        @org.jetbrains.annotations.NotNull
        @kotlin.jvm.JvmStatic
        public final com.example.subeye.LandmarkFragment newInstance(@org.jetbrains.annotations.NotNull
        java.lang.String param1, @org.jetbrains.annotations.NotNull
        java.lang.String param2) {
            return null;
        }
    }
}