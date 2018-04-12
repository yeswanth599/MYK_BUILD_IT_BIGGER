package com.udacity.gradle.builditbigger.jokesserve;

import java.util.Random;

public class JokesStore {

        private String[] jokesList;
        private Random selectRandomJoke;

        public JokesStore() {
            jokesList = new String[10];
            jokesList[0] = "Some things Man was never meant to know. For everything else, there’s Google.";
            jokesList[1] = "In order to understand recursion, you must first understand recursion.";
            jokesList[2] = "There's a band called 1023MB. They haven't had any gigs yet.";
            jokesList[3] = "CAPS LOCK – Preventing Login Since 1980";
            jokesList[4] = "How many programmers does it take to change a light bulb? None. It's a hardware problem.";
            jokesList[5] = "What do you call 8 hobbits? A hobbyte";
            jokesList[6] = "An SQL Query walks into a bar and sees two tables. He walks up and asks, 'Can I join you?'";
            jokesList[7] = "ASCII a silly question and I shall give you a silly ANSI";
            jokesList[8] = "There are only 10 types of people in the world: those that understand binary and those that don’t.";
            jokesList[9] = "Be nice to the nerds, for all you know they might be the next Bill Gates!";
            selectRandomJoke = new Random();
        }

        public String[] getJokes() {
            return jokesList;
        }

        public String getRandomJoke() {
            return jokesList[selectRandomJoke.nextInt(jokesList.length)];
        }
}
