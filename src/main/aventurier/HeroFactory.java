package main.aventurier;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class HeroFactory {
    private HeroFactory() {}

    public static Hero createFromFile(Map map, String filename) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filename));

        String[] coords = lines.get(0).split(",");
        int startX = Integer.parseInt(coords[0].trim());
        int startY = Integer.parseInt(coords[1].trim());

        return new Hero(map, startX, startY);
    }

    public static String getDirectionsFromFile(String filename) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filename));
        return lines.get(1).trim();
    }
}
