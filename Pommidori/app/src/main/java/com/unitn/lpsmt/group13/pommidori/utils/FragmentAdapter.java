package com.unitn.lpsmt.group13.pommidori.utils;

import com.unitn.lpsmt.group13.pommidori.fragments.NewActivityFragment;
import com.unitn.lpsmt.group13.pommidori.fragments.NewSessionFregment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class FragmentAdapter extends FragmentStateAdapter {

    public FragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position){
            case 1: return new NewSessionFregment();
        }
        return new NewActivityFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}