public class Movie {
    private String title;
    private String director;

    public Movie(String title, String director) {
        this.title = title;
        this.director = director;
    }

    // Getter and setter methods
    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    // TODO: Override equals() method
    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (!(other instanceof Movie))
            return false;
        Movie m = (Movie) other;
        return this.title.equals(m.title) && this.director.equals(m.director);
    }

    public static void main(String[] args) {
        Movie m1 = new Movie("Inception", "Christopher Nolan");
        Movie m2 = new Movie("Inception", "Christopher Nolan");
        Movie m3 = new Movie("Interstellar", "Christopher Nolan");

        System.out.println(m1.equals(m2)); // true
        System.out.println(m1.equals(m3)); // false
    }
}