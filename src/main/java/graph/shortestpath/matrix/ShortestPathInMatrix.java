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

    Point right(Point curr, int[][] matrix, int distance){
        return new Point(curr.row, curr.col+1, distance);
    }

    boolean hasLeft(Point curr, int[][] matrix){
        return curr.col - 1 >= 0;
    }

    Point left(Point curr, int[][] matrix, int distance){
        return new Point(curr.row, curr.col-1, distance);
    }

    boolean hasDown(Point curr, int[][] matrix){
        return curr.row + 1 < matrix.length;
    }

    Point down(Point curr, int[][] matrix, int distance){
        return new Point(curr.row+1, curr.col, distance);
    }


    boolean hasUp(Point curr, int[][] matrix){
        return curr.row - 1 >= 0;
    }

    Point up(Point curr, int[][] matrix, int distance){
        return new Point(curr.row - 1, curr.col, distance);
    }


    public int findShortestDistanceTo(int itemToFind, int[][] matrix) {

        //add root in queue
        int row=0;
        int col=0;

        int distance=0;

        //if [0][0] is the destination
        if(matrix[row][col] == itemToFind){
            return distance;
        }

        Deque<Point> q=new ArrayDeque<>();

        q.offer(new Point(row, col, distance));

        while(!q.isEmpty()){
            Point currPoint=q.poll();
            if(matrix[currPoint.row][currPoint.col] == itemToFind){
                return currPoint.distance;
            }

            if(hasRight(currPoint, matrix)){
                Point right=right(currPoint, matrix, currPoint.distance + 1);
                if(matrix[right.row][right.col] == itemToFind){
                    return right.distance;
                }
                if(matrix[right.row][right.col] == 1){
                    q.offer(right);
                }
            }

            if(hasDown(currPoint, matrix)){
                Point down=down(currPoint, matrix, currPoint.distance + 1);
                if(matrix[down.row][down.col] == itemToFind){
                    return down.distance;
                }
                if(matrix[down.row][down.col] == 1){
                    q.offer(down);
                }
            }

            if(hasLeft(currPoint, matrix)){
                Point left=left(currPoint, matrix, currPoint.distance + 1);
                if(matrix[left.row][left.col] == itemToFind){
                    return left.distance;
                }
                if(matrix[left.row][left.col] == 1){
                    q.offer(left);
                }
            }


            if(hasUp(currPoint, matrix)){
                Point up=up(currPoint, matrix, currPoint.distance + 1);
                if(matrix[up.row][up.col] == itemToFind){
                    return up.distance;
                }
                if(matrix[up.row][up.col] == 1){
                    q.offer(up);
                }
            }

        }

        return -1;
    }
}
