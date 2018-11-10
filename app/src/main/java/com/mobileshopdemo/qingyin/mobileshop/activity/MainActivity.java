package com.mobileshopdemo.qingyin.mobileshop.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.mobileshopdemo.qingyin.mobileshop.R;
import com.mobileshopdemo.qingyin.mobileshop.fragment.cartFragment;
import com.mobileshopdemo.qingyin.mobileshop.fragment.categoryFragment;
import com.mobileshopdemo.qingyin.mobileshop.fragment.homeFragment;
import com.mobileshopdemo.qingyin.mobileshop.fragment.personFragment;

public class MainActivity extends AppCompatActivity {
    private FragmentTransaction transaction;
    private FragmentManager fragmentManager;
    //设置3-5个碎片化界面
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            fragmentManager = getSupportFragmentManager();
            transaction = fragmentManager.beginTransaction();
            //选择页面
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //绑定页面
                    transaction.replace(R.id.content, new homeFragment());
                    transaction.commit();
                    return true;
                case R.id.navigation_category:
                    transaction.replace(R.id.content, new categoryFragment());
                    transaction.commit();
                    return true;
                case R.id.navigation_cart:
                    transaction.replace(R.id.content, new cartFragment());
                    transaction.commit();
                    return true;
                case R.id.navigation_person:
                    transaction.replace(R.id.content, new personFragment());
                    transaction.commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setDefaultFragment();
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    // 设置默认进来是tab 显示的页面
    private void setDefaultFragment() {
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.content, new homeFragment()).commit();

    }


}
