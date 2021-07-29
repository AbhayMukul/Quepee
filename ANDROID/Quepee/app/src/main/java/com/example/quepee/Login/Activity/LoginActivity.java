package com.example.quepee.Login.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.example.quepee.Login.Fragment.LogInFragment;
import com.example.quepee.Login.Fragment.SignUpFragment;
import com.example.quepee.Login.FragmentAdapter.FragmentAdapter;
import com.example.quepee.R;
import com.google.android.material.tabs.TabLayout;

public class LoginActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initialize();

        setTabLayout();

    }

    private void setTabLayout() {
        final FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager());

        new Handler().post(new Runnable() {
            @Override
            public void run() {
                fragmentAdapter.addFragment(LogInFragment.getInstance(),"LogIn");
                fragmentAdapter.addFragment(SignUpFragment.getInstance(),"Sign-Up");

                viewPager.setAdapter(fragmentAdapter);

                tabLayout.setupWithViewPager(viewPager);

            }
        });
    }

    private void initialize() {
        tabLayout = findViewById(R.id.Tl_LoginActivity);
        viewPager = findViewById(R.id.Vp_LoginActivity);
    }
}