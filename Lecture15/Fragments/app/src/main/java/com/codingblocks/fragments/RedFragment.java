package com.codingblocks.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * Created by championswimmer on 27/01/18.
 */

public class RedFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(
            LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_blank, null);
        FrameLayout flBackground = rootView.findViewById(R.id.flBackground);
        flBackground.setBackgroundColor(Color.RED);

        return rootView;

    }
}
