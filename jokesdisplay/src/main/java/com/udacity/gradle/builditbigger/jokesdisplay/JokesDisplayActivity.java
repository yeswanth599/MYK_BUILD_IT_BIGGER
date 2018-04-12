package com.udacity.gradle.builditbigger.jokesdisplay;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokesDisplayActivity extends AppCompatActivity {
    TextView displayJokeTextView;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes_display);
        if (savedInstanceState == null) {
            JokesDisplayFragment jokesDisplayFragment=new JokesDisplayFragment();
            fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .add(R.id.display_joke_fragment_container,jokesDisplayFragment)
                    .commit();

        }
    }
}
