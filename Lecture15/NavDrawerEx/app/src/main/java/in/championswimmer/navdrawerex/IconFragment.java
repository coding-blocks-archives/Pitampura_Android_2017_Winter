package in.championswimmer.navdrawerex;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link IconFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class IconFragment extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_ICON_RESID = "icon_resid";

    private int iconResId;


    public IconFragment() {
        // Required empty public constructor
    }


    public static IconFragment newInstance(int iconResId) {
        IconFragment fragment = new IconFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_ICON_RESID, iconResId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            iconResId = getArguments().getInt(ARG_ICON_RESID, R.drawable.ic_menu_camera);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_icon, container, false);

        if (getActivity() instanceof MainActivity) {

        }

        ((ImageView) rootView.findViewById(R.id.ivIcon)).setImageDrawable(
                getResources().getDrawable(iconResId)
        );

        return rootView;
    }

}
