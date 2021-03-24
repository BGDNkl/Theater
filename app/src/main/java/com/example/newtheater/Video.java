package com.example.newtheater;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Video extends Fragment
{
    private Button btnFrag;

    int [] arr = new int [] {R.drawable.gp1, R.drawable.gp2, R.drawable.gp3, R.drawable.gp4, R.drawable.gp5, R.drawable.gp6, R.drawable.gp7};
    int q = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.video_lay,container,false);

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

        // gallery
        final ImageView imgGal = (ImageView)view.findViewById(R.id.imgVBig);
        imgGal.setImageResource(arr[0]);

        Button clickButtonL = (Button) view.findViewById(R.id.left);

        clickButtonL.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(q > 0) q--; imgGal.setImageResource(arr[q]);
            }
        });

        imgGal.setImageResource(arr[2]);

        Button clickButtonR = (Button) view.findViewById(R.id.right);
        clickButtonR.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(q < 6) q++; imgGal.setImageResource(arr[q]);
            }
        });

        // video
        MediaController mc= new MediaController(getActivity());

        VideoView wview = (VideoView)view.findViewById(R.id.video_view);
        String path = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.action;
        wview.setVideoURI(Uri.parse(path));
        mc.setAnchorView(wview);
        wview.setMediaController(mc);

        //wview.start();

        return view;
    }

}


