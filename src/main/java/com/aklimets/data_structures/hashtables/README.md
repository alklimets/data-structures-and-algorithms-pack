<p><strong><span style="font-family: 'Times New Roman',serif;">Description:</span></strong></p>
<ul>
<li><span style="font-family: 'Times New Roman',serif;">A <strong>hash table</strong> is a data structure that stores key-value pairs.</span></li>
<li><span style="font-family: 'Times New Roman',serif;">Keys are transformed into an <strong>index</strong> (or position) in an underlying array using a <strong>hash function</strong>.</span></li>
<li><span style="font-family: 'Times New Roman',serif;">Hash tables allow for fast data retrieval, insertion, and deletion.</span></li>
<li><span style="font-family: 'Times New Roman',serif;">If multiple keys map to the same index (a <strong>collision</strong>), techniques like <strong>chaining</strong> or <strong>open addressing</strong> are used to resolve the conflict.</span></li>
</ul>
<p style="text-align: center;"><span style="font-family: 'Times New Roman',serif;"> </span></p>
<p><strong><span style="font-family: 'Times New Roman',serif;">Core Operations and Time Complexity:</span></strong></p>
<table>
<thead>
<tr>
<td style="padding: .75pt .75pt .75pt .75pt;">
<p style="text-align: center;"><strong><span style="font-family: 'Times New Roman',serif;">Operation</span></strong></p>
</td>
<td style="padding: .75pt .75pt .75pt .75pt;">
<p style="text-align: center;"><strong><span style="font-family: 'Times New Roman',serif;">Average Case</span></strong></p>
</td>
<td style="padding: .75pt .75pt .75pt .75pt;">
<p style="text-align: center;"><strong><span style="font-family: 'Times New Roman',serif;">Worst Case</span></strong></p>
</td>
</tr>
</thead>
<tbody>
<tr>
<td style="padding: .75pt .75pt .75pt .75pt;">
<p><strong><span style="font-family: 'Times New Roman',serif;">Insertion</span></strong></p>
</td>
<td style="padding: .75pt .75pt .75pt .75pt;">
<p><span style="font-family: 'Times New Roman',serif;">O(1)</span></p>
</td>
<td style="padding: .75pt .75pt .75pt .75pt;">
<p><span style="font-family: 'Times New Roman',serif;">O(n)</span></p>
</td>
</tr>
<tr>
<td style="padding: .75pt .75pt .75pt .75pt;">
<p><strong><span style="font-family: 'Times New Roman',serif;">Search</span></strong></p>
</td>
<td style="padding: .75pt .75pt .75pt .75pt;">
<p><span style="font-family: 'Times New Roman',serif;">O(1)</span></p>
</td>
<td style="padding: .75pt .75pt .75pt .75pt;">
<p><span style="font-family: 'Times New Roman',serif;">O(n)</span></p>
</td>
</tr>
<tr>
<td style="padding: .75pt .75pt .75pt .75pt;">
<p><strong><span style="font-family: 'Times New Roman',serif;">Deletion</span></strong></p>
</td>
<td style="padding: .75pt .75pt .75pt .75pt;">
<p><span style="font-family: 'Times New Roman',serif;">O(1)</span></p>
</td>
<td style="padding: .75pt .75pt .75pt .75pt;">
<p><span style="font-family: 'Times New Roman',serif;">O(n)</span></p>
</td>
</tr>
</tbody>
</table>
<ul>
<li><span style="font-family: 'Times New Roman',serif;">The <strong>worst-case O(n)</strong> occurs when there are excessive collisions, often due to poor hash functions or very high load factors.</span></li>
</ul>
<p><strong><span style="font-family: 'Times New Roman',serif;">Key Concepts:</span></strong></p>
<ol>
<li><strong><span style="font-family: 'Times New Roman',serif;">Hash Function</span></strong><span style="font-family: 'Times New Roman',serif;">:</span></li>
<ul>
<li><span style="font-family: 'Times New Roman',serif;">Converts a key into an index in the array.</span></li>
<li><span style="font-family: 'Times New Roman',serif;">A good hash function spreads keys evenly to reduce collisions.</span></li>
<li><span style="font-family: 'Times New Roman',serif;">Poor hash functions can cause clustering or many collisions.</span></li>
</ul>
<li><strong><span style="font-family: 'Times New Roman',serif;">Collision Resolution</span></strong><span style="font-family: 'Times New Roman',serif;">:</span></li>
<ul>
<li><strong><span style="font-family: 'Times New Roman',serif;">Chaining</span></strong><span style="font-family: 'Times New Roman',serif;">:</span></li>
<ul>
<li><span style="font-family: 'Times New Roman',serif;">Stores multiple values at the same index using linked lists or trees.</span></li>
<li><span style="font-family: 'Times New Roman',serif;">Easy to implement but uses more memory.</span></li>
</ul>
<li><strong><span style="font-family: 'Times New Roman',serif;">Open Addressing</span></strong><span style="font-family: 'Times New Roman',serif;">:</span></li>
<ul>
<li><span style="font-family: 'Times New Roman',serif;">Searches for the next available spot in the array if a collision occurs.</span></li>
<li><span style="font-family: 'Times New Roman',serif;">Includes techniques like linear probing or double hashing.</span></li>
</ul>
</ul>
<li><strong><span style="font-family: 'Times New Roman',serif;">Load Factor</span></strong><span style="font-family: 'Times New Roman',serif;">:</span></li>
<ul>
<li><span style="font-family: 'Times New Roman',serif;">Represents how full the hash table is.</span></li>
<li><span style="font-family: 'Times New Roman',serif;">A higher load factor increases collisions.</span></li>
<li><span style="font-family: 'Times New Roman',serif;">Most implementations resize the table when it becomes too full.</span></li>
</ul>
<li><strong><span style="font-family: 'Times New Roman',serif;">Resizing</span></strong><span style="font-family: 'Times New Roman',serif;">:</span></li>
<ul>
<li><span style="font-family: 'Times New Roman',serif;">When the table is too full, it is resized (usually doubled) to reduce collisions.</span></li>
<li><span style="font-family: 'Times New Roman',serif;">Resizing involves rehashing all elements into the new table.</span></li>
<li><span style="font-family: 'Times New Roman',serif;">This is a slow operation, but it happens infrequently.</span></li>
</ul>
<li><strong><span style="font-family: 'Times New Roman',serif;">Backward Resizing</span></strong><span style="font-family: 'Times New Roman',serif;">:</span></li>
<ul>
<li><span style="font-family: 'Times New Roman',serif;">Rarely used but can reclaim memory by shrinking the table when it becomes too empty.</span></li>
</ul>
</ol>
<p style="text-align: center;"><span style="font-family: 'Times New Roman',serif;"> </span></p>
<p><strong><span style="font-family: 'Times New Roman',serif;">Applications:</span></strong></p>
<ul>
<li><strong><span style="font-family: 'Times New Roman',serif;">Key-Value Storage</span></strong><span style="font-family: 'Times New Roman',serif;">: Quick lookup and retrieval using unique keys, such as storing user data by ID.</span></li>
<li><strong><span style="font-family: 'Times New Roman',serif;">Caching</span></strong><span style="font-family: 'Times New Roman',serif;">: Storing results of expensive operations for quick access.</span></li>
<li><strong><span style="font-family: 'Times New Roman',serif;">Frequency Counting</span></strong><span style="font-family: 'Times New Roman',serif;">: Tracking occurrences of words, numbers, or items.</span></li>
<li><strong><span style="font-family: 'Times New Roman',serif;">Routing Tables</span></strong><span style="font-family: 'Times New Roman',serif;">: Mapping network addresses to specific routes.</span></li>
</ul>
<p style="text-align: center;"><span style="font-family: 'Times New Roman',serif;"> </span></p>
<p><strong><span style="font-family: 'Times New Roman',serif;">Advanced Concepts:</span></strong></p>
<ol>
<li><strong><span style="font-family: 'Times New Roman',serif;">Consistent Hashing</span></strong><span style="font-family: 'Times New Roman',serif;">:</span></li>
<ul>
<li><span style="font-family: 'Times New Roman',serif;">Used in distributed systems to spread data across nodes.</span></li>
<li><span style="font-family: 'Times New Roman',serif;">Minimizes data redistribution when nodes are added or removed.</span></li>
</ul>
<li><strong><span style="font-family: 'Times New Roman',serif;">Universal Hashing</span></strong><span style="font-family: 'Times New Roman',serif;">:</span></li>
<ul>
<li><span style="font-family: 'Times New Roman',serif;">Randomly selects a hash function to reduce the chance of collisions.</span></li>
</ul>
</ol>
<p style="text-align: center;"><span style="font-family: 'Times New Roman',serif;"> </span></p>
<p><strong><span style="font-family: 'Times New Roman',serif;">Advantages:</span></strong></p>
<ul>
<li><span style="font-family: 'Times New Roman',serif;">Very fast for most operations.</span></li>
<li><span style="font-family: 'Times New Roman',serif;">Flexible for various applications requiring key-value mapping.</span></li>
<li><span style="font-family: 'Times New Roman',serif;">Handles dynamic and unordered data effectively.</span></li>
</ul>
<p><strong><span style="font-family: 'Times New Roman',serif;">Disadvantages:</span></strong></p>
<ul>
<li><span style="font-family: 'Times New Roman',serif;">Can waste memory if sparsely populated or resized too often.</span></li>
<li><span style="font-family: 'Times New Roman',serif;">Performance depends heavily on the quality of the hash function.</span></li>
<li><span style="font-family: 'Times New Roman',serif;">Does not maintain any ordering of keys or values.</span></li>
</ul>