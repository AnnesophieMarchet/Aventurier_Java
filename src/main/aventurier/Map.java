package main.aventurier;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Map {

    private static final Logger LOGGER = Logger.getLogger(Map.class.getName());
    private final char[][] gameField;

    public Map(String mapName) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(mapName));
        gameField = new char[lines.size()][];
        for (int i = 0; i < lines.size(); i++) {
            gameField[i] = lines.get(i).toCharArray();
        }
        LOGGER.log(Level.INFO, "Carte lue : {0}", new Object[]{mapName});
    }
    public boolean isValidPosition(int x, int y) {
        return x >= 0 && x < gameField[0].length && y >= 0 && y < gameField.length && gameField[y][x] != '#';
    }

    private String getMapAsString(Hero hero) {
        StringBuilder sb = new StringBuilder();
        sb.append("=======CARTE=======\n");
        for (int y = 0; y < gameField.length; y++) {
            for (int x = 0; x < gameField[y].length; x++) {
                if (hero != null && hero.getX() == x && hero.getY() == y) {
                    sb.append('H');
                } else {
                    sb.append(gameField[y][x]);
                }
            }
            sb.append('\n');
        }
        sb.append("===================\n");
        return sb.toString();
    }


    public void displayMap(Hero hero) {
        LOGGER.info(() -> getMapAsString(hero));
    }
}
