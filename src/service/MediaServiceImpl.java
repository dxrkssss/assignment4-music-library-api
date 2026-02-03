package service;

import model.Media;
import repository.interfaces.CrudRepository;
import utils.InputValidator;
import exception.*;

import java.util.List;

public class MediaServiceImpl implements MediaService {

    private final CrudRepository<Media> repository;

    public MediaServiceImpl(CrudRepository<Media> repository) {
        this.repository = repository;
    }

    @Override
    public void create(Media media) {
        InputValidator.validateMedia(media);
        repository.create(media);
    }

    @Override
    public Media getById(int id) {
        return repository.getById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Media not found"));
    }

    @Override
    public List<Media> getAll() {
        return repository.getAll();
    }

    @Override
    public void update(int id, Media media) {
        InputValidator.validateMedia(media);
        repository.update(id, media);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }
}
