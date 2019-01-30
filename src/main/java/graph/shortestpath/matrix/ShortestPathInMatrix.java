package graph.shortestpath.matrix;

import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestPathInMatrix {

    class Point{
        int row,col, distance;
        Point(int x, int y, int d){
            this.row=x;
            this.col=y;
            this.distance=d;
        }
    }

    boolean hasRight(Point curr, int[][] matrix){
        return curr.col + 1 < matrix[0].length;
    }

    Point right(Point curr, int distance){
        return new Point(curr.row, curr.col+1, distance);
    }

    boolean hasLeft(Point curr){
        return curr.col - 1 >= 0;
    }

    Point left(Point curr, int distance){
        return new Point(curr.row, curr.col-1, distance);
    }

    boolean hasDown(Point curr, int[][] matrix){
        return curr.row + 1 < matrix.length;
    }

    Point down(Point curr, int distance){
        return new Point(curr.row+1, curr.col, distance);
    }


    boolean hasUp(Point curr){
        return curr.row - 1 >= 0;
    }

    Point up(Point curr, int distance){
        return new Point(curr.row - 1, curr.col, distance);
    }

    boolean isDestination(Point src, Point dest){
        return src.row == dest.row && src.col == dest.col;
    }

    boolean isVisited(boolean[][] visited, Point p){
        return visited[p.row][p.col];
    }

    boolean isValid(Point p, boolean[][] visited, int[][] matrix){
        return matrix[p.row][p.col]==1 && !isVisited(visited, p);
    }

    public int findShortestDistanceTo(int dRow, int dCol, int[][] matrix) {

        //if [0][0] is the destination
        if(dRow==0 && dCol==0){
            return 0;
        }

        Point dest=new Point(dRow, dCol, 0);
        //add root in queue
        int row=0;
        int col=0;

        int distance=0;

        Deque<Point> q=new ArrayDeque<>();

        q.offer(new Point(row, col, distance));

        boolean[][] visited=new boolean[matrix.length][matrix[0].length];

        while(!q.isEmpty()){
            Point currPoint=q.poll();
            visited[currPoint.row][currPoint.col]=true;
            if(isDestination(currPoint, dest)){
                return currPoint.distance;
            }

            if(hasRight(currPoint, matrix) ){
                Point right=right(currPoint, currPoint.distance + 1);
                if(isValid(right, visited, matrix)){
                    q.offer(right);
                }
            }

            if(hasDown(currPoint, matrix)){
                Point down=down(currPoint, currPoint.distance + 1);
                if(isValid(down, visited, matrix)){
                    q.offer(down);
                }
            }

            if(hasLeft(currPoint)){
                Point left=left(currPoint, currPoint.distance + 1);
                if(isValid(left, visited, matrix)){
                    q.offer(left);
                }
            }


            if(hasUp(currPoint)){
                Point up=up(currPoint, currPoint.distance + 1);
                if(isValid(up, visited, matrix)){
                    q.offer(up);
                }
            }

        }

        return -1;
    }
}
