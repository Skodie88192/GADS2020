package com.skodie.gadsleaderboard;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

public class LeaderboardActivity extends AppCompatActivity {
    TabLayout mTabLayout;
    ViewPager2 mViewPager;
    private String[] mTabTitles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);
        //Link XML to Java Code
        mTabTitles = getResources().getStringArray(R.array.tab_titles);
        mTabLayout = findViewById(R.id.tabLayoutHome);
        mViewPager = findViewById(R.id.viewPagerHome);
        Button submit = (Button)findViewById(R.id.submit);
        //Attach OnClickListener to our submit button
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent submitActivity = new Intent(LeaderboardActivity.this, SubmissionActivity.class);
                startActivity(submitActivity);
            }
        });
        //Add 2 tabs to the TabLayout
        mTabLayout.addTab(mTabLayout.newTab());
        mTabLayout.addTab(mTabLayout.newTab());
        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //Viewpager Adapter and attach to ViewPager2
        MyViewPagerAdapter adapter = new MyViewPagerAdapter(this, 2);
        mViewPager.setAdapter(adapter);
        // TabLayoutMediator to link the TabLayout to the ViewPager2
        new TabLayoutMediator(mTabLayout, mViewPager,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        Log.e("Tab", String.valueOf(position));
                        tab.setText(mTabTitles[position]);
                    }
                }
        ).attach();
    }


}

class MyViewPagerAdapter extends FragmentStateAdapter {
    int mTotalTabs;

    public MyViewPagerAdapter(@NonNull FragmentActivity fm, int totalTabs) {
        super(fm);
        this.mTotalTabs = totalTabs;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                LeadersFragment leadersFragment = new LeadersFragment();
                return leadersFragment;
            case 1:
                SkilliqFragment skilliQFragment = new SkilliqFragment();
                return skilliQFragment;
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {

        return mTotalTabs;
    }

}
