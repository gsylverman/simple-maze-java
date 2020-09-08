import java.util.LinkedList;

public class SomeApp {
    private static Maze maze = new Maze();;

    private static LinkedList<Position> trace = new LinkedList<>();
    public static void main(String[] args) {
        int[][] someMaze = {
                { 0, 1, 1 ,0, 0, 1, 1 ,0, 1, 1, 1, 1 },
                { 1, 1, 1 ,2, 0, 1, 1 ,0, 0, 1, 1 ,0 },
                { 0, 1, 1 ,1, 1, 1, 1 ,1, 1, 1, 1, 1 }
        };

        maze.setMaze(someMaze);
        maze.setTrace(new LinkedList<>());
        maze.setStart(new Position(0, 11));


        if (solveMaze(maze.getStart())) {
            System.out.println("You won!");
        } else {
            System.out.println("No path!");
        }
    }
    private static boolean solveMaze(Position start) {
        maze.getTrace().push(start);
        while (true) {
            int y = maze.getTrace().peek().getY();
            int x = maze.getTrace().peek().getX();
            maze.getMaze()[y][x] = 0;

            //down
            if (isValid(y+1, x, maze.getMaze())) {
                if(maze.getMaze()[y+1][x] == 2) {
                    return true;
                } else if (maze.getMaze()[y+1][x] == 1) {
                    System.out.println("Moved down");
                    maze.getTrace().push(new Position(y+1, x));
                    continue;
                }
            }

            //left
            if (isValid(y, x-1, maze.getMaze())) {
                if(maze.getMaze()[y][x-1] == 2) {
                    return true;
                } else if(maze.getMaze()[y][x-1] == 1) {
                    System.out.println("Moved left");
                    maze.getTrace().push(new Position(y, x-1));
                    continue;
                }
            }

            //up
            if (isValid(y-1, x, maze.getMaze())) {
                if(maze.getMaze()[y-1][x] == 2) {
                    return true;
                } else if(maze.getMaze()[y-1][x] == 1) {
                    System.out.println("Moved up");
                    maze.getTrace().push(new Position(y-1, x));
                    continue;
                }
            }

            //right
            if (isValid(y, x+1, maze.getMaze())) {
                if(maze.getMaze()[y][x+1] == 2) {
                    return true;
                } else if(maze.getMaze()[y][x+1] == 1) {
                    System.out.println("Moved right");
                    maze.getTrace().push(new Position(y, x+1));
                    continue;
                }
            }
            maze.getTrace().pop();
            System.out.println("Moved back");
            if (maze.getTrace().size() <= 0) {
                return false;
            }
        }
    }

    public static boolean isValid(int y, int x, int[][] maze) {
        if (
                y < 0 ||
                y >= maze.length ||
                x < 0 ||
                x >= maze[y].length
        ) {
            return false;
        }
        return true;
    }
}
