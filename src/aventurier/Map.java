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

    public void displayMap(Hero hero) {
        System.out.println("=======CARTE=======\n");
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                if (hero != null && hero.getX() == x && hero.getY() == y) {
                    System.out.print('H');
                } else {
                    System.out.print(map[y][x]);
                }
            }
            System.out.println();
        }
        System.out.println("===================\n");
    }
}
