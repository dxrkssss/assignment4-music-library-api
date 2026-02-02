package service;

import repository.MediaRepository;
import model.*;
import dto.MediaDTO;
import utils.InputValidator;

public class MediaService {
    private MediaRepository repository = new MediaRepository();

    public void add(MediaDTO dto) {
        InputValidator.checkName(dto.name);
        InputValidator.checkDuration(dto.duration);

        Media media;
        if (dto.type.equals("SONG")) {
            media = new Song(0, dto.name, dto.duration);
        } else {
            media = new Podcast(0, dto.name, dto.duration);
        }
        repository.create(media);
    }

    public void printAll() {
        for (Media m : repository.getAll()) {
            System.out.println(m.getId() + " " + m.getName() + " " + m.getType());
        }
    }
}