package service;

import model.Media;
import java.util.List;

public interface MediaService {
    void create(Media media);
    Media getById(int id);
    List<Media> getAll();
    void update(int id, Media media);
    void delete(int id);
}
