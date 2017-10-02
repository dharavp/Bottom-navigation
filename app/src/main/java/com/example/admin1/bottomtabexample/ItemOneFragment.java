package com.example.admin1.bottomtabexample;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by admin1 on 10/2/17.
 */

public class ItemOneFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;

    public static ItemOneFragment newInstance() {
        ItemOneFragment fragment = new ItemOneFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_item_one, container, false);
        tabLayout=(TabLayout)view.findViewById(R.id.tab_layout);
        viewPager=(ViewPager)view.findViewById(R.id.pager);
        setupViewPager(viewPager);

        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
        return view;
    }
    private void setupViewPager(ViewPager viewPager) {
        PagerAdapter adapter =
                new PagerAdapter(getChildFragmentManager());
        adapter.addFragment(new TabFragment1(), "Tab1");
        adapter.addFragment(new TabFragment2(), "Tab2");
        adapter.addFragment(new TabFragment3(), "Tab3");
        viewPager.setAdapter(adapter);
    }
    private void setupTabIcons() {

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.custom_tab, null);
        TextView tabOne =(TextView)view.findViewById(R.id.text);
        tabOne.setText("One");
        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_home_black_24dp, 0, 0);
        tabLayout.getTabAt(0).setCustomView(tabOne);

        View view1 = LayoutInflater.from(getActivity()).inflate(R.layout.custom_tab, null);
        TextView tabTwo =(TextView)view1.findViewById(R.id.text);
        tabTwo.setText("Two");
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_favorite_border_black_24dp, 0, 0);
        tabLayout.getTabAt(1).setCustomView(tabTwo);

        View view2 = LayoutInflater.from(getActivity()).inflate(R.layout.custom_tab, null);
        TextView tabThree =(TextView)view2.findViewById(R.id.text);
        tabThree.setText("Three");
        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_settings_black_24dp, 0, 0);
        tabLayout.getTabAt(2).setCustomView(tabThree);
//
//        TextView tabThree = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.custom_tab, null);
//        tabThree.setText("THREE");
//        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_settings_black_24dp, 0, 0);
//        tabLayout.getTabAt(2).setCustomView(tabThree);
    }
}
