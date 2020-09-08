public class MazeSolver {

    public static boolean solveMaze(Maze maze) {
        maze.getTrace().push(maze.getStart());
        while (true) {
            int y = maze.getTrace().peek().getY();
            int x = maze.getTrace().peek().getX();
            maze.getMaze()[y][x] = 0;
            //down
            if (isValid(y+1, x, maze.getMaze())) {
                if(maze.getMaze()[y+1][x] == 2) {
                    System.out.println("Moved down");
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
                    System.out.println("Moved left");
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
                    System.out.println("Moved up");
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
                    System.out.println("Moved right");
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
    private static boolean isValid(int y, int x, int[][] maze) {
        if (y < 0 ||
                y >= maze.length ||
                x < 0 ||
                x >= maze[y].length
        ) {
            return false;
        }
        return true;
    }
}
