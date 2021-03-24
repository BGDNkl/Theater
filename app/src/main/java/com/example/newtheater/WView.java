package com.example.newtheater;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

public class WView extends Fragment
{
    private Button btnFrag;
    private WebView webView;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.view_lay,container,false);

        // back button
        btnFrag = (Button) view.findViewById(R.id.btnBack);

        btnFrag.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                ((com.example.newtheater.MainActivity)getActivity()).setViewPager(0);
            }
        });

        //WView
        String url = "http://grproject.tech";
        WebView wview = (WebView) view.findViewById(R.id.webView);
        wview.getSettings().setJavaScriptEnabled(true);
        wview.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_COMPATIBILITY_MODE);
        wview.loadUrl(url);


        return view;
    }

}