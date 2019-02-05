package graph.shortestpath.matrix;

import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestPathInMatrix {

    static int DIRECTIONS=4;
    /*
                    ROW     COL
        TOP:        -1      0
        RIGHT:      0       +1
        BOTTOM:     +1      0
        LEFT:       0       -1

     */

    static int[] ROW_MOV=new int[]{-1,0,+1,0};
    static int[] COL_MOV=new int[]{0,+1,0,-1};

    class Point{
        int row,col, distance;
        Point(int x, int y, int d){
            this.row=x;
            this.col=y;
            this.distance=d;
        }
    }

    boolean isDestination(Point src, Point dest){
        return src.row == dest.row && src.col == dest.col;
    }


    boolean isValid(int row, int col, boolean[][] visited, int[][] matrix){
        return isInBoundary(row, col, matrix) && !visited[row][col] && matrix[row][col]==1;
    }

    boolean isInBoundary(int row, int col, int[][] matrix){
        return row>=0 && row<matrix.length && col>=0 && col<matrix[0].length;
    }

    public int findShortestDistanceTo(int dRow, int dCol, int[][] matrix) {
        //if [0][0] is the destination
        if(dRow==0 && dCol==0){
            return 0;
        }
        //add root in queue
        int row=0;
        int col=0;

        int distance=0;

        int island=0;

        Deque<Point> q=new ArrayDeque<>();

        q.offer(new Point(row, col, distance));

        boolean[][] visited=new boolean[matrix.length][matrix[0].length];
        Point dest=new Point(dRow, dCol, 0);
        while(!q.isEmpty()){
            Point currPoint=q.poll();
            visited[currPoint.row][currPoint.col]=true;
            if(isDestination(currPoint, dest)){
                return currPoint.distance;
            }

            for(int i=0;i<DIRECTIONS;i++){
                int newRow=currPoint.row + ROW_MOV[i];
                int newCol=currPoint.col + COL_MOV[i];

                //if valid boundary row,col, and value is 1 then only
                if(isValid(newRow, newCol, visited, matrix)){
                    q.offer(new Point(newRow, newCol, currPoint.distance + 1));
                }
            }
        }

        return -1;
    }
}
