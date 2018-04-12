package com.udacity.gradle.builditbigger.jokesdisplay;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class JokesDisplayFragment extends Fragment {
    Toolbar mToolBar;
    ActionBar actionBar;
    TextView displayJokeTextView;
    public static final String RANDOM_JOKE_INFO ="random_joke";
    String jokeReceive=null;
    public JokesDisplayFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //retrive data from savedInstanceState
        if (savedInstanceState != null) {
            jokeReceive = savedInstanceState.getString(RANDOM_JOKE_INFO);

        }

        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_jokes_display, container, false);
        mToolBar = (Toolbar) rootView.findViewById(R.id.toolbar);
        actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        actionBar.hide();
        mToolBar.setTitle(getContext().getString(R.string.display_fragment_toolbar));
        mToolBar.setNavigationIcon(R.drawable.ic_arrow_back_white);
        displayJokeTextView=(TextView)rootView.findViewById(R.id.display_joke);
        jokeReceive = getActivity().getIntent().getStringExtra(getContext().getString(R.string.joke_transfer));
        displayJokeTextView.setText(jokeReceive);
        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Toast.makeText(getContext(),"Fragment Back Pressed"+fragmentManager.getBackStackEntryCount(),Toast.LENGTH_SHORT).show();
                //getActivity().finish();
                //getFragmentManager().popBackStack("RecipeStepsBackStack", 0);
                onBackPressed();
            }
        });
        return rootView;
    }
    public void onBackPressed() {
        //getFragmentManager().popBackStack("RecipeStepsBackStack", 0);
        super.getActivity().finish();

    }
    public void onSaveInstanceState(Bundle currentState) {
        currentState.putString(RANDOM_JOKE_INFO, jokeReceive);
    }
}
