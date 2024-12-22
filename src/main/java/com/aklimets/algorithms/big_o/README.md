<h1>Overview of Big O Notation</h1>
<p>Big O notation is a mathematical concept used to describe the <strong>performance</strong> or <strong>complexity</strong> of an algorithm, specifically in terms of its <strong>time complexity</strong> or <strong>space complexity</strong>. It expresses the worst-case scenario as a function of the input size <code>n</code>, allowing us to analyze how the algorithm's running time or space requirements grow as the input size increases.</p>

<h2>Key Points</h2>
<ul>
    <li><strong>Big O</strong> measures the upper bound of an algorithm’s growth rate.</li>
    <li>It helps compare the efficiency of different algorithms.</li>
    <li>We focus on the most significant terms (e.g., discard constant coefficients and lower-order terms).</li>
</ul>

<h2>Common Time Complexities in Big O Notation</h2>
<ul>
    <li><strong>O(1) – Constant time:</strong> The algorithm's running time is constant, regardless of the input size.
        <ul>
            <li>Example: Accessing an element in an array by index.</li>
        </ul>
    </li>
    <li><strong>O(log n) – Logarithmic time:</strong> The running time grows logarithmically as the input size increases. Typically seen in algorithms that divide the problem in half at each step.
        <ul>
            <li>Example: Binary search in a sorted array.</li>
        </ul>
    </li>
    <li><strong>O(n) – Linear time:</strong> The running time grows linearly with the input size.
        <ul>
            <li>Example: Iterating through all elements in a list.</li>
        </ul>
    </li>
    <li><strong>O(n log n) – Linearithmic time:</strong> Common in efficient sorting algorithms like mergesort and quicksort.
        <ul>
            <li>Example: Mergesort or Heapsort.</li>
        </ul>
    </li>
    <li><strong>O(n^2) – Quadratic time:</strong> The running time grows quadratically as the input size increases. Often seen in algorithms that involve nested loops.
        <ul>
            <li>Example: Bubble sort, selection sort.</li>
        </ul>
    </li>
    <li><strong>O(2^n) – Exponential time:</strong> The running time doubles with each additional input element. Typically occurs in algorithms that solve problems by brute force.
        <ul>
            <li>Example: Solving the traveling salesman problem (TSP) using brute force.</li>
        </ul>
    </li>
    <li><strong>O(n!) – Factorial time:</strong> The running time grows factorially with the input size. This is very inefficient and typically found in problems that require checking every possible permutation.
        <ul>
            <li>Example: Solving the traveling salesman problem by checking all permutations.</li>
        </ul>
    </li>
</ul>

<h2>How to Calculate Big O Notation</h2>
<ol>
    <li><strong>Identify the number of operations:</strong> Look at the algorithm’s structure and count the operations it performs.</li>
    <li><strong>Focus on the highest-order term:</strong> When multiple terms appear, only the term with the largest growth rate is relevant. Lower-order terms and constants are discarded.</li>
    <li><strong>Avoid constants:</strong> Constants (like 1/2 or 3) are generally ignored in Big O notation because they don't change the overall rate of growth.</li>
</ol>

<h2>Rules for Simplification</h2>
<ul>
    <li><strong>Constant factors don't matter:</strong>  
        <ul>
            <li><code>O(2n)</code> and <code>O(n)</code> are both simplified to <strong>O(n)</strong>.</li>
            <li><code>O(10n)</code> simplifies to <strong>O(n)</strong>.</li>
        </ul>
    </li>
    <li><strong>Drop lower-order terms:</strong>  
        <ul>
            <li><code>O(n^2 + n)</code> simplifies to <strong>O(n^2)</strong>.</li>
            <li><code>O(n^2 + log n)</code> simplifies to <strong>O(n^2)</strong>.</li>
        </ul>
    </li>
    <li><strong>Ignore constants:</strong>  
        <ul>
            <li><code>O(5n)</code> simplifies to <strong>O(n)</strong>.</li>
        </ul>
    </li>
    <li><strong>When you encounter an expression like <code>O(MN)</code>, where <code>M</code> and <code>N</code> are variables, it's important to understand their significance:</strong>  
        <ul>
            <li>If both <code>M</code> and <code>N</code> represent different input sizes that can change, the time complexity is <strong>O(MN)</strong> and should be left as is.</li>
    <li>If one of the variables is constant (for example, <code>M</code> is a fixed number, like 100), you can treat that constant as a coefficient and simplify the complexity. In such cases, the time complexity becomes <strong>O(N)</strong>.</li>
        </ul>
    </li>
</ul>
