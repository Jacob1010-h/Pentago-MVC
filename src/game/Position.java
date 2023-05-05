package game;
import java.awt.Point;
/**
 * Represents a coordinate pair on the game board
 */
public class Position extends Point {

    public Position(int row, int col) {
        super (row, col);
    }

    public int getRow() {
        return this.x;
    }

    public int getCol() {
        return this.y;
    }

    public Position translate(Position vector) {
        return new Position(this.x+vector.x, this.y+vector.y);
    }



    @Override
    public String toString() {
        return "["+this.getRow()+","+this.getCol()+"]";
    }

}
