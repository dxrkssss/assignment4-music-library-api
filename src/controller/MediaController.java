package controller;

import dto.MediaDTO;
import service.MediaService;

public class MediaController {
    private MediaService service = new MediaService();

    public void create(MediaDTO dto) {
        service.add(dto);
    }

    public void showAll() {
        service.printAll();
    }
}