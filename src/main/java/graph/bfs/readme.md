


- to find shortest distance between _two things_
- to find shortest _something_

**example**
1. fewest moves to victory for checkers AI
2. fewest edits from misspelling to correct word like READED -> READER
3. closest doctor in the network
4. prefers a first-degree connection to a second-degree connection, 
    and a second-degree connection to a third-degree and so on.
5. the search radiates out from the starting point.
6. means first-degree connections are added to the search list before second-degree connections.    



**question type 1**: is there a path from node A to node B?
**question type 2**: what is shortest path from node A to node B?


**Implementing the graph**
- a hash table {node : [neighbors]}, map a node to all it's neighbors
                HashMap<Node, List<Node>> 
                
```python
    graph={} #dictionary
    graph["you"] = ["alice", "bob", "claire"]
    visited={}
```              

```java
    Map<String, List<String>> graph=new HashMap<String, List<String>>();
    graph.put("you", Arrays.asList(new String["alice", "bob", "claire"]));
    Set<String> visited=new HashSet<String>();
```


**Algorithm**:

- keep a queue of the element to check
- loop over queue until it's not empty
    - pop an element of the queue
    - check if that element is the answer
        - yes, then we are done
        - no, add all their neighbors in the queue
        
        
**Running Time**:   
- V is number for vertices/nodes
- E is number of edges/connections between them
- we have to visit all the connections/edges so at least O(E)
- we have to put each element in queue so at least O(V)
- then finally it will be O(V+E)    