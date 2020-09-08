import java.util.LinkedList;

public class Maze {
    private int[][] maze;
    private LinkedList<Position> trace;
    private Position start;

    public int[][] getMaze() {
        return maze;
    }

    public void setMaze(int[][] maze) {
        this.maze = maze;
    }

    public LinkedList<Position> getTrace() {
        return trace;
    }

    public void setTrace(LinkedList<Position> trace) {
        this.trace = trace;
    }

    public Position getStart() {
        return start;
    }

    public void setStart(Position start) {
        this.start = start;
    }
}
