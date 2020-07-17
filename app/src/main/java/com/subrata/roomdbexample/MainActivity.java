package com.subrata.roomdbexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;

import android.os.Bundle;

import com.subrata.roomdbexample.dbComponents.MyDatabase;
import com.subrata.roomdbexample.fragmentUI.Home_fragment;

public class MainActivity extends AppCompatActivity {

    public static FragmentManager fragmentManager;
    public static MyDatabase myDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize
        fragmentManager = getSupportFragmentManager();
        //A db must not run in main thread, use asyc task or rxjava to perfom db activity.
        //using allow method for time-being
        myDatabase = Room.databaseBuilder(getApplicationContext(), MyDatabase.class, "userDB").allowMainThreadQueries().build();

        //place fragment in the main activity
        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }

            fragmentManager.beginTransaction().add(R.id.fragment_container, new Home_fragment()).commit();
            //Made test change
            //Change 2
        }

    }
}