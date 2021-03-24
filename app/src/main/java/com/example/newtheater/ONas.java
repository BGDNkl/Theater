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

public class ONas extends Fragment
{
    private Button btnFrag;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.page1_lay,container,false);

        ImageView img = (ImageView)view.findViewById(R.id.imageView14);
        img.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                ((com.example.newtheater.MainActivity)getActivity()).setViewPager(0);
            }
        });


        btnFrag = (Button) view.findViewById(R.id.btnBack);

        btnFrag.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                ((com.example.newtheater.MainActivity)getActivity()).setViewPager(0);
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
