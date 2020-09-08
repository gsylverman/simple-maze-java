import java.util.LinkedList;

public class SomeApp {
    private static Maze maze = new Maze();;

    private static LinkedList<Position> trace = new LinkedList<>();
    public static void main(String[] args) {
        int[][] someMaze = {
                { 0, 1, 1 ,0, 0, 1, 1 ,0, 1, 1, 0, 1 },
                { 1, 1, 0 ,1, 0, 2, 0 ,1, 0, 0, 0 ,1 },
                { 0, 1, 0 ,1, 1, 1, 1 ,1, 1, 1, 1, 1 }
        };
        maze.setMaze(someMaze);
        maze.setTrace(new LinkedList<>());
        maze.setStart(new Position(0, 11));

        if (MazeSolver.solveMaze(maze)) {
            System.out.println("You won!");
        } else {
            System.out.println("No path!");
        }
    }

}
