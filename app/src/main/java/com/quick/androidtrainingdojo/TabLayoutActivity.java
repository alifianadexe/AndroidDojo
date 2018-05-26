package com.quick.androidtrainingdojo;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.quick.androidtrainingdojo.baseactivity.AppBaseActivity;
import com.quick.androidtrainingdojo.fragment.FragmentFour;
import com.quick.androidtrainingdojo.fragment.FragmentOne;
import com.quick.androidtrainingdojo.fragment.FragmentThree;
import com.quick.androidtrainingdojo.fragment.FragmentTwo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ditya on 5/22/18.
 */

public class TabLayoutActivity extends AppBaseActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.tab_layout);

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager){
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentOne(), "One");
        adapter.addFragment(new FragmentTwo(), "Two");
        adapter.addFragment(new FragmentThree(), "Three");
        //adapter.addFragment(new FragmentFour(), "Four");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter{

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitle = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title){
            mFragmentList.add(fragment);
            mFragmentTitle.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position){
            return mFragmentTitle.get(position);
        }
    }


}
