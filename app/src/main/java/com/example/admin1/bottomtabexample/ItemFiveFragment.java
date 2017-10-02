package com.example.admin1.bottomtabexample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by admin1 on 10/2/17.
 */

public class ItemFiveFragment extends Fragment {
    public static ItemFiveFragment newInstance() {
        ItemFiveFragment fragment = new ItemFiveFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_item_five, container, false);
    }
}
