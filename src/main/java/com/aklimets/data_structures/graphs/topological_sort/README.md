<h2>1. Topological Sort</h2>
<p>Topological Sort is used for directed acyclic graphs (DAGs). It orders the nodes such that for every directed edge <code>u &rarr; v</code>, node <code>u</code> appears before <code>v</code>.</p>
<p>Key properties:
<ul>
<li>Only valid for DAGs (graphs with no cycles).</li>
<li>If a cycle exists, the topological sort is impossible.</li>
<li>If the sort produces fewer nodes than in the graph, it indicates a cycle.</li>
</ul>


<h2>2. Kahn's Algorithm</h2>
<p>Kahn's Algorithm is a method to perform topological sorting. It works by:
    <ol>
        <li>Calculating in-degrees for each node.</li>
        <li>Adding nodes with in-degree 0 to the queue.</li>
        <li>Removing nodes from the queue, updating in-degrees of neighbors.</li>
        <li>If all nodes are processed, the graph is a DAG; otherwise, it contains a cycle.</li>
    </ol>

<h2>3. Cycle Detection</h2>
<p>If a graph contains a cycle, no topological sort is possible. Cycle detection can be done via:
    <ul>
        <li>DFS-based cycle detection.</li>
        <li>Kahn's algorithm can also detect cycles when nodes cannot be fully processed.</li>
    </ul>


<h2>4. Graph Representations</h2>
<p>Graphs can be represented in the following ways:
    <ul>
        <li><strong>Adjacency List</strong>: A list of nodes with their corresponding neighbors.</li>
        <li><strong>Adjacency Matrix</strong>: A 2D matrix where each element <code>matrix[i][j]</code> indicates an edge from node <code>i</code> to node <code>j</code>.</li>
        <li><strong>Adjacency Map</strong>: A map where the key is a node, and the value is a list of its neighbors.</li>
    </ul>
