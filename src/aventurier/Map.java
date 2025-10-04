package aventurier;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Logger;



public class Map {
    private char[][] map;
    private static final Logger LOGGER = Logger.getLogger(Map.class.getName());

    public Map(String mapName) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(mapName));
        map = new char[lines.size()][];
        for (int i = 0; i < lines.size(); i++) {
            map[i] = lines.get(i).toCharArray();
        }
        LOGGER.info("Carte lue : " + mapName);
    }
    public boolean isValidPosition(int x, int y) {
        return x >= 0 && x < map[0].length && y >= 0 && y < map.length && map[y][x] != '#';
    }

    public void displayMap() {
        for (char[] row : map) {
            System.out.println(new String(row));
        }
    }

}
