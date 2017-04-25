package com.example;

import java.util.Random;

public class JokeSupplier {



    private String[] jokes;
    private Random rand;

    public JokeSupplier() {
        jokes = new String[8];
        jokes[0] = "A SQL query goes into a bar, walks up to two tables and asks, \"Can I join you?\"";
        jokes[1] = "Q: How many prolog programmers does it take to change a lightbulb? A: Yes.";
        jokes[2] = "Why do Java developers wear glasses? Because they can't C#";
        jokes[3] = "How does a computer tell you it needs more memory? It says 'byte me'";
        jokes[4] = "What did Mr. Spock find in the toilet? The Captain's log!";
        jokes[5] = "Why did the computer go to the doctor? Because it had a virus!";
        jokes[6] = "This is a funny joke!";
        jokes[7] = "This is a super awesome funny joke!!!";
        rand = new Random();
    }

    public String getRandomJoke() {

        return jokes[rand.nextInt(jokes.length)];
    }

}
