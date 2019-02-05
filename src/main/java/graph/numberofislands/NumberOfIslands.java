package graph.numberofislands;

class NumberOfIslands {

    int numIslands(char[][] grid) {
        if(grid==null || grid.length==0){
            return 0;
        }
        int rows=grid.length;
        int cols=grid[0].length;
        int island=0;
        for(int row=0; row < rows;row++) {
            for (int col = 0; col < cols; col++) {
                if(grid[row][col]=='1' ) {
                    island++;
                    wipeOutConnectionUsingDFS(row,col, grid);
                }
            }
        }
        return island;
    }


    /*
                    TOP     RIGHT    BOTTOM     LEFT
        ROW          -1       0         1         0
        COL          0        1         0         -1
     */



    void wipeOutConnectionUsingDFS(int row, int col, char[][] grid){
            if(row >= 0 && col >= 0 && row < grid.length && col < grid[0].length && grid[row][col]=='1'){
                grid[row][col]='0';
                //top
                wipeOutConnectionUsingDFS(row-1, col, grid);
                //right
                wipeOutConnectionUsingDFS(row, col+1, grid);
                //bottom
                wipeOutConnectionUsingDFS(row+1, col, grid);
                //left
                wipeOutConnectionUsingDFS(row, col-1, grid);
            }
    }
}
