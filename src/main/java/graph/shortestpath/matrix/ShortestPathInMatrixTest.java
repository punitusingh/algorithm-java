package graph.shortestpath.matrix;

import org.junit.jupiter.api.Test;

public class ShortestPathInMatrixTest {


    @Test
    public void testSimpleMatrix(){

        /*

            [ 0,   1,   0,   0 ]
            [ 0,   1,   8,   0 ]


         */

        int[][] matrix=new int[][]{{0,1,0,0},{0,1,8,0}};

        ShortestPathInMatrix spim=new ShortestPathInMatrix();
        int distance=spim.findShortestDistanceTo(8, matrix);

        System.out.println(distance);


    }


    @Test
    public void testSimpleMatrixOnFirstCol(){

        /*

            [ 0,   1,   0,   0 ]
            [ 0,   1,   0,   0 ]
            [ 1,   1,   1,   0 ]
            [ 1,   0,   1,   0 ]
            [ 8,   1,   1,   0 ]

         */

        int[][] matrix=new int[][]{{0,1,0,0},{0,1,0,0},{1,1,1,0},{1,0,1,0},{8,1,1,0}};

        ShortestPathInMatrix spim=new ShortestPathInMatrix();
        int distance=spim.findShortestDistanceTo(8, matrix);

        System.out.println(distance);

    }

    @Test
    public void testSimpleMatrixOnFirstRow(){

        /*

            [ 0,   0,   0,   8 ]
            [ 1,   1,   1,   1 ]
            [ 0,   0,   0,   0 ]
            [ 0,   0,   0,   0 ]
            [ 0,   0,   0,   0 ]

         */

        int[][] matrix=new int[][]{{0,0,0,8},{1,1,1,1},{0,0,0,0},{0,0,0,0},{8,0,0,0}};

        ShortestPathInMatrix spim=new ShortestPathInMatrix();
        int distance=spim.findShortestDistanceTo(8, matrix);

        System.out.println(distance);

    }
}
