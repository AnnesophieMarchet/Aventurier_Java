package main.aventurier;

import java.io.IOException;
import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws IOException {
        Map map = new Map("assets/map.txt");
        String[] movementFiles = {"assets/movements1.txt", "assets/movements2.txt"};

        for (String movementFile : movementFiles) {
            try {
                Hero hero = HeroFactory.createFromFile(map, movementFile);
                String directions = HeroFactory.getDirectionsFromFile(movementFile);

                LOGGER.info("Position de départ du héros (" + hero.getX() + "," + hero.getY() + ") Déplacements : " + directions);
                hero.move(directions);
                LOGGER.info("Position finale : (" + hero.getX() + "," + hero.getY() + ")");
                map.displayMap(hero);

            } catch (IllegalArgumentException e) {
                LOGGER.warning("Impossible de créer le héros pour " + movementFile + " : " + e.getMessage());
            } catch (IOException e) {
                LOGGER.severe("Erreur lecture fichier " + movementFile + " : " + e.getMessage());
            }
        }
    }
}