package utils;

import exception.InvalidInputException;

public class InputValidator {
    public static void checkName(String name) {
        if (name == null || name.isEmpty()) {
            throw new InvalidInputException("Name is empty");
        }
    }

    public static void checkDuration(int duration) {
        if (duration <= 0) {
            throw new InvalidInputException("Duration must be positive");
        }
    }
}