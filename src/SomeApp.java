import java.util.LinkedList;

public class SomeApp {
    private static int[][] maze = {
            { 0, 1, 1 ,0 },
            { 0, 1, 1 ,0 },
            { 0, 1, 1 ,2 }
    };
    private static LinkedList<Position> trace = new LinkedList<>();
    public static void main(String[] args) {
        Position start = new Position(0, 2);
        trace.push(start);

        while(true) {
            int y = trace.peek().getY();
            int x = trace.peek().getX();
            maze[y][x] = 0;

            //down
            if(isValid(y+1, x, maze)) {
                if(maze[y+1][x] == 2) {
                    System.out.println("You win!");
                    return;
                } else if(maze[y+1][x] == 1) {
                    System.out.println("Moved down");
                    trace.push(new Position(y+1, x));
                    continue;
                }
            }

            //left
            if(isValid(y, x-1, maze)) {
                if(maze[y][x-1] == 2) {
                    System.out.println("You win!");
                    return;
                } else if(maze[y][x-1] == 1) {
                    System.out.println("Moved left");
                    trace.push(new Position(y, x-1));
                    continue;
                }
            }

            //up
            if(isValid(y-1, x, maze)) {
                if(maze[y-1][x] == 2) {
                    System.out.println("You win!");
                    return;
                } else if(maze[y-1][x] == 1) {
                    System.out.println("Moved up");
                    trace.push(new Position(y-1, x));
                    continue;
                }
            }

            //right
            if(isValid(y, x+1, maze)) {
                if(maze[y][x+1] == 2) {
                    System.out.println("You win!");
                    return;
                } else if(maze[y][x+1] == 1) {
                    System.out.println("Moved right");
                    trace.push(new Position(y, x+1));
                    continue;
                }
            }
            trace.pop();
            System.out.println("Moved back");
            if(trace.size() <= 0) {
                return;
            }
        }
    }

    public static boolean isValid(int y, int x, int[][] maze) {
        if(y < 0 ||
                y >= maze.length ||
                x < 0 ||
                x >= maze[y].length
        ) {
            return false;
        }
        return true;
    }
}
