<p><span >Definition &amp; Types</span></p>
<ul>
<li><span >: A linear data structure where elements (nodes) are stored non-contiguously, and each node contains:</span></li>
<ol>
<li><span>: The value stored in the node.</span></li>
<li><span >: A reference to the next (and in some cases, the previous) node in the list.</span></li>
</ol>
<li><span >:</span></li>
</ul>
<ul>
<ol>
<li><span >: Each node contains a reference to the next node.</span></li>
<li><span >: Each node contains references to both the next and previous nodes.</span></li>
<li><span >: The last node&rsquo;s next pointer points back to the first node (can be singly or doubly linked).</span></li>
</ol>
</ul>
<p><span >Basic Operations and Time Complexities</span></p>
<ul>
<li><span >:</span></li>
<ul>
<li><span >: O(1) &ndash; Simple update of head pointer.</span></li>
<li><span >: O(n) &ndash; Need to traverse to the required position first.</span></li>
</ul>
<li><span >:</span></li>
<ul>
<li><span >: O(1) &ndash; Update head pointer.</span></li>
<li><span >: O(n) &ndash; Need to find the node and update neighboring pointers.</span></li>
</ul>
<li><span >:</span></li>
<ul>
<li><span >: O(n) &ndash; Linear traversal required to reach the index.</span></li>
</ul>
</ul>
<p><span >Advanced Concepts</span></p>
<ul>
<li><span >:</span></li>
<ul>
<li><span >Use two-pointer technique (Floyd&rsquo;s Tortoise and Hare) to detect cycles in a linked list.</span></li>
<li><span >If the list has a cycle, the fast pointer will meet the slow pointer.</span></li>
</ul>
<li><span >:</span></li>
<ul>
<li><span >Can be done in place with O(n) time and O(1) space by iterating through the list and reversing the links between nodes.</span></li>
</ul>
<li><span >:</span></li>
<ul>
<li><span >Use the two-pointer technique: One pointer moves one step at a time, the other moves two steps at a time. When the fast pointer reaches the end, the slow pointer will be at the middle element.</span></li>
</ul>
<li><span >:</span></li>
<ul>
<li><span > steps ahead. Then move both pointers one step at a time until the first pointer reaches the end. The second pointer will then be at the N-th node from the end.</span></li>
</ul>
<li><span >:</span></li>
<ul>
<li><span >: Can traverse both forwards and backwards. Easier insertion and deletion in the middle because of access to both next and previous nodes.</span></li>
<li><span > points to previous node).</span></li>
</ul>
</ul>
<p><span >Strengths &amp; Weaknesses</span></p>
<ul>
<li><span >:</span></li>
<ul>
<li><span >Efficient insertion and deletion at the beginning and middle (compared to arrays).</span></li>
<li><span >Flexible memory usage (nodes are not contiguous).</span></li>
<li><span > allow easy bidirectional traversal.</span></li>
</ul>
<li><span >:</span></li>
<ul>
<li><span > is slower than arrays (O(n) vs. O(1)).</span></li>
<li><span >Requires additional memory for pointers (next/prev references).</span></li>
<li><span > require more memory and complexity due to additional references.</span></li>
</ul>
</ul>
<p><span >Common Applications</span></p>
<ul>
<li><span >Implementing queues and stacks (can be done efficiently with linked lists).</span></li>
<li><span >: Used in dynamic memory allocation where data needs to be allocated and freed without contiguous blocks.</span></li>
<li><span >: Used in adjacency lists.</span></li>
</ul>