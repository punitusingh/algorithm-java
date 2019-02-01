## problem
- in a mxn matrix of 0 and 1, find shortest path from (0,0) to given (row,col). 
if {row, col} value is 1, then only you can take that step.

## solution approach
- bfs
- maintain a queue, add current point with distance {0,0, distance=0} in queue
- until queue not empty
    - poll from queue, if current point is destination return it's distance
    - else evaluate all neighbors for current point for value = 1, 
        and add them in queue with distance {row, col, distance=current point's distance + 1}
- if destination not found return -1

# time complexity
- worst time complexity will be O(mn), as there are m*n nodes in mxn matrix, 
    and we have to visit all the nodes if all the elements are 1.
    
like in [1 1 1] 
        [1 1 1]   
        [1 1 1] 
        
 it's 3x3 matrix, total 9 elements with value 1, and to find shortest path from (0,0)  to (2,2),
    we have to visit all the nodes.  