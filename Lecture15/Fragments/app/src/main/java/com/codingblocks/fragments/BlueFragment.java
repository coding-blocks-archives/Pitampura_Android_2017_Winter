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

public class BlueFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(
            LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_blank, container);
        FrameLayout flBackground = rootView.findViewById(R.id.flBackground);
        flBackground.setBackgroundColor(Color.BLUE);

        return rootView;

    }
}
