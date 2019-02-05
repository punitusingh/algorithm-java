package graph.numberofislands;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NumberOfIslandsTest {

    @Test
    void testMatrixExpectTwoIsland(){
        char[][] grid=new char[][]{
                {   '1',  '1',  '1',  '1'   },
                {   '0',  '0',  '0',  '0'   },
                {   '1',  '1',  '0',  '0'   }
        };

        NumberOfIslands n=new NumberOfIslands();
        Assertions.assertEquals(n.numIslands(grid),2);
    }


    @Test
    void testMatrixExpectOneIsland(){
        char[][] grid=new char[][]{
                {  '1' }
        };

        NumberOfIslands n=new NumberOfIslands();
        Assertions.assertEquals(n.numIslands(grid),1);
    }

    @Test
    void testMatrixExpectZeroIsland(){
        char[][] grid=new char[][]{
                {   }
        };

        NumberOfIslands n=new NumberOfIslands();
        Assertions.assertEquals(n.numIslands(grid),0);
    }


}
