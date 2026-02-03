package controller;

import model.Media;
import model.Song;
import model.Podcast;
import service.MediaService;

import java.util.List;
import java.util.Scanner;

public class MediaController {

    private final MediaService mediaService;
    private final Scanner scanner = new Scanner(System.in);

    public MediaController(MediaService mediaService) {
        this.mediaService = mediaService;
    }

    public void start() {
        while (true) {
            System.out.println("1. Add Song");
            System.out.println("2. Add Podcast");
            System.out.println("3. Show all media");
            System.out.println("4. Delete media");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1 -> addSong();
                    case 2 -> addPodcast();
                    case 3 -> showAll();
                    case 4 -> delete();
                    case 0 -> {
                        System.out.println("Exiting...");
                        return;
                    }
                    default -> System.out.println("Invalid choice");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void addSong() {
        System.out.print("Song name: ");
        String name = scanner.nextLine();
        System.out.print("Duration (seconds): ");
        int duration = scanner.nextInt();
        scanner.nextLine();

        Song song = new Song(0, name, duration);
        mediaService.create(song);
        System.out.println("Song added!");
    }

    private void addPodcast() {
        System.out.print("Podcast name: ");
        String name = scanner.nextLine();
        System.out.print("Duration (seconds): ");
        int duration = scanner.nextInt();
        scanner.nextLine();

        Podcast podcast = new Podcast(0, name, duration);
        mediaService.create(podcast);
        System.out.println("Podcast added!");
    }

    private void showAll() {
        List<Media> all = mediaService.getAll();
        all.forEach(m -> System.out.println(
                m.getId() + ": " + m.getDisplayName() + " - " + m.getDuration() + "s"
        ));
    }

    private void delete() {
        System.out.print("Enter media ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        mediaService.delete(id);
        System.out.println("Deleted successfully!");
    }
}
