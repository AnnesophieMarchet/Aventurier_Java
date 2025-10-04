package aventurier;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Logger;
public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args)throws IOException {
        Map map = new Map("assets/map.txt");
        LOGGER.info("Affichage de la carte :");
        map.displayMap();
        String [] movementFiles = {"assets/movements1.txt","assets/movements2.txt"};

        for (String movementFile : movementFiles) {
            LOGGER.info("Les coordonnées sont: " + movementFile);

            List<String> lines = Files.readAllLines(Paths.get(movementFile));
            String[] coords = lines.get(0).split(",");
            int startX = Integer.parseInt(coords[0].trim());
            int startY = Integer.parseInt(coords[1].trim());

            LOGGER.info("Position de départ du héro (" + startX + "," + startY + ")");
        }

    }


}