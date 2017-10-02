package com.example.admin1.bottomtabexample;

import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.navigation);
        BottomNavigationMenuView menuView = (BottomNavigationMenuView)
                bottomNavigationView.getChildAt(0);
        try {
            Field shiftingMode = menuView.getClass()
                    .getDeclaredField("mShiftingMode");

            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menuView, false);
            shiftingMode.setAccessible(false);

            for (int i = 0; i < menuView.getChildCount(); i++) {

                BottomNavigationItemView item =
                        (BottomNavigationItemView) menuView.getChildAt(i);
                item.setShiftingMode(false);
                //To update view, set the checked value again
                item.setChecked(item.getItemData().isChecked());
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();

        } catch (IllegalAccessException e) {
            e.printStackTrace();

        } catch (SecurityException e) {
            e.printStackTrace();
        }
        BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
                = new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment selectedFragment = null;
                switch (item.getItemId()) {
                    case R.id.action_item1:
                        selectedFragment = ItemOneFragment.newInstance();
                        break;
                    case R.id.action_item2:
                        selectedFragment = ItemTwoFragment.newInstance();
                        break;
                    case R.id.action_item3:
                        selectedFragment = ItemThreeFragment.newInstance();
                        break;
                    case R.id.action_item4:
                        selectedFragment = ItemFourFragment.newInstance();
                        break;
                    case R.id.action_item5:
                        selectedFragment = ItemFiveFragment.newInstance();
                        break;
                }
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout, selectedFragment);
                transaction.commit();
                return true;
            }

        };
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, ItemOneFragment.newInstance());
        transaction.commit();

        bottomNavigationView.setOnNavigationItemSelectedListener
                (mOnNavigationItemSelectedListener);

    }

}