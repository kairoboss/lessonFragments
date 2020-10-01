package com.example.lessonfragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewFragment extends Fragment {
    IFragments iFragments;
    WebView webView;
    String url;
    public WebViewFragment(String url) {
        this.url = url;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        iFragments = (IFragments) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_web_view, container, false);
        webView = v.findViewById(R.id.WebView);
        showWebView(url);
        return v;
    }

    public void showWebView(final String url){
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
    }
}