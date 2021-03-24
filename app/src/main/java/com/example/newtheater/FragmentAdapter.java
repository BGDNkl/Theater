package com.example.newtheater;

import java.util.ArrayList;
import java.util.List;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class FragmentAdapter extends FragmentStatePagerAdapter
{

    private final List<Fragment> mListafragmentow = new ArrayList<>();
    private final List<String> mListaTytulowFrag = new ArrayList<>();

    public FragmentAdapter(FragmentManager fm)
    {
        super(fm);
    }

    public void addFragment(Fragment fragment, String title)
    {
        mListafragmentow.add(fragment);
        mListaTytulowFrag.add(title);
    }

    @Override
    public Fragment getItem(int position)
    {
        return mListafragmentow.get(position);
    }

    @Override
    public int getCount()
    {
        return mListafragmentow.size();
    }
}
