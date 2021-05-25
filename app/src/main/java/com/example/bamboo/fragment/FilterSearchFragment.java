package com.example.bamboo.fragment;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarFinalValueListener;
import com.crystal.crystalrangeseekbar.widgets.CrystalRangeSeekbar;
import com.example.bamboo.R;


public class FilterSearchFragment extends Fragment {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
View view;
CrystalRangeSeekbar seekBarPrice;
    TextView tvMinPrice,tvMaxPrice;



    public FilterSearchFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_filter_search, container, false);
        seekBarPrice =view.findViewById(R.id.rangeSeekbarprice);
        tvMinPrice =view.findViewById(R.id.min_price_txt);
        tvMaxPrice =view.findViewById(R.id.max_price_txt);
        onChangeRangeSeekbarPrice();
        return  view;
    }

    private void onChangeRangeSeekbarPrice() {
        seekBarPrice.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
            @Override
            public void valueChanged(Number minValue, Number maxValue) {
                int width = seekBarPrice.getWidth() - seekBarPrice.getPaddingLeft() - seekBarPrice.getPaddingRight();
                Long min= (Long) minValue;
                double thumbMinPos = width * (min /(float)1200);
                tvMinPrice.setTranslationX((float) thumbMinPos) ;

                Long max= (Long) maxValue;
                double thumbMaxPos = width * (max /(float)900);


                tvMaxPrice.setX((float) thumbMaxPos) ;

                tvMinPrice.setText((minValue)+"$");
                tvMaxPrice.setText((maxValue)+"$");
            }
        });

        seekBarPrice.setOnRangeSeekbarFinalValueListener(new OnRangeSeekbarFinalValueListener() {
            @Override
            public void finalValue(Number minValue, Number maxValue) {
                tvMinPrice.setText((minValue)+"$");
                tvMaxPrice.setText((maxValue)+"$");
            }
        });
    }
    public void openDrawer(final CoordinatorLayout drawerLayout, final View fragment) {

        if (!mDrawerLayout.isDrawerOpen(Gravity.RIGHT)) {
            mDrawerLayout.openDrawer(Gravity.RIGHT);
            mDrawerLayout.setScrimColor(getResources().getColor(android.R.color.transparent));
            mDrawerLayout.setDrawerElevation(0);
            mDrawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
                @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                @Override
                public void onDrawerSlide(View drawer, float slideOffset) {
                    drawerLayout.setX(fragment.getWidth() * -slideOffset);
                    RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) drawerLayout.getLayoutParams();
                    lp.height = drawer.getHeight() - (int) (drawer.getHeight() * slideOffset * 0.3f);
                    lp.topMargin = (drawer.getHeight() - lp.height) / 2;

                    drawerLayout.setLayoutParams(lp);
                }

                @Override
                public void onDrawerClosed(View drawerView) {
                }

                @Override
                public void onDrawerOpened(View drawerView) {
                    super.onDrawerOpened(drawerView);



                }
            });

        }
    }

    public void setUp(int fragmentId, DrawerLayout drawerLayout) {
//        View containerView = getActivity().findViewById(fragmentId);
        mDrawerLayout = drawerLayout;


        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

                if (getActivity() != null) {
                    getActivity().invalidateOptionsMenu();
                }


            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);

                if (getActivity() != null) {
                    getActivity().invalidateOptionsMenu();
                }


            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);

            }
        };

//        mDrawerToggle.setHomeAsUpIndicator(R.drawable.icon_menu);
        mDrawerToggle.setDrawerIndicatorEnabled(false);

        mDrawerToggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mDrawerLayout.isDrawerOpen(Gravity.RIGHT)) {
                    mDrawerLayout.closeDrawer(Gravity.RIGHT);
                } else {
                    mDrawerLayout.openDrawer(Gravity.RIGHT);
                }
            }
        });

        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });
    }
    public void closeDrawer() {
        if (mDrawerLayout.isDrawerOpen(Gravity.RIGHT)) {
            mDrawerLayout.closeDrawer(Gravity.RIGHT);
        }
    }
}