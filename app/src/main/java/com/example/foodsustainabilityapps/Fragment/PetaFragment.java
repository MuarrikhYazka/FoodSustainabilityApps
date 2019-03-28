package com.example.foodsustainabilityapps.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.example.foodsustainabilityapps.R;

public class PetaFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v =  inflater.inflate(R.layout.fragment_peta, container, false);
        WebView webView =  (WebView) v.findViewById(R.id.webview);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.loadUrl("https://app.powerbi.com/view?r=eyJrIjoiNjE1OGEyMDUtMjYwMS00MWJmLTk0NWYtNDIyMmQ5YWMzOWQ2IiwidCI6IjlkODdmZmUwLTU2ZGYtNDJmNi04MGNmLTMyM2ZjYzBiYjAxNiIsImMiOjEwfQ%3D%3D");

        return v;
    }
}
