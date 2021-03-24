package com.example.newtheater;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Spektakle extends Fragment {
    private Button btnFragBack;
    private Button btnFragPR1;
    private Button btnFragPR2;
    private Button btnFragPR3;
    private Button btnFragPR4;

    private ImageView imagePerformance1;
    private ImageView imagePerformance2;
    private ImageView imagePerformance3;
    private ImageView imagePerformance4;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.spektakle,container,false);

        ImageView img = (ImageView)view.findViewById(R.id.imageView14);
        img.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                ((com.example.newtheater.MainActivity)getActivity()).setViewPager(0);
            }
        });

        btnFragBack = (Button)view.findViewById(R.id.btnBack);

        btnFragBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                ((com.example.newtheater.MainActivity)getActivity()).setViewPager(0);
            }
        });

        imagePerformance1 = (ImageView)view.findViewById(R.id.imgV1);
        imagePerformance1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                ((com.example.newtheater.MainActivity)getActivity()).setViewPager(13);
            }
        });

        btnFragPR1 = (Button) view.findViewById(R.id.btnPR1);
        btnFragPR1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                ((com.example.newtheater.MainActivity)getActivity()).setViewPager(13);
            }
        });

        imagePerformance2 = (ImageView)view.findViewById(R.id.imgV2);
        imagePerformance2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                ((com.example.newtheater.MainActivity)getActivity()).setViewPager(14);
            }
        });

        btnFragPR2 = (Button) view.findViewById(R.id.btnPR2);
        btnFragPR2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                ((com.example.newtheater.MainActivity)getActivity()).setViewPager(14);
            }
        });

        imagePerformance3 = (ImageView)view.findViewById(R.id.imgV3);
        imagePerformance3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                ((com.example.newtheater.MainActivity)getActivity()).setViewPager(15);
            }
        });

        btnFragPR3 = (Button) view.findViewById(R.id.btnPR3);
        btnFragPR3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                ((com.example.newtheater.MainActivity)getActivity()).setViewPager(15);
            }
        });

        imagePerformance4 = (ImageView)view.findViewById(R.id.imgV4);
        imagePerformance4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                ((com.example.newtheater.MainActivity)getActivity()).setViewPager(16);
            }
        });

        btnFragPR4 = (Button) view.findViewById(R.id.btnPR4);
        btnFragPR4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                ((com.example.newtheater.MainActivity)getActivity()).setViewPager(16);
            }
        });

        // Map
        final TextView userMap = (TextView) view.findViewById(R.id.adres);

        final CharSequence text = userMap.getText();
        final SpannableString spannableString = new SpannableString( text );
        spannableString.setSpan(new URLSpan(""), 0, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        userMap.setText(spannableString, TextView.BufferType.SPANNABLE);

        userMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent geoIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q="
                        +userMap.getText().toString()));
                startActivity(geoIntent);
            }
        });

        return view;
    }
}
