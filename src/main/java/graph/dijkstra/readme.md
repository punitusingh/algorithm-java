
- to find fastest path from node A to node B, means edges will have some weights to measure.
- bfs finds shortest path, dijkstra finds fastest.
- for weighted graph use dijkstra, for unweighted graph use bfs.
- dijkstra only works with DAG means directed acyclic graph.
- dijkstra does not work on negative weight edges. for this use Bellman-ford algorithm.

           
**implementation**    
- we need 3 hashtables and 1 set
    1. graph - {start_node, {neighbor_node, cost }}, Map<StartNode, Map<NeighborNode, Cost>>
    2. costs - {node, cost}, Map<Node, Cost>
    3. parents - {node, parent_node}, Map<Node, ParentNode>
    4. visited - {nodes already visited}
    
    
- first build graph, costs and parents 
- update costs and parents hashtable once algorithm progresses

four steps in this algorithm:
    - find the cheapest node (which is not visited)
    - updated the cost of it's neighbors
    - repeat this for all the nodes
    - calculate the final path

 