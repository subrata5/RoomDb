package com.subrata.roomdbexample.fragmentUI;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.subrata.roomdbexample.MainActivity;
import com.subrata.roomdbexample.R;
import com.subrata.roomdbexample.dbComponents.User;


public class Add_user_fragment extends Fragment {

    private EditText ed_userId, ed_name, ed_email;
    private Button btn_add;

    public Add_user_fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_user, container, false);

        //Initialize Views
        ed_userId = view.findViewById(R.id.ed_userid);
        ed_name = view.findViewById(R.id.ed_name);
        ed_email = view.findViewById(R.id.ed_email);
        btn_add = view.findViewById(R.id.btn_add_single_user);

        //Set on click listener
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Get values from the edit texts
                int id = Integer.parseInt(ed_userId.getText().toString().trim());
                String name = ed_name.getText().toString().trim();
                String email = ed_email.getText().toString().trim();

                //Initialize user object and add to room db
                User user = new User();
                user.setId(id);
                user.setName(name);
                user.setEmail(email);

                try {
                    MainActivity.myDatabase.myDao().addUser(user);
                    Toast.makeText(getActivity(), "Adding user success", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(getActivity(), "" + e.toString(), Toast.LENGTH_SHORT).show();
                    return;
                }


                //clear the edit texts after saving to db
                ed_userId.setText("");
                ed_name.setText("");
                ed_email.setText("");

            }
        });

        return view;
    }
}