package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertTrue;

/**
 * Created by yeswa on 07-04-2018.
 */

public class EmptyStringTest {

    @RunWith(AndroidJUnit4.class)
    public class EndPointAsyncTaskTest {

        @Test
        public void check() throws Exception {
            MainActivityFragment mainActivityFragment = new MainActivityFragment();
            new EndpointsAsyncTask().execute(mainActivityFragment);
            assertTrue("Error: Random Joke Display Check = " + mainActivityFragment.jokeData, mainActivityFragment.jokeData != null);
        }
    }
}
