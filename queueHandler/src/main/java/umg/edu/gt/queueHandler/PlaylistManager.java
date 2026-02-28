package umg.edu.gt.queueHandler;

import umg.edu.gt.data_structure.queue.manual.EmptyQueueException;
import umg.edu.gt.data_structure.queue.manual.Queue;

public class PlaylistManager {

    private final Queue<Song> highPriority = new Queue<>();
    private final Queue<Song> normalPriority = new Queue<>();

    private final SongStack history = new SongStack();
    private int totalSongsPlayed = 0;
    private int totalSecondsPlayed = 0;

    public void addSong(Song song) {
        if (song.getPriority() == 1) {
            highPriority.enqueue(song);
        } else {
            normalPriority.enqueue(song);
        }

        System.out.println("[LOG] Canción agregada: " 
                + song.getTitle() + " - " + song.getArtist()
                + " (" + song.getDuration() + "s) | prioridad=" 
                + song.getPriority());
    }

    public boolean hasSongs() {
        return !highPriority.isEmpty() || !normalPriority.isEmpty();
    }

    private Song nextSong() throws EmptyQueueException {
        if (!highPriority.isEmpty()) {
            return highPriority.dequeue();
        }
        return normalPriority.dequeue();
    }

    public void playAll() {
        System.out.println("[LOG] Iniciando lista de reproducción...");

        while (hasSongs()) {
            Song song;
            try {
                song = nextSong();
            } catch (EmptyQueueException e) {
                System.out.println("[LOG] Error: cola vacía inesperadamente.");
                break;
            }

            playSong(song);

            history.push(song);
            totalSongsPlayed++;
            totalSecondsPlayed += song.getDuration();
        }

        System.out.println("[LOG] Lista de reproducción finalizada.");
        System.out.println("[LOG] Total de canciones reproducidas: " + totalSongsPlayed);
        System.out.println("[LOG] Tiempo total reproducido: " + totalSecondsPlayed + " segundos");
        System.out.println("[LOG] Canciones en el historial: " + history.size());
    }

    private void playSong(Song song) {
        System.out.println("[LOG] Reproduciendo ahora: " 
                + song.getTitle() + " - " + song.getArtist()
                + " (" + song.getDuration() + " segundos)");

        for (int sec = 1; sec <= song.getDuration(); sec++) {
            String bar = progressBar(sec, song.getDuration(), 12);

            System.out.println("[LOG] Reproduciendo: " 
                    + song.getTitle() + " | " 
                    + bar + " " 
                    + sec + "s / " + song.getDuration() + "s");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("[LOG] Reproducción interrumpida.");
                Thread.currentThread().interrupt();
                break;
            }
        }

        System.out.println("[LOG] Canción finalizada: " + song.getTitle());
    }

    private String progressBar(int current, int total, int width) {
        if (total <= 0) total = 1;

        int filled = (int) Math.round((current * 1.0 / total) * width);
        if (filled < 0) filled = 0;
        if (filled > width) filled = width;

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < width; i++) {
            sb.append(i < filled ? "#" : "-");
        }
        sb.append("]");
        return sb.toString();
    }
}