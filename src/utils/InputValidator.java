package utils;

import model.Media;
import exception.InvalidInputException;

public class InputValidator {
    public static void validateMedia(Media media) {
        if (media.getName() == null || media.getName().isEmpty()) {
            throw new InvalidInputException("Media name cannot be empty");
        }

        if (media.getDuration() <= 0) {
            throw new InvalidInputException("Duration must be greater than 0");
        }
    }
}
