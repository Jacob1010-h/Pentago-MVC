package game;

public class Position {
    private int row;
    private int col;

    // Constructors for x, y, Position, and no parameters
    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }
    public Position(Position p) {
        this.row = p.getRow();
        this.col = p.getCol();
    }
    public Position() {
        this.row = 0;
        this.col = 0;
    }

    // Getters for x, y, and Position
    public int getRow() {
        return this.row;
    }
    public int getCol() {
        return this.col;
    }
    public Position getPosition() {
        return this;
    }

    // Setters for x, y, xy, and Position
    public void setRow(int row) {
        this.row = row;
    }
    public void setCol(int col) {
        this.col = col;
    }
    public void setRowCol(int row, int col) {
        this.row = row;
        this.col = col;
    }
    public void setRowCol(Position p) {
        this.row = p.getRow();
        this.col = p.getCol();
    }

    public boolean equals(Position o) {
        return this.row == o.getRow() && this.col == o.getCol();
    }

    public boolean equals(int x, int y) {
        return this.row == x && this.col == y;
    }


}
