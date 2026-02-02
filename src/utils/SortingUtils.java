package utils;

import model.Media;
import java.util.List;

public class SortingUtils {
    public static List<Media> sortByName(List<Media> list) {
        return list.stream()
                .sorted((a, b) -> a.getName().compareTo(b.getName()))
                .toList();
    }
}