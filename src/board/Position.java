package board;

public class Position {
    private int x;
    private int y;

    // Constructors for x, y, Position, and no parameters
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Position(Position p) {
        this.x = p.getX();
        this.y = p.getY();
    }
    public Position() {
        this.x = 0;
        this.y = 0;
    }

    // Getters for x, y, and Position
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    public Position getPosition() {
        return this;
    }

    // Setters for x, y, xy, and Position
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void setXY(Position p) {
        this.x = p.getX();
        this.y = p.getY();
    }

    public boolean equals(Position o) {
        return this.x == o.getX() && this.y == o.getY();
    }

    public boolean equals(int x, int y) {
        return this.x == x && this.y == y;
    }


}
