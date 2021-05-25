package com.example.bamboo.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bamboo.R;
import com.example.bamboo.activity.ChatBranch;

public class MoreFragment extends Fragment {

TextView profileTxt,settings,liveChat;
    public MoreFragment() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_more, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        profileTxt=view.findViewById(R.id.profile);
        settings=view.findViewById(R.id.settings);
        liveChat=view.findViewById(R.id.live_chat);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        goProfile();
        Settings();
        LiveChat();

    }

    private void LiveChat() {
        liveChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().startActivity(new Intent(getContext(), ChatBranch.class));
            }
        });
    }

    private void Settings() {
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SettingSheetFragment settingSheetFragment = new SettingSheetFragment();
                settingSheetFragment.show(getFragmentManager(),settingSheetFragment.getTag());
            }
        });
    }

    private void goProfile() {
profileTxt.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
         getActivity().getSupportFragmentManager().beginTransaction()
                 .setCustomAnimations(
                         R.anim.slide_in,
                         R.anim.fade_out,
                         R.anim.fade_in,
                         R.anim.slide_out
                 ).replace(R.id.more_frame,new ProfileFragment()).addToBackStack("ytt").commit();

    }
});
    }
}