package com.android.realtimeregister;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link profile#newInstance} factory method to
 * create an instance of this fragment.
 */
public class profile extends Fragment {

    String susername, semail, spassword, sgender, slocation;
    TextView user, em, pass, gend, locat;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public profile() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment profile.
     */
    // TODO: Rename and change types and number of parameters
    public static profile newInstance(String param1, String param2) {
        profile fragment = new profile();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        user = view.findViewById(R.id.prouser);
        em = view.findViewById(R.id.proemail);
        pass = view.findViewById(R.id.propass);
        gend = view.findViewById(R.id.progender);
        locat = view.findViewById(R.id.prolocation);

        Bundle bundle = getArguments();
        if (bundle != null) {
            susername = bundle.getString("username");
            spassword = bundle.getString("password");
            semail = bundle.getString("email");
            sgender = bundle.getString("gender");
            slocation = bundle.getString("location");
        }

        // Update UI or logic based on receivedMessage


        user.setText(susername);
        em.setText(semail);
        pass.setText(spassword);
        gend.setText(sgender);
        locat.setText(slocation);

        return view;
    }
}