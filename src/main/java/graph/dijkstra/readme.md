
- to find fastest path from node A to node B, means edges will have some weights to measure.
- bfs finds shortest path, dijkstra finds fastest.
- for weighted graph use dijkstra, for unweighted graph use bfs.
- dijkstra only works with DAG means directed acyclic graph.
- dijkstra does not work on negative weight edges. for this use Bellman-ford algorithm.


four steps in this algorithm:
    - find the cheapest node
    - updated the cost of it's neighbors
    - repeat this for all the nodes
    - calculate the final path
    
    
    
**implementation**    
- we need 3 hashtables
    1. graph - {start_node, {neighbor_node, cost }}, Map<StartNode, Map<NeighborNode, Cost>>
    2. costs - {node, cost}, Map<Node, Cost>
    3. parents - {node, parent_node}, Map<Node, ParentNode>
    
    
- first build entire graph 
- update costs and parents hashtable once algorithm progresses

 