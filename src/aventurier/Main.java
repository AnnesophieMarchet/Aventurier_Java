package aventurier;

import java.io.IOException;
import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args)throws IOException {
        try {
        Map map = new Map("assets/map.txt");
        String [] movementFiles = {"assets/movements1.txt","assets/movements2.txt"};

        for (String movementFile : movementFiles) {

            Hero hero = HeroFactory.createFromFile(map, movementFile);
            String directions = HeroFactory.getDirectionsFromFile(movementFile);
            hero.move(directions);
            LOGGER.info("Position de départ du héro (" + hero.getX() + "," + hero.getY() + ")" +" "+ " Déplacements : " + directions);
            LOGGER.info("Position finale : (" + hero.getX() + "," + hero.getY() + ")");
            map.displayMap(hero);
        }
        } catch (IOException e) {
            System.out.println("Erreur de lecture de la map " + e.getMessage());
        }
    }

}