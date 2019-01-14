package com.ghozay19.praditaapps.main.user.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ghozay19.praditaapps.R;
import com.ghozay19.praditaapps.utils.SharedPrefManager;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }

    SharedPrefManager sharedPrefManager;
    TextView tvResultNama, tvResultNim;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        sharedPrefManager = new SharedPrefManager(getContext());

        tvResultNim = (TextView) view.findViewById(R.id.userNim);
        tvResultNama = (TextView) view.findViewById(R.id.userName);

        tvResultNim.setText(sharedPrefManager.getSPNim());
        tvResultNama.setText(sharedPrefManager.getSPNama());

//        ActionProcessButton btnLogout = (ActionProcessButton) view.findViewById(R.id.btnLogout);
//        btnLogout.setMode(ActionProcessButton.Mode.PROGRESS);
return view;
    }
}
