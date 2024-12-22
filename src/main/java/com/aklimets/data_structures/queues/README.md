<p><strong><span style="font-size: 13.5pt; font-family: 'Times New Roman',serif;">Definition:</span></strong></p>
<p><span style="font-family: 'Times New Roman',serif;">A <strong>queue</strong> is a data structure that follows the <strong>First-In-First-Out (FIFO)</strong> principle, where elements are added at one end (rear) and removed from the other end (front). This ensures that the first element inserted is the first one to be removed.</span></p>
<p><strong><span style="font-size: 13.5pt; font-family: 'Times New Roman',serif;">Key Features:</span></strong></p>
<ul>
<li><strong><span style="font-family: 'Times New Roman',serif;">FIFO</span></strong><span style="font-family: 'Times New Roman',serif;">: First element in the queue is the first one to leave.</span></li>
<li><span style="font-family: 'Times New Roman',serif;">Supports sequential processing of elements.</span></li>
</ul>
<p><strong><span style="font-size: 13.5pt; font-family: 'Times New Roman',serif;">Main Operations:</span></strong></p>
<ol>
<li><strong><span style="font-family: 'Times New Roman',serif;">Enqueue</span></strong><span style="font-family: 'Times New Roman',serif;">: Add an element to the rear of the queue.</span></li>
<ul>
<li><span style="font-family: 'Times New Roman',serif;">Complexity: O(1)</span></li>
</ul>
<li><strong><span style="font-family: 'Times New Roman',serif;">Dequeue</span></strong><span style="font-family: 'Times New Roman',serif;">: Remove an element from the front of the queue.</span></li>
<ul>
<li><span style="font-family: 'Times New Roman',serif;">Complexity: O(1)</span></li>
</ul>
<li><strong><span style="font-family: 'Times New Roman',serif;">Peek/Front</span></strong><span style="font-family: 'Times New Roman',serif;">: View the front element without removing it.</span></li>
<ul>
<li><span style="font-family: 'Times New Roman',serif;">Complexity: O(1)</span></li>
</ul>
<li><strong><span style="font-family: 'Times New Roman',serif;">IsEmpty</span></strong><span style="font-family: 'Times New Roman',serif;">: Check if the queue is empty.</span></li>
<ul>
<li><span style="font-family: 'Times New Roman',serif;">Complexity: O(1)</span></li>
</ul>
</ol>
<p><strong><span style="font-size: 13.5pt; font-family: 'Times New Roman',serif;">Variations of Queues:</span></strong></p>
<ol>
<li><strong><span style="font-family: 'Times New Roman',serif;">Circular Queue</span></strong><span style="font-family: 'Times New Roman',serif;">:</span></li>
<ul>
<li><span style="font-family: 'Times New Roman',serif;">The last position connects back to the first, forming a circle.</span></li>
<li><span style="font-family: 'Times New Roman',serif;">Useful for <strong>fixed-size storage</strong> and <strong>memory-efficient operations</strong>.</span></li>
<li><span style="font-family: 'Times New Roman',serif;">Applications: Printer spooling, OS task scheduling, bounded buffers.</span></li>
</ul>
<li><strong><span style="font-family: 'Times New Roman',serif;">Double-Ended Queue (Deque)</span></strong><span style="font-family: 'Times New Roman',serif;">:</span></li>
<ul>
<li><span style="font-family: 'Times New Roman',serif;">Allows insertion and deletion at both ends (front and rear).</span></li>
<li><span style="font-family: 'Times New Roman',serif;">Can simulate both a stack and a queue.</span></li>
<li><span style="font-family: 'Times New Roman',serif;">Applications: Palindrome checking, sliding window problems.</span></li>
</ul>
<li><strong><span style="font-family: 'Times New Roman',serif;">Priority Queue</span></strong><span style="font-family: 'Times New Roman',serif;">:</span></li>
<ul>
<li><span style="font-family: 'Times New Roman',serif;">Each element is associated with a priority.</span></li>
<li><span style="font-family: 'Times New Roman',serif;">Elements with higher priority are dequeued before elements with lower priority.</span></li>
<li><span style="font-family: 'Times New Roman',serif;">Applications: Task scheduling, Dijkstra&rsquo;s shortest path algorithm.</span></li>
</ul>
</ol>
<p><strong><span style="font-size: 13.5pt; font-family: 'Times New Roman',serif;">Real-World Use Cases:</span></strong></p>
<ol>
<li><strong><span style="font-family: 'Times New Roman',serif;">Message Queues</span></strong><span style="font-family: 'Times New Roman',serif;">:</span></li>
<ul>
<li><span style="font-family: 'Times New Roman',serif;">Store and process messages in order (e.g., email systems, job queues).</span></li>
</ul>
<li><strong><span style="font-family: 'Times New Roman',serif;">Task Scheduling</span></strong><span style="font-family: 'Times New Roman',serif;">:</span></li>
<ul>
<li><span style="font-family: 'Times New Roman',serif;">CPU and I/O task scheduling.</span></li>
</ul>
<li><strong><span style="font-family: 'Times New Roman',serif;">Breadth-First Search (BFS)</span></strong><span style="font-family: 'Times New Roman',serif;">:</span></li>
<ul>
<li><span style="font-family: 'Times New Roman',serif;">Used in graph traversal algorithms.</span></li>
</ul>
<li><strong><span style="font-family: 'Times New Roman',serif;">Data Buffers</span></strong><span style="font-family: 'Times New Roman',serif;">:</span></li>
<ul>
<li><span style="font-family: 'Times New Roman',serif;">For streaming or IO devices.</span></li>
</ul>
</ol>
<p><strong><span style="font-size: 13.5pt; font-family: 'Times New Roman',serif;">Implementing a Queue:</span></strong></p>
<ol>
<li><strong><span style="font-family: 'Times New Roman',serif;">Using Arrays</span></strong><span style="font-family: 'Times New Roman',serif;">:</span></li>
<ul>
<li><span style="font-family: 'Times New Roman',serif;">Fixed size; straightforward implementation.</span></li>
<li><span style="font-family: 'Times New Roman',serif;">Issue: Wasted space if elements are not shifted after dequeue.</span></li>
</ul>
<li><strong><span style="font-family: 'Times New Roman',serif;">Using Linked Lists</span></strong><span style="font-family: 'Times New Roman',serif;">:</span></li>
<ul>
<li><span style="font-family: 'Times New Roman',serif;">Dynamically allocated memory; efficient for dynamic queues.</span></li>
<li><span style="font-family: 'Times New Roman',serif;">Nodes store data and a pointer to the next node.</span></li>
</ul>
<li><strong><span style="font-family: 'Times New Roman',serif;">Using Two Stacks</span></strong><span style="font-family: 'Times New Roman',serif;">:</span></li>
<ul>
<li><span style="font-family: 'Times New Roman',serif;">Simulates queue behavior with stacks:</span></li>
<ul>
<li><strong><span style="font-family: 'Times New Roman',serif;">Approach 1</span></strong><span style="font-family: 'Times New Roman',serif;">: Optimize enqueue; transfer elements during dequeue.</span></li>
<li><strong><span style="font-family: 'Times New Roman',serif;">Approach 2</span></strong><span style="font-family: 'Times New Roman',serif;">: Optimize dequeue; transfer elements during enqueue.</span></li>
</ul>
</ul>
</ol>
<p><strong><span style="font-size: 13.5pt; font-family: 'Times New Roman',serif;">Advanced Topics:</span></strong></p>
<ol>
<li><strong><span style="font-family: 'Times New Roman',serif;">Queue Using Two Stacks</span></strong><span style="font-family: 'Times New Roman',serif;">:</span></li>
<ul>
<li><strong><span style="font-family: 'Times New Roman',serif;">Optimized for Enqueue</span></strong><span style="font-family: 'Times New Roman',serif;">:</span></li>
<ul>
<li><span style="font-family: 'Times New Roman',serif;">Push new elements to Stack 1 (O(1)).</span></li>
<li><span style="font-family: 'Times New Roman',serif;">On dequeue, move elements from Stack 1 to Stack 2 (O(n)) only if Stack 2 is empty.</span></li>
</ul>
<li><strong><span style="font-family: 'Times New Roman',serif;">Optimized for Dequeue</span></strong><span style="font-family: 'Times New Roman',serif;">:</span></li>
<ul>
<li><span style="font-family: 'Times New Roman',serif;">Push all elements to Stack 2 during enqueue (O(n)), making dequeues (O(1)).</span></li>
</ul>
</ul>
<li><strong><span style="font-family: 'Times New Roman',serif;">Circular Queue Advantages</span></strong><span style="font-family: 'Times New Roman',serif;">:</span></li>
<ul>
<li><span style="font-family: 'Times New Roman',serif;">Avoids wasted space in array-based queues.</span></li>
<li><span style="font-family: 'Times New Roman',serif;">Efficient for <strong>fixed-size applications</strong> like bounded buffers.</span></li>
</ul>
<li><strong><span style="font-family: 'Times New Roman',serif;">Double-Ended Queue (Deque)</span></strong><span style="font-family: 'Times New Roman',serif;">:</span></li>
<ul>
<li><span style="font-family: 'Times New Roman',serif;">Supports insertion and deletion at both ends efficiently.</span></li>
<li><span style="font-family: 'Times New Roman',serif;">Useful for problems requiring both FIFO and LIFO behavior.</span></li>
</ul>
</ol>
<p><strong><span style="font-size: 13.5pt; font-family: 'Times New Roman',serif;">Complexity Overview:</span></strong></p>
<table>
<tbody>
<tr>
<td style="padding: .75pt .75pt .75pt .75pt;">
<p style="text-align: center;"><strong><span style="font-family: 'Times New Roman',serif;">Operation</span></strong></p>
</td>
<td style="padding: .75pt .75pt .75pt .75pt;">
<p style="text-align: center;"><strong><span style="font-family: 'Times New Roman',serif;">Array-Based Queue</span></strong></p>
</td>
<td style="padding: .75pt .75pt .75pt .75pt;">
<p style="text-align: center;"><strong><span style="font-family: 'Times New Roman',serif;">Linked List Queue</span></strong></p>
</td>
<td style="padding: .75pt .75pt .75pt .75pt;">
<p style="text-align: center;"><strong><span style="font-family: 'Times New Roman',serif;">Two Stacks Queue</span></strong></p>
</td>
</tr>
<tr>
<td style="padding: .75pt .75pt .75pt .75pt;">
<p><span style="font-family: 'Times New Roman',serif;">Enqueue (Add)</span></p>
</td>
<td style="padding: .75pt .75pt .75pt .75pt;">
<p><span style="font-family: 'Times New Roman',serif;">O(1)</span></p>
</td>
<td style="padding: .75pt .75pt .75pt .75pt;">
<p><span style="font-family: 'Times New Roman',serif;">O(1)</span></p>
</td>
<td style="padding: .75pt .75pt .75pt .75pt;">
<p><span style="font-family: 'Times New Roman',serif;">O(1)/O(n)</span></p>
</td>
</tr>
<tr>
<td style="padding: .75pt .75pt .75pt .75pt;">
<p><span style="font-family: 'Times New Roman',serif;">Dequeue (Remove)</span></p>
</td>
<td style="padding: .75pt .75pt .75pt .75pt;">
<p><span style="font-family: 'Times New Roman',serif;">O(1)</span></p>
</td>
<td style="padding: .75pt .75pt .75pt .75pt;">
<p><span style="font-family: 'Times New Roman',serif;">O(1)</span></p>
</td>
<td style="padding: .75pt .75pt .75pt .75pt;">
<p><span style="font-family: 'Times New Roman',serif;">O(n)/O(1)</span></p>
</td>
</tr>
<tr>
<td style="padding: .75pt .75pt .75pt .75pt;">
<p><span style="font-family: 'Times New Roman',serif;">Peek (Front)</span></p>
</td>
<td style="padding: .75pt .75pt .75pt .75pt;">
<p><span style="font-family: 'Times New Roman',serif;">O(1)</span></p>
</td>
<td style="padding: .75pt .75pt .75pt .75pt;">
<p><span style="font-family: 'Times New Roman',serif;">O(1)</span></p>
</td>
<td style="padding: .75pt .75pt .75pt .75pt;">
<p><span style="font-family: 'Times New Roman',serif;">O(1)</span></p>
</td>
</tr>
<tr>
<td style="padding: .75pt .75pt .75pt .75pt;">
<p><span style="font-family: 'Times New Roman',serif;">IsEmpty</span></p>
</td>
<td style="padding: .75pt .75pt .75pt .75pt;">
<p><span style="font-family: 'Times New Roman',serif;">O(1)</span></p>
</td>
<td style="padding: .75pt .75pt .75pt .75pt;">
<p><span style="font-family: 'Times New Roman',serif;">O(1)</span></p>
</td>
<td style="padding: .75pt .75pt .75pt .75pt;">
<p><span style="font-family: 'Times New Roman',serif;">O(1)</span></p>
</td>
</tr>
</tbody>
</table>