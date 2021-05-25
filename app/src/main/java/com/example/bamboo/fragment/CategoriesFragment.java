package com.example.bamboo.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.bamboo.R;
import com.example.bamboo.activity.MoreActivity;

import de.hdodenhof.circleimageview.CircleImageView;


public class CategoriesFragment extends Fragment {

    FilterSearchFragment filterSearchFragment;
    DrawerLayout drawerLayout;
    ImageView gatefilterSearchFragment;
    Activity activity;

    public CategoriesFragment(Activity activity) {
        this.activity=activity;

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       return inflater.inflate(R.layout.fragment_categories, container, false);


    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        gatefilterSearchFragment=view.findViewById(R.id.filter_search);
        drawerLayout=view.findViewById(R.id.drawer_layout);
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        filterSearchFragment = (FilterSearchFragment) getChildFragmentManager().findFragmentById(R.id.fragment_navigation_search);

            filterSearchFragment.setUp(R.id.fragment_navigation_search
                , drawerLayout);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        openSearchFilter();

    }


    private void openSearchFilter() {
        gatefilterSearchFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);

                filterSearchFragment.openDrawer((CoordinatorLayout) getActivity().findViewById(R.id.cl_container)
                        ,getActivity().findViewById(R.id.fragment_navigation_search));
            }
        });
    }

}