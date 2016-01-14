package sidespell.tech.viewholderquiz.controllers;

import java.util.ArrayList;
import java.util.List;

import sidespell.tech.viewholderquiz.R;
import sidespell.tech.viewholderquiz.entities.Movie;

public class MoviesController {

    private List<Movie> mMovies;

    public MoviesController() {
        // create all the movies here
        mMovies = new ArrayList<>();
        mMovies.add(new Movie("Rogue One: A Star Wars Story", "Action", "Rebels set out on a mission to steal the plans for the Death Star.", R.drawable.movie01));
        mMovies.add(new Movie("Deadpool", "Adventure", "A former Special Forces operative turned mercenary is subjected to a rogue experiment that leaves him with accelerated healing powers and adopts the alter ego Deadpool.", R.drawable.movie02));
        mMovies.add(new Movie("The Forest", "Horror", "A woman goes into Japan's Suicide Forest to find her twin sister, and confronts supernatural terror.", R.drawable.movie03));
        mMovies.add(new Movie("Batman v Superman: Dawn of Justice", "Fantasy", "Fearing the actions of Superman left unchecked, Batman takes on Superman, while the world wrestles with what kind of a hero the world really needs. With Batman and Superman fighting each other, a new threat Doomsday created by Lex Luthor. Its up to Superman and Batman to set aside their difference along with Wonder Woman to stop Lex Luthor and Doomsday from destroying Metropolis.", R.drawable.movie04));
        mMovies.add(new Movie("Captain America: Civil War", "Sci-Fi", "Political interference in the Avengers' activities causes a rift between former allies Captain America and Iron Man.", R.drawable.movie05));
        mMovies.add(new Movie("X-Men: Apocalypse", "Action", "With the emergence of the world's first mutant, Apocalypse, the X-Men must unite to defeat his extinction level plan.", R.drawable.movie06));
        mMovies.add(new Movie("Ghostbusters", "Sci-Fi", "The plot is unknown at this time.", R.drawable.movie07));
        mMovies.add(new Movie("Suicide Squad", "Action", "A secret government agency recruits imprisoned supervillains to execute dangerous black ops missions in exchange for clemency.", R.drawable.movie08));
        mMovies.add(new Movie("Assassin\'s Creed", "Action", "When Callum Lynch (Michael Fassbender) explores the memories of his ancestor Aguilar and gains the skills of a Master Assassin, he discovers he is a descendant of the secret Assassins society.", R.drawable.movie09));
        mMovies.add(new Movie("13 Hours: The Secret Soldiers of Benghazi", "Drama", "An American Ambassador is killed during an attack at a U.S. compound in Libya as a security team struggles to make sense out of the chaos.", R.drawable.movie10));

    }

    public List<Movie> getMovies() {
        return mMovies;
    }
}
