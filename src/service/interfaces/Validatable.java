package service.interfaces;

public interface Validatable<T> {
    void validate(T obj);

    default boolean isValid(T obj) {
        try {
            validate(obj);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    static void requireNonEmpty(String value, String fieldName) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(fieldName + " cannot be empty");
        }
    }
}