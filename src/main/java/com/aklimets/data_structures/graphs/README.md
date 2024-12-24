<h1>Graph Terminology and Algorithms</h1>

<h2>Terminology</h2>
<ul>
    <li><strong>Graph:</strong> A data structure consisting of nodes (vertices) and edges that connect pairs of nodes.</li>
    <li><strong>Vertex:</strong> A single node in a graph.</li>
    <li><strong>Edge:</strong> A connection between two vertices. Can be directed or undirected.</li>
    <li><strong>Directed Graph:</strong> Edges have a direction, going from one vertex to another.</li>
    <li><strong>Undirected Graph:</strong> Edges do not have direction; they connect two vertices symmetrically.</li>
    <li><strong>Weighted Graph:</strong> Edges have weights representing costs, distances, or capacities.</li>
    <li><strong>Path:</strong> A sequence of edges connecting a sequence of vertices.
        <ul>
            <li><strong>Simple Path:</strong> No vertex is visited more than once.</li>
            <li><strong>Cycle:</strong> A path where the starting and ending vertex are the same.</li>
        </ul>
    </li>
    <li><strong>Connected Graph:</strong> All vertices are reachable from any other vertex.</li>
    <li><strong>Strongly Connected Graph:</strong> In a directed graph, every vertex is reachable from every other vertex.</li>
    <li><strong>Bipartite Graph:</strong> A graph whose vertices can be divided into two disjoint sets such that every edge connects vertices from different sets.</li>
</ul>

<h2>Graph Representations</h2>
<ul>
    <li><strong>Adjacency List:</strong> A map where each vertex is a key, and its value is a list of adjacent vertices. Efficient for sparse graphs.</li>
    <li><strong>Adjacency Matrix:</strong> A 2D array where <code>matrix[i][j]</code> indicates the presence or weight of an edge between vertices <code>i</code> and <code>j</code>. Efficient for dense graphs.</li>
    <li><strong>Edge List:</strong> A list of all edges, each represented as a pair (or triplet for weighted graphs).</li>
</ul>

<h2>Key Algorithms</h2>

<h3>Traversal Algorithms</h3>
<ul>
    <li><strong>Breadth-First Search (BFS):</strong> Explores all neighbors of a vertex before moving to their neighbors. Uses a queue.
        <ul>
            <li><strong>Use Cases:</strong> Shortest path in unweighted graphs, finding connected components.</li>
        </ul>
    </li>
    <li><strong>Depth-First Search (DFS):</strong> Explores as far as possible along a branch before backtracking. Uses a stack or recursion.
        <ul>
            <li><strong>Use Cases:</strong> Cycle detection, pathfinding, topological sorting.</li>
        </ul>
    </li>
</ul>

<h3>Shortest Path Algorithms</h3>
<ul>
    <li><strong>Dijkstra's Algorithm:</strong> Finds the shortest path from a source to all other vertices in a weighted graph.
        <ul>
            <li><strong>Limitation:</strong> Does not work with negative weights.</li>
        </ul>
    </li>
    <li><strong>Bellman-Ford Algorithm:</strong> Finds the shortest path in graphs with negative weights.
        <ul>
            <li><strong>Limitation:</strong> Slower than Dijkstra's for graphs without negative weights.</li>
        </ul>
    </li>
</ul>

<h3>Cycle Detection</h3>
<ul>
    <li><strong>Undirected Graph:</strong> Use DFS or BFS with parent tracking to detect cycles.</li>
    <li><strong>Directed Graph:</strong> Use DFS with a recursion stack or check for back edges.</li>
</ul>

<h3>Minimum Spanning Tree (MST)</h3>
<ul>
    <li><strong>Kruskal's Algorithm:</strong> Builds the MST by adding edges in order of increasing weight, ensuring no cycles are formed.
    </li>
    <li><strong>Prim's Algorithm:</strong> Builds the MST by starting from an arbitrary vertex and growing the tree by adding the smallest edge connecting a vertex in the tree to a vertex outside it.
    </li>
</ul>

<h3>Topological Sorting</h3>
<ul>
    <li>Applicable only to Directed Acyclic Graphs (DAGs).</li>
    <li>Order vertices such that for every directed edge <code>u → v</code>, <code>u</code> appears before <code>v</code> in the ordering.</li>
</ul>

<h3>Strongly Connected Components (SCC)</h3>
<ul>
    <li>Used to find subsets of vertices in a directed graph where every vertex is reachable from every other vertex in the subset.</li>
    <li>Algorithms: Kosaraju's Algorithm, Tarjan's Algorithm.</li>
</ul>