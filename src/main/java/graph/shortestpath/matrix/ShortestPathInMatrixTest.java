package graph.shortestpath.matrix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShortestPathInMatrixTest {


    @Test
    public void testSimpleMatrix(){

        /*

            [ 1,   1,   0,   0 ]
            [ 0,   1,   1,   0 ]


         */

        int[][] matrix=new int[][]{{1,1,0,0},{0,1,1,0}};

        ShortestPathInMatrix spim=new ShortestPathInMatrix();
        int distance=spim.findShortestDistanceTo(1, 2, matrix);

        System.out.println(distance);

        Assertions.assertEquals(distance, 3);
    }


    @Test
    public void testSimpleMatrixOnFirstCol(){

        /*

            [ 1,   1,   0,   0 ]
            [ 0,   1,   0,   0 ]
            [ 1,   1,   1,   0 ]
            [ 1,   0,   1,   0 ]
            [ 1,   1,   1,   0 ]

         */

        int[][] matrix=new int[][]{{1,1,0,0},{0,1,0,0},{1,1,1,0},{1,0,1,0},{1,1,1,0}};

        ShortestPathInMatrix spim=new ShortestPathInMatrix();
        int distance=spim.findShortestDistanceTo(4, 0, matrix);

        System.out.println(distance);

        Assertions.assertEquals(distance, 6);
    }

    @Test
    public void testSimpleMatrixOnFirstRow(){

        /*

            [ 1,   0,   0,   1 ]
            [ 1,   1,   1,   1 ]
            [ 0,   0,   0,   0 ]
            [ 0,   0,   0,   0 ]
            [ 0,   0,   0,   0 ]

         */

        int[][] matrix=new int[][]{{0,0,0,1},{1,1,1,1},{0,0,0,0},{0,0,0,0},{8,0,0,0}};

        ShortestPathInMatrix spim=new ShortestPathInMatrix();
        int distance=spim.findShortestDistanceTo(0, 3, matrix);

        System.out.println(distance);

        Assertions.assertEquals(distance, 5);

    }
}
