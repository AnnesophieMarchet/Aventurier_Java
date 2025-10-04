package aventurier;

public class Hero {
    private int x;
    private int y;
    private Map map;

    public Hero(Map map, int startX, int startY) {
        this.map = map;
        this.x = startX;
        this.y = startY;
    }

    public void move(String directions) {
        for (char dir : directions.toCharArray()) {
            int newX = x;
            int newY = y;

            switch (dir) {
                case 'N': newY--; break;
                case 'S': newY++; break;
                case 'E': newX++; break;
                case 'O': newX--; break;
            }

            if (map.isValidPosition(newX, newY)) {
                x = newX;
                y = newY;
            }
        }
    }

    public int getX() { return x; }
    public int getY() { return y; }
}