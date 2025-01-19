<h3><strong>1. What is a Tree?</strong></h3>
<ul>
    <li>A <strong>tree</strong> is a hierarchical data structure made up of nodes.</li>
    <li>Each node contains a value and pointers to its child nodes.</li>
    <li>A <strong>binary tree</strong> is a tree where each node has at most two children.</li>
</ul>
<h3><strong>2. Key Characteristics of Trees</strong></h3>
<ul>
    <li><strong>Root</strong>: The top node of the tree (starting point).</li>
    <li><strong>Leaf</strong>: A node with no children.</li>
    <li><strong>Subtree</strong>: A tree consisting of a node and all its descendants.</li>
    <li><strong>Path</strong>: A sequence of nodes from the root to a leaf or between nodes.</li>
</ul>
<h3><strong>3. Types of Trees</strong></h3>
<h4><strong>Binary Tree (BT)</strong></h4>
<ul>
    <li>Each node has at most two children (left and right).</li>
    <li>No specific ordering of node values.</li>
</ul>
<h4><strong>Binary Search Tree (BST)</strong></h4>
<ul>
    <li>A special type of binary tree.</li>
    <li>For every node:<ul>
            <li>Left child &lt; Parent</li>
            <li>Right child &gt; Parent</li>
        </ul>
    </li>
    <li>Allows efficient searching, insertion, and deletion.</li>
</ul>
<h4><strong>Self-Balancing Trees</strong></h4>
<ul>
    <li><strong>AVL Tree</strong>: A balanced BST where the height difference between left and right subtrees is at most 1. It uses <strong>rotations</strong> to restore balance.</li>
    <li><strong>Red-Black Tree</strong>: A balanced BST with a relaxed balance property using node colors (red/black) to enforce balance with fewer rotations.</li>
</ul>
<h4><strong>Other Specialized Trees</strong></h4>
<ul>
    <li><strong>Trie (Prefix Tree)</strong>: A tree for storing strings, where each node represents a character. Ideal for autocomplete and dictionary lookups.</li>
    <li><strong>B-Trees</strong>: Used in databases and file systems for efficient indexing and range queries.</li>
</ul>
<hr>
<h3><strong>4. Trees vs. Graphs</strong></h3>
<ul>
    <li><strong>Tree</strong>: A <strong>directed acyclic graph (DAG)</strong>with:<ul>
            <li>One <strong>root node</strong>.</li>
            <li><strong>No cycles</strong>.</li>
            <li>Each node has <strong>one parent</strong> and <strong>zero or more children</strong>.</li>
        </ul>
    </li>
    <li><strong>Graph</strong>: A general data structure with no strict constraints, allowing multiple paths, cycles, and no specific root.</li>
</ul>
<hr>
<h3><strong>5. Operations on Trees</strong></h3>
<ul>
    <li>
        <p><strong>Search, Insert, Delete</strong>:</p>
        <ul>
            <li>In a balanced tree (like AVL or Red-Black), these operations are typically <strong>O(log n)</strong>.</li>
            <li>In an unbalanced tree, they may degrade to <strong>O(n)</strong> if the tree becomes a linked list.</li>
        </ul>
    </li>
    <li>
        <p><strong>Rotations in AVL Trees</strong>:</p>
        <ul>
            <li>After an insertion or deletion, AVL trees may require <strong>single or double rotations</strong> to maintain balance by adjusting the positions of nodes.</li>
        </ul>
    </li>
</ul>
<hr>
<h3><strong>6. Real-World Applications of Trees</strong></h3>
<ul>
    <li>
        <p><strong>Database Indexing</strong>:</p>
        <ul>
            <li><strong>B-Trees</strong> and <strong>B+ Trees</strong> are used for fast indexing and efficient range queries in databases.</li>
        </ul>
    </li>
    <li>
        <p><strong>File Systems</strong>:</p>
        <ul>
            <li><strong>B-Trees</strong> are used to organize directories and files, making lookups fast even in large datasets.</li>
        </ul>
    </li>
    <li>
        <p><strong>Priority Queues</strong>:</p>
        <ul>
            <li><strong>Heaps</strong> (a type of binary tree) are used in implementing priority queues for algorithms like Dijkstra&rsquo;s shortest path.</li>
        </ul>
    </li>
    <li>
        <p><strong>Memory Management</strong>:</p>
        <ul>
            <li>Balanced trees are used to manage free memory blocks, ensuring efficient allocation and deallocation.</li>
        </ul>
    </li>
    <li>
        <p><strong>Autocomplete and Spell Check</strong>:</p>
        <ul>
            <li><strong>Tries</strong> store strings efficiently and enable fast prefix searches, often used in search engines and spell-check tools.</li>
        </ul>
    </li>
</ul>

        1
       / \
      2   3
     / \
    4   5

<h3>Traversal Orders:</h3>
<ol>
    <li>
        <p><strong>Preorder (Root &rarr; Left &rarr; Right)</strong>:<br>Visit root, then left subtree, then right subtree.<br><strong>Output</strong>: <code>1, 2, 4, 5, 3</code></p>
    </li>
    <li>
        <p><strong>Inorder (Left &rarr; Root &rarr; Right)</strong>:<br>Visit left subtree, then root, then right subtree.<br><strong>Output</strong>: <code>4, 2, 5, 1, 3</code></p>
    </li>
    <li>
        <p><strong>Postorder (Left &rarr; Right &rarr; Root)</strong>:<br>Visit left subtree, then right subtree, then root.<br><strong>Output</strong>: <code>4, 5, 2, 3, 1</code></p>
    </li>
    <li>
        <p><strong>Level-order (Breadth-First)</strong>:<br>Visit nodes level by level.<br><strong>Output</strong>: <code>1, 2, 3, 4, 5</code></p>
    </li>
</ol>