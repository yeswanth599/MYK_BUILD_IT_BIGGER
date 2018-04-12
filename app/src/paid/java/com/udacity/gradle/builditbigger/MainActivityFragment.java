package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.udacity.gradle.builditbigger.jokesdisplay.JokesDisplayActivity;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    Button buttonViewJoke;
    String jokeData=null;
    ProgressBar progressBar;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        /*MobileAds.initialize(getContext(),"ca-app-pub-3940256099942544~3347511713");
        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("4F10F5EFC9F9C26C506EF6F5CE975BEC")
                .build();
        mAdView.loadAd(adRequest);*/
        progressBar=(ProgressBar)root.findViewById(R.id.joke_display_progressbar);
        //Creating ButtonClick Listener
        buttonViewJoke=(Button)root.findViewById(R.id.button_view_joke);
        buttonViewJoke.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                tellJoke();
            }
        });
        progressBar.setVisibility(View.GONE);
        return root;
    }
    public void tellJoke() {
        //Toast.makeText(getContext(), jokesStore.getRandomJoke(), Toast.LENGTH_SHORT).show();
        //Intent intent=new Intent(getContext(), JokesDisplayActivity.class);
        //intent.putExtra("jokeTransfer",jokesStore.getRandomJoke());
        //startActivity(intent);
        new EndpointsAsyncTask().execute(this);
    }
    /*To transfer joke to JokesDisplayFragment*/
    public void trasferJoke(String jokeForTransfer)
    {
        jokeData=jokeForTransfer;
        if(jokeData!=null) {
            Intent intent = new Intent(getActivity(), JokesDisplayActivity.class);
            intent.putExtra(getContext().getString(R.string.joke_transfer), jokeData);
            getContext().startActivity(intent);
            progressBar.setVisibility(View.GONE);
        }
        else
        {
            Toast.makeText(getContext(), getContext().getString(R.string.empty_joke), Toast.LENGTH_SHORT).show();
        }
    }
}
