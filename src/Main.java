import dto.MediaDTO;
import controller.MediaController;

public class Main {
    public static void main(String[] args) {
        MediaController controller = new MediaController();

        MediaDTO song = new MediaDTO();
        song.name = "Save Your Tears";
        song.type = "SONG";
        song.duration = 216;

        MediaDTO podcast = new MediaDTO();
        podcast.name = "Java Basics";
        podcast.type = "PODCAST";
        podcast.duration = 1800;

        controller.create(song);
        controller.create(podcast);

        controller.showAll();
    }
}