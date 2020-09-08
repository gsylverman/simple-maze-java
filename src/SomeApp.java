import java.util.ArrayList;
import java.util.LinkedList;

public class SomeApp {
    private static ArrayList<Maze> mazes = new ArrayList<>();

    public static void main(String[] args) {
        Maze maze1 = new Maze();
        int[][] someMaze1 = {
                { 0, 1, 1 ,0, 0, 1, 1 ,0, 1, 1, 0, 1 },
                { 1, 1, 0 ,1, 0, 2, 0 ,1, 0, 0, 0 ,1 },
                { 0, 1, 0 ,1, 1, 1, 1 ,1, 1, 1, 1, 1 }
        };
        maze1.setMaze(someMaze1);
        maze1.setStart(new Position(0, 11));

        Maze maze2 = new Maze();
        int[][] someMaze2 = {
                { 0, 1, 1 ,1, 0, 1, 0 ,0, 1, 1, 0, 1 },
                { 1, 2, 0 ,1, 0, 1, 1 ,1, 0, 0, 0 ,1 },
                { 0, 1, 0 ,1, 1, 1, 0 ,1, 1, 1, 1, 1 }
        };
        maze2.setMaze(someMaze2);
        maze2.setStart(new Position(0, 11));

        mazes.add(maze1);
        mazes.add(maze2);
        mazeSolver(mazes);
    }
    public static void mazeSolver (ArrayList<Maze> mazes) {
        for (Maze maze : mazes) {
            if (MazeSolver.solveMaze(maze)) {
                System.out.println("You won!");
            } else {
                System.out.println("No path!");
            }
            System.out.println("*********************************");
        }
    }

}
