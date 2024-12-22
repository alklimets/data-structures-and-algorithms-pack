<p><strong><span style="font-size: 13.5pt; font-family: 'Times New Roman',serif;">Overview</span></strong></p>
<ul>
<li><strong><span style="font-family: 'Times New Roman',serif;">Definition</span></strong><span style="font-family: 'Times New Roman',serif;">:<br />A <strong>stack</strong> is a data structure that follows the <strong>Last In, First Out (LIFO)</strong> principle, meaning the last element added is the first one to be removed. It operates like a stack of plates: the last plate placed on top is the first one you take off.</span></li>
<li><strong><span style="font-family: 'Times New Roman',serif;">Basic Operations</span></strong><span style="font-family: 'Times New Roman',serif;">:</span></li>
<ol>
<li><strong><span style="font-family: 'Times New Roman',serif;">Push</span></strong><span style="font-family: 'Times New Roman',serif;">: Adds an element to the top of the stack.</span></li>
<li><strong><span style="font-family: 'Times New Roman',serif;">Pop</span></strong><span style="font-family: 'Times New Roman',serif;">: Removes the top element of the stack.</span></li>
<li><strong><span style="font-family: 'Times New Roman',serif;">Peek</span></strong><span style="font-family: 'Times New Roman',serif;"> (or Top): Retrieves the top element without removing it.</span></li>
</ol>
<li><strong><span style="font-family: 'Times New Roman',serif;">Time Complexity</span></strong><span style="font-family: 'Times New Roman',serif;">:<br />All basic operations (push, pop, peek) take <strong>O(1)</strong> time, because you only interact with the top of the stack, regardless of its size.</span></li>
</ul>
<p style="text-align: center;"><span style="font-family: 'Times New Roman',serif;"> </span></p>
<p><strong><span style="font-size: 13.5pt; font-family: 'Times New Roman',serif;">Common Implementations</span></strong></p>
<ol>
<li><strong><span style="font-family: 'Times New Roman',serif;">Array-based Implementation</span></strong><span style="font-family: 'Times New Roman',serif;">:<br />A stack can be implemented using an array, where the top is tracked by an index. This allows O(1) time complexity for push and pop operations.</span></li>
<li><strong><span style="font-family: 'Times New Roman',serif;">Linked List-based Implementation</span></strong><span style="font-family: 'Times New Roman',serif;">:<br />Another way to implement a stack is by using a linked list, where the head of the list acts as the top of the stack. This also results in O(1) time complexity for operations.</span></li>
</ol>
<p style="text-align: center;"><span style="font-family: 'Times New Roman',serif;"> </span></p>
<p><strong><span style="font-size: 13.5pt; font-family: 'Times New Roman',serif;">Advanced Topics</span></strong></p>
<ol>
<li><strong><span style="font-family: 'Times New Roman',serif;">Stack Implementation Using Two Queues</span></strong><span style="font-family: 'Times New Roman',serif;">:</span></li>
<ul>
<li><strong><span style="font-family: 'Times New Roman',serif;">Push</span></strong><span style="font-family: 'Times New Roman',serif;">: Enqueue elements into the first queue.</span></li>
<li><strong><span style="font-family: 'Times New Roman',serif;">Pop</span></strong><span style="font-family: 'Times New Roman',serif;">: Dequeue elements from the first queue to the second queue and remove the last element.</span></li>
<li><strong><span style="font-family: 'Times New Roman',serif;">Time Complexity</span></strong><span style="font-family: 'Times New Roman',serif;">:</span></li>
<ul>
<li><span style="font-family: 'Times New Roman',serif;">Method 1 (Push O(n), Pop O(1))</span></li>
<li><span style="font-family: 'Times New Roman',serif;">Method 2 (Push O(1), Pop O(n))</span></li>
</ul>
</ul>
</ol>
<p style="margin-left: 36.0pt;"><span style="font-family: 'Times New Roman',serif;">While it's a valid approach, it's not optimal because the time complexity for at least one of the operations will be O(n).</span></p>
<ol>
<li><strong><span style="font-family: 'Times New Roman',serif;">Balanced Parentheses Problem</span></strong><span style="font-family: 'Times New Roman',serif;">:</span></li>
<ul>
<li><strong><span style="font-family: 'Times New Roman',serif;">Problem</span></strong><span style="font-family: 'Times New Roman',serif;">: Check if parentheses in a string are balanced.</span></li>
<li><strong><span style="font-family: 'Times New Roman',serif;">Stack-based Solution</span></strong><span style="font-family: 'Times New Roman',serif;">:<br />Traverse the string, push opening parentheses onto the stack, and for each closing parenthesis, check if the top of the stack has the matching opening parenthesis.</span></li>
</ul>
<li><strong><span style="font-family: 'Times New Roman',serif;">Next Greater Element Problem</span></strong><span style="font-family: 'Times New Roman',serif;">:</span></li>
<ul>
<li><strong><span style="font-family: 'Times New Roman',serif;">Problem</span></strong><span style="font-family: 'Times New Roman',serif;">: For each element in the array, find the next element that is larger.</span></li>
<li><strong><span style="font-family: 'Times New Roman',serif;">Stack-based Solution</span></strong><span style="font-family: 'Times New Roman',serif;">:<br />Traverse the array from right to left, use a stack to track larger elements, and find the next greater element for each element in the array.</span></li>
</ul>
<li><strong><span style="font-family: 'Times New Roman',serif;">Max Stack</span></strong><span style="font-family: 'Times New Roman',serif;">:</span></li>
<ul>
<li><strong><span style="font-family: 'Times New Roman',serif;">Problem</span></strong><span style="font-family: 'Times New Roman',serif;">: Design a stack that supports push, pop, and retrieving the maximum element in constant time.</span></li>
<li><strong><span style="font-family: 'Times New Roman',serif;">Solution</span></strong><span style="font-family: 'Times New Roman',serif;">:<br />Use two stacks: one for storing the elements and another for tracking the maximum element at each point. The top of the second stack will always hold the current maximum.</span></li>
</ul>
</ol>
<p style="text-align: center;"><span style="font-family: 'Times New Roman',serif;"> </span></p>
<p><strong><span style="font-size: 13.5pt; font-family: 'Times New Roman',serif;">Key Points to Remember</span></strong></p>
<ol>
<li><strong><span style="font-family: 'Times New Roman',serif;">Time Complexity</span></strong><span style="font-family: 'Times New Roman',serif;"> for basic operations is O(1).</span></li>
<li><strong><span style="font-family: 'Times New Roman',serif;">Stack</span></strong><span style="font-family: 'Times New Roman',serif;"> is primarily used for problems where you need to access the most recently added element (LIFO order).</span></li>
<li><strong><span style="font-family: 'Times New Roman',serif;">Advanced problems</span></strong><span style="font-family: 'Times New Roman',serif;"> like balanced parentheses and next greater element can be solved efficiently using stacks.</span></li>
</ol>
<p><br /><br /></p>