package com.subrata.roomdbexample.fragmentUI;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.subrata.roomdbexample.MainActivity;
import com.subrata.roomdbexample.R;


public class Home_fragment extends Fragment implements View.OnClickListener {

    private Button btn_add_user, btn_view_user;
    private TextView test_txt;

    public Home_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_fragment, container, false);

        //Initialize view
        btn_add_user = view.findViewById(R.id.btn_add);
        btn_view_user = view.findViewById(R.id.btn_view);
        test_txt = view.findViewById(R.id.test_txt);

        test_txt.setText(getResources().getString(R.string.test));

        btn_add_user.setOnClickListener(this);
        btn_view_user.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {

        //Navigate to the user clicked fragment
        switch (v.getId()) {
            case R.id.btn_add:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,
                        new Add_user_fragment()).addToBackStack(null).commit();
                break;

            case R.id.btn_view:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,
                        new ReadUserFragment()).addToBackStack(null).commit();
        }

    }
}