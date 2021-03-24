package com.example.newtheater;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentManager;
//import androidx.fragment.app.FragmentPagerAdapter;
//import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity
{
    // *
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //*
        mViewPager = (ViewPager) findViewById(R.id.containerOfFragments);
        setupViewPaper(mViewPager);
    }

    private void setupViewPaper(ViewPager viewPager)
    {
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager());

        adapter.addFragment(new Menu(),"Menu");

        adapter.addFragment(new Spektakle(),"Spektakle");
        adapter.addFragment(new Cennik(),"Cennik");
        adapter.addFragment(new Kasa(),"Kasa");
        adapter.addFragment(new ONas(),"ONas");

        adapter.addFragment(new Kontakt(),"Kontakt");
        adapter.addFragment(new ZespolA(),"ZespolA");
        adapter.addFragment(new ZespolT(),"ZespolT");
        adapter.addFragment(new ZespolAd(),"ZespolAd");

        adapter.addFragment(new Historia(),"Historia");
        adapter.addFragment(new Inic1(),"Inic1");
        adapter.addFragment(new Inic2(),"Inic2");
        adapter.addFragment(new Lekcje(),"Lekcje");

        adapter.addFragment(new Spek1(),"Spek1");
        adapter.addFragment(new Spek2(),"Spek2");
        adapter.addFragment(new Spek3(),"Spek3");
        adapter.addFragment(new Spek4(),"Spek4");

        adapter.addFragment(new Video(),"video_lay");
        adapter.addFragment(new Map(),"map_lay");
        adapter.addFragment(new WView(),"view_lay");


        viewPager.setAdapter(adapter);
    }

    public void setViewPager(int FragmentNumber)
    {
        mViewPager.setCurrentItem(FragmentNumber);
    }
}