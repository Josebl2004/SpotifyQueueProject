package umg.edu.gt.queueHandler;

public class Main {
    public static void main(String[] args) {

        PlaylistManager pm = new PlaylistManager();

        // Alta prioridad (1): A1, A2
        pm.addSong(new Song("La Vuelta Al Mundo", "Calle 13", 10, 1));
        pm.addSong(new Song("Te Recordare", "El Trono de Mexico", 6, 1));

        // Normal (2): N1, N2, N3
        pm.addSong(new Song("Afuera", "Caifanes", 11, 2));
        pm.addSong(new Song("Eres", "Cafe Tacuba", 10, 2));
        pm.addSong(new Song("Sabor a Chocolate", "Elefante", 5, 2));

        pm.playAll();
    }
}