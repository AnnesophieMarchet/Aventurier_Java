package test;

import main.aventurier.Hero;
import main.aventurier.Map;
import org.junit.Test;

import java.io.IOException;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HeroTest {

    private static final String MAP_PATH = "assets/map.txt";
    @Test
    public void testHeroMoveSimple() throws IOException {
        Map map = new Map(MAP_PATH);
        Hero hero = new Hero(map, 3, 0);

        hero.move("SSS");
        assertEquals("X reste identique", 3, hero.getX());
        assertEquals("Y doit être 3", 3, hero.getY());
    }

    @Test
    public void testHeroMoveWithWalls() throws IOException {
        Map map = new Map(MAP_PATH);
        Hero hero = new Hero(map, 3, 0);

        hero.move("NNNNNNNNN");
        assertTrue("Y doit rester >= 0", hero.getY() >= 0);


        hero.move("OOOOOOOOOOOO");
        assertTrue("X doit rester >= 0", hero.getX() >= 0);
    }

    @Test
    public void testHeroMovement1() throws IOException {
        Map map = new Map(MAP_PATH);
        Hero hero = new Hero(map, 3, 0);

        hero.move("SSSSEEEEEENN");
        assertEquals("Position finale X", 9, hero.getX());
        assertEquals("Position finale Y", 2, hero.getY());
    }
}
