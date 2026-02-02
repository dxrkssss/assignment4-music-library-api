package repository;

import exception.*;
import utils.DatabaseConnection;
import model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MediaRepository {

    public void create(Media media) {
        String sql = "INSERT INTO media(name, type, duration) VALUES (?, ?, ?)";

        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, media.getName());
            ps.setString(2, media.getType());
            ps.setInt(3, media.getDuration());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new DatabaseOperationException("Create failed");
        }
    }

    public List<Media> getAll() {
        List<Media> list = new ArrayList<>();
        String sql = "SELECT * FROM media";

        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String type = rs.getString("type");

                Media media;
                if ("SONG".equals(type)) {
                    media = new Song(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getInt("duration")
                    );
                } else {
                    media = new Podcast(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getInt("duration")
                    );
                }

                list.add(media);
            }

        } catch (SQLException e) {
            throw new DatabaseOperationException("Read all failed");
        }

        return list;
    }

    public Media getById(int id) {
        String sql = "SELECT * FROM media WHERE id = ?";

        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                throw new ResourceNotFoundException("Media not found");
            }

            String type = rs.getString("type");

            if ("SONG".equals(type)) {
                return new Song(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("duration")
                );
            }

            return new Podcast(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("duration")
            );

        } catch (SQLException e) {
            throw new DatabaseOperationException("Read by id failed");
        }
    }

    public void update(int id, Media media) {
        String sql = "UPDATE media SET name = ?, duration = ? WHERE id = ?";

        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, media.getName());
            ps.setInt(2, media.getDuration());
            ps.setInt(3, id);

            if (ps.executeUpdate() == 0) {
                throw new ResourceNotFoundException("Media not found");
            }

        } catch (SQLException e) {
            throw new DatabaseOperationException("Update failed");
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM media WHERE id = ?";

        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, id);

            if (ps.executeUpdate() == 0) {
                throw new ResourceNotFoundException("Media not found");
            }

        } catch (SQLException e) {
            throw new DatabaseOperationException("Delete failed");
        }
    }
}