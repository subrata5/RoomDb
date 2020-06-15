package com.subrata.roomdbexample.fragmentUI;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.subrata.roomdbexample.MainActivity;
import com.subrata.roomdbexample.R;
import com.subrata.roomdbexample.dbComponents.User;

import java.util.List;


public class ReadUserFragment extends Fragment {

    private TextView tv_info;

    public ReadUserFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_read_user, container, false);


        //initialize
        tv_info = view.findViewById(R.id.tv_info);

        //Get data from room db and populate in the t.v
        List<User> users = MainActivity.myDatabase.myDao().getUsers();
        String info = "";

        for (User user : users) {
            int id = user.getId();
            String name = user.getName();
            String email = user.getEmail();

            info = info + "\n\n" + "Id: " + id + "\n" +
                    "Name: " + name + "\n" +
                    "Email: " + email + "\n";
        }

        tv_info.setText(info);

        return view;
    }
}