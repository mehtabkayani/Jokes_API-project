/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Folder;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

/**
 *
 * @author mehtab
 */
public class JokeClient {

    static Client client = ClientBuilder.newClient();

    //*Random Jokes
    static WebTarget target = client.target("https://official-joke-api.appspot.com/random_joke");
    //*List of Jokes URL
    //static WebTarget target = client.target("https://official-joke-api.appspot.com/jokes/ten");

    //*Prints a random Joke
    // static Joke joke = target.request().get(Joke.class);
    public static void main(String[] args) {

        //*Prints a list of 10 Jokes
        getAllJokes();

        //*Prints a Random Joke
        getRandomJoke();

    }

    public static void getRandomJoke() {
        WebTarget target = client.target("https://official-joke-api.appspot.com/random_joke");
        Joke joke = target.request().get(Joke.class);
        System.out.println("******************1 Random Joke*************************");
        System.out.println(joke);

    }

    public static Joke[] getAllJokes() {
        WebTarget target = client.target("https://official-joke-api.appspot.com/jokes/ten");
        Joke[] jokes = target.request().get(Joke[].class);
        System.out.println("*****************10 Random JOKES************************");

        for (Joke joke : jokes) {
            System.out.println(joke);
        }

        return jokes;

    }
}
