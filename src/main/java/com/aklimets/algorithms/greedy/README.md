<h1>Greedy Algorithms</h1>

<h2>Overview</h2>
<p>Greedy algorithms are a class of algorithms that make the locally optimal choice at each step with the hope of finding the global optimum.</p>

<h2>When to Use Greedy Algorithms</h2>
<ul>
    <li><strong>Optimal Substructure</strong>: The problem can be broken into subproblems, and the optimal solution of the problem can be built from optimal solutions to the subproblems.</li>
    <li><strong>Greedy Choice Property</strong>: A locally optimal choice leads to a globally optimal solution.</li>
    <li><strong>Approximation</strong>: Greedy algorithms often provide good approximations, especially when an exact optimal solution is computationally expensive or unnecessary (e.g., for NP-hard problems).</li>
</ul>

<h2>Examples of Greedy Algorithms</h2>
<ul>
    <li><strong>Dijkstra's Algorithm</strong>: Finds the shortest path in a graph with non-negative weights.</li>
    <li><strong>Huffman Coding</strong>: Builds an optimal prefix code for data compression.</li>
    <li><strong>Activity Selection Problem</strong>: Selects the maximum number of activities that don't overlap.</li>
</ul>

<h2>When Greedy Algorithms Might Fail</h2>
<p>Greedy algorithms do not guarantee optimal solutions for all problems. They work well when the problem has the greedy choice property and optimal substructure. For other problems, consider approaches like dynamic programming or backtracking.</p>
