package sidespell.tech.viewholderquiz.entities;

/**
 * This is a representation of a movie.
 */
public class Movie {

    private String mName;
    private String mGenre;
    private String mSummary;
    private int    mImageId;

    /**
     * Creates a new instance of a {@link Movie}.
     */
    public Movie() {
    }

    /**
     * Creates a new instance of a {@link Movie}.
     */
    public Movie(String name, String genre, String summary, int imageId) {
        mName = name;
        mGenre = genre;
        mSummary = summary;
        mImageId = imageId;
    }

    /**
     * Gets the movie name.
     */
    public String getName() {
        return mName;
    }

    /**
     * Sets a movie name.
     */
    public Movie setName(String name) {
        mName = name;
        return this;
    }

    /**
     * Gets the movie genre.
     */
    public String getGenre() {
        return mGenre;
    }

    /**
     * Sets the movie genre.
     */
    public Movie setGenre(String genre) {
        mGenre = genre;
        return this;
    }

    /**
     * Gets the movie summary.
     */
    public String getSummary() {
        return mSummary;
    }

    /**
     * Sets the movie summary.
     */
    public Movie setSummary(String summary) {
        mSummary = summary;
        return this;
    }

    /**
     * Gets the cover image id of the movie.
     */
    public int getImageId() {
        return mImageId;
    }

    /**
     * Sets the cover image id of the movie.
     */
    public Movie setImageId(int imageId) {
        mImageId = imageId;
        return this;
    }
}
