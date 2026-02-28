package umg.edu.gt.queueHandler;

public class Song {
    private final String title;
    private final String artist;
    private final int duration;
    private final int priority;

    public Song(String title, String artist, int duration, int priority) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
        this.priority = priority;
    }

    public String getTitle() { return title; }
    public String getArtist() { return artist; }
    public int getDuration() { return duration; }
    public int getPriority() { return priority; }
}