package com.example.newtheater;

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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import java.util.Objects;

public class Menu extends Fragment {
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btn10;
    private Button btn11;
    private Button btn12;
    private Button btn13;
    private Button btn14;
    private Button btn15;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.menu_lay, container, false);

        btn1 = (Button) view.findViewById(R.id.btnSpektakle);
        btn2 = (Button) view.findViewById(R.id.btnCennik);
        btn3 = (Button) view.findViewById(R.id.btnKasa);
        btn4 = (Button) view.findViewById(R.id.btnONas);
        btn5 = (Button) view.findViewById(R.id.btnKontakt);
        btn6 = (Button) view.findViewById(R.id.btnZespolA);
        btn7 = (Button) view.findViewById(R.id.btnZespolT);
        btn8 = (Button) view.findViewById(R.id.btnZespolAd);
        btn9 = (Button) view.findViewById(R.id.btnHistoria);
        btn10 = (Button) view.findViewById(R.id.btninIcyatywa1);
        btn11 = (Button) view.findViewById(R.id.btnInicyatywa2);
        btn12 = (Button) view.findViewById(R.id.btnLekcje);
        btn13 = (Button) view.findViewById(R.id.btnGallery);
        btn14 = (Button) view.findViewById(R.id.btnMap);
        btn15 = (Button) view.findViewById(R.id.btnWView);

        ImageView imgLogo = (ImageView) view.findViewById(R.id.imageView14);
        imgLogo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://grproject.tech"));
                startActivity(intent);
            }
        });

        ImageView img = (ImageView) view.findViewById(R.id.imageViewFacebook);
        img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.facebook.com/moj.teatr"));
                startActivity(intent);
            }
        });

        // Spektakle
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((com.example.newtheater.MainActivity) getActivity()).setViewPager(1);
            }
        });

        // cennik
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((com.example.newtheater.MainActivity)(getActivity())).setViewPager(2);
            }
        });


        // kasa
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((com.example.newtheater.MainActivity) getActivity()).setViewPager(3);
            }
        });

        // o nas
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((com.example.newtheater.MainActivity) getActivity()).setViewPager(4);
            }
        });

        // kontakt
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((com.example.newtheater.MainActivity) getActivity()).setViewPager(5);
            }
        });

        // zespol A
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((com.example.newtheater.MainActivity) getActivity()).setViewPager(6);
            }
        });

        // zespol T
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((com.example.newtheater.MainActivity) getActivity()).setViewPager(7);
            }
        });

        // zespol Ad
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((com.example.newtheater.MainActivity) getActivity()).setViewPager(8);
            }
        });

        // Historia
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((com.example.newtheater.MainActivity) getActivity()).setViewPager(9);
            }
        });

        // Inicyatywa 1
        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((com.example.newtheater.MainActivity) getActivity()).setViewPager(10);
            }
        });

        // Inicyatywa 2
        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((com.example.newtheater.MainActivity) getActivity()).setViewPager(11);
            }
        });

        // Lekcje
        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((com.example.newtheater.MainActivity) getActivity()).setViewPager(12);
            }
        });

        // Galeria
        btn13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((com.example.newtheater.MainActivity) getActivity()).setViewPager(17);
            }
        });

        // Map
        btn14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((com.example.newtheater.MainActivity) getActivity()).setViewPager(18);
            }
        });

        // WView
        btn15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((com.example.newtheater.MainActivity) getActivity()).setViewPager(19);
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
